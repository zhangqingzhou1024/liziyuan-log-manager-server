package com.liziyuan.hope.log.manager.elastic;

import com.liziyuan.hope.log.manager.elastic.entity.EventDocument;
import com.liziyuan.hope.log.manager.elastic.service.EventDocService;
import com.liziyuan.hope.log.manager.elastic.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @autor zhangqingzhou
 * @description
 * @date 2021/5/28
 **/
@SpringBootApplication()
public class MainApplication {
    @PostConstruct
    public void init() {
        // 解决netty启动冲突问题
        // see Netty4Utils.setAvailableProcessors()
       // System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println(">>>>>>>>>>>>>启动成功>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        EventDocService eventDocService = (EventDocService)SpringUtil.getBean("eventDocService");

        EventDocument eventDocument = new EventDocument();
        eventDocument.setId(1);
        eventDocument.setType(2);
        eventDocument.setTitle("hello world!");
        eventDocument.setContent("我爱中国天安门");
        eventDocument.setInsertTime(new Date());
        EventDocument document = eventDocService.save(eventDocument);
        System.out.println("********************** 插入成功 ***************");
        System.out.println(document);
    }
}
