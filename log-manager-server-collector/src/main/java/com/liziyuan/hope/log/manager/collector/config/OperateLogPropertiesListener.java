package com.liziyuan.hope.log.manager.collector.config;

import com.liziyuan.hope.log.manager.collector.aspect.UserOperateLogCollector;
import com.liziyuan.hope.log.manager.core.constant.StringConst;
import com.liziyuan.hope.log.manager.core.enums.SysModelTypeEnum;
import com.liziyuan.hope.log.manager.core.utils.LoggerUtils;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 配置文件监听器，用来加载自定义配置文件
 *
 * @author zqz
 * @version 1.0
 * @date 2021-02-24 20:48
 */
@Component
public class OperateLogPropertiesListener implements ApplicationListener<ApplicationStartedEvent> {
    /**
     * 文件名和位置必须是固定的这个
     */
    private static final String API_MAPPING_FILE_NAME = "operate-log-collector.properties";

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(">>>>>>>> OperateLogPropertiesListener init starting ...");
        try {
            OperateLogPropertiesUtils.loadAllProperties(API_MAPPING_FILE_NAME);
            boolean isCheckRight = checkOperateLogCollectorConfig();
            if (isCheckRight) {
                String fileDirPath = System.getProperty("user.dir");
                System.out.println(">>>>>>>> 日志管理收集-当前系统运行目录(user.dir)：" + fileDirPath);
                System.out.println(">>>>>>>> 日志管理收集-日志存放目录(相对目录)为：" + OperateLogPropertiesUtils.USER_OPERATE_LOG_PATH);
                try {
                    String filePathName = UserOperateLogCollector.getFilePathName();
                    String filePath = LoggerUtils.createFileIfNotExistsFile(OperateLogPropertiesUtils.USER_OPERATE_LOG_PATH, filePathName);
                    System.out.println(">>>>>>>> 日志管理收集-日志文件存放目录为：" + filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(">>>>>>>> 日志管理收集日志功能开启-成功！");
            } else {
                OperateLogPropertiesUtils.propertiesMap.clear();
                System.out.println(">>>>>>>> 日志管理收集日志功能开启-失败！");
            }
        } catch (Exception e) {
            OperateLogPropertiesUtils.propertiesMap.clear();
            e.printStackTrace();
        }
        System.out.println(">>>>>>>> OperateLogPropertiesListener init end!");
    }


    /**
     * 配置文件参数验证
     */
    private boolean checkOperateLogCollectorConfig() {
        if (CollectionUtils.isEmpty(OperateLogPropertiesUtils.propertiesMap)) {
            System.out.println("日志管理配置文件名必须为：operate-log-collector.properties，当前加载配置项为空，请检查文件是否存在或配置项！");
            return false;
        }
        String sysModelName = OperateLogPropertiesUtils.getProperty(StringConst.SYS_MODEL_NAME_KEY);
        if (StringUtils.isEmpty(sysModelName)) {
            System.out.println("日志管理配置文件【operate-log-collector.properties】文件配置错误，缺乏defSysModelName配置");
            return false;
        }

        SysModelTypeEnum modelTypeEnum = SysModelTypeEnum.getModelTypeByName(sysModelName);
        SysModelTypeEnum[] values = SysModelTypeEnum.values();
        List<String> modelTypeList = Arrays.stream(values).map(SysModelTypeEnum::getModelName).collect(Collectors.toList());
        if (null == modelTypeEnum) {
            System.out.println("日志管理配置文件【operate-log-collector.properties】文件配置错误，defSysModelName配置项(" + sysModelName + ")不正确，值必须为【" + Joiner.on(",").join(modelTypeList) + "】之一！");
            return false;
        }
        OperateLogPropertiesUtils.SYS_MODEL_ID = modelTypeEnum.getId();
        OperateLogPropertiesUtils.SYS_MODEL_CODE = modelTypeEnum.getModelType();
        OperateLogPropertiesUtils.SYS_MODEL_NAME = modelTypeEnum.getModelName();

        String userOperateLogPathVal = OperateLogPropertiesUtils.getProperty(StringConst.USER_OPERATE_LOG_PATH_KEY);
        if (!StringUtils.isEmpty(userOperateLogPathVal)) {
            OperateLogPropertiesUtils.USER_OPERATE_LOG_PATH = userOperateLogPathVal;
        }

        String property = OperateLogPropertiesUtils.getProperty(StringConst.OPERATE_LOG_SYSTEM_OUT_KEY);
        if (StringConst.TRUE_STRING.equals(property)) {
            OperateLogPropertiesUtils.OPERATE_LOG_SYSTEM_OUT = true;
        }

        return true;
    }
}