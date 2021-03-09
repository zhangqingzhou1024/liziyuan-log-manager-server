package com.liziyuan.hope.log.manager.processor.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liziyuan.hope.log.manager.core.constant.StringConst;
import com.liziyuan.hope.log.manager.core.model.UserOperateLogMsg;
import com.liziyuan.hope.log.manager.core.utils.FieldValueUtils;
import com.liziyuan.hope.log.manager.das.entity.UserOperateLog;
import com.liziyuan.hope.log.manager.das.mapper.UserOperateLogMapper;
import com.liziyuan.hope.log.manager.das.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费子系统logstash-kafka日志消息消费
 *
 * @author zqz
 * @version 1.0
 * @date 2021-02-26 09:35
 */
@Component
@Slf4j
public class KafkaLogstashMsgConsumer {

    @Autowired
    UserOperateLogMapper userOperateLogMapper;

    @KafkaListener(topics = {"${logstash.log.kafka.topic.name}"})
    public void consume(String message) {
        log.info("kafka message: {}", message);
        try {
            if (FieldValueUtils.isNullType(message)) {
                return;
            }
            JSONObject logMsg = JSON.parseObject(message);
            String messageJsonStr = (String) logMsg.get(StringConst.LOG_KAFKA_MESSAGE_KEY);
            if (FieldValueUtils.isNullType(messageJsonStr)) {
                return;
            }

            // 日志入库
            UserOperateLogMsg userOperateLog = JSON.parseObject(messageJsonStr, UserOperateLogMsg.class);
            UserOperateLog operateLog = ModelMapperUtils.map(userOperateLog, UserOperateLog.class);
            userOperateLogMapper.insertSelective(operateLog);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
