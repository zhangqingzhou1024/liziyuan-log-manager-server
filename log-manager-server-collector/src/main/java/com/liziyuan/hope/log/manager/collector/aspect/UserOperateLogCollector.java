package com.liziyuan.hope.log.manager.collector.aspect;


import com.google.gson.Gson;
import com.liziyuan.hope.log.manager.collector.config.OperateLogPropertiesUtils;
import com.liziyuan.hope.log.manager.core.constant.StringConst;
import com.liziyuan.hope.log.manager.core.enums.OperateTypeEnum;
import com.liziyuan.hope.log.manager.core.enums.SysModelTypeEnum;
import com.liziyuan.hope.log.manager.core.model.UserInfo;
import com.liziyuan.hope.log.manager.core.model.UserOperateLogMsg;
import com.liziyuan.hope.log.manager.core.utils.LoggerUtils;
import com.liziyuan.hope.log.manager.core.utils.date.DateHelper;
import com.liziyuan.hope.log.manager.core.utils.user.UserUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 切面 - 打印请求、返回参数信息、请求用时
 *
 * @author zqz
 * @version 1.0
 * @date 2020-12-25 09:21
 */
@Aspect
@Component
public class UserOperateLogCollector {
    private static Map<String, String> methodsMap;

    static {
        methodsMap = OperateLogPropertiesUtils.getAllProperty();
        methodsMap.remove(StringConst.SYS_MODEL_NAME_KEY);
        methodsMap.remove(StringConst.OPERATE_LOG_SYSTEM_OUT_KEY);
        methodsMap.remove(StringConst.USER_OPERATE_LOG_PATH_KEY);
    }


    @Pointcut(LogCollectorAspectConfig.DATA_QUALITY_SERVER_ASPECT_CONF)
    public void dataQualityServer() {
    }

    @Pointcut(LogCollectorAspectConfig.DATA_INTEGRATION_SERVICE_ASPECT_CONF)
    public void dataIntegrationService() {
    }

    @Pointcut(LogCollectorAspectConfig.DATAHUB_CATALOG_SERVER_ASPECT_CONF)
    public void datahubCatalogServer() {
    }


    @Before("dataQualityServer() || dataIntegrationService() || datahubCatalogServer()")
    public void userOperateLogCollector(JoinPoint joinPoint) throws Throwable {
        try {
            if (CollectionUtils.isEmpty(methodsMap)) {
                return;
            }

            if (StringUtils.isEmpty(OperateLogPropertiesUtils.SYS_MODEL_CODE)) {
                return;
            }

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (null == attributes) {
                return;
            }
            Signature signature = joinPoint.getSignature();
            String targetClassName = signature.getDeclaringTypeName();
            String requestMethod = targetClassName + "." + signature.getName();
            String apiOperate = methodsMap.get(requestMethod);
            if (StringUtils.isEmpty(apiOperate)) {
                return;
            }
            String[] methodDesArr = apiOperate.split(StringConst.API_MAPPING_SPIL_CHAR);
            if (methodDesArr.length < 2) {
                if (OperateLogPropertiesUtils.OPERATE_LOG_SYSTEM_OUT) {
                    System.out.println("operate-log-collector.properties 配置不规范，key:" + requestMethod);
                }
                return;
            }
            OperateTypeEnum operateType = OperateTypeEnum.getOperateTypeByName(methodDesArr[0]);
            if (null == operateType) {
                return;
            }

            HttpServletRequest request = attributes.getRequest();
            Date operateTime = new Date();
            String operateTimeStr = DateHelper.dateFormat(operateTime);
            // init log bean
            UserOperateLogMsg userOperateLog = initUserOperateLog(requestMethod, methodDesArr, operateType, request, operateTime, operateTimeStr);

            // 打印请求账号
            try {
                UserInfo userInfo = UserUtils.getUserInfo();
                userOperateLog.setUserAccount(userInfo.getAccount());
                userOperateLog.setUserName(userInfo.getName());
            } catch (Exception e) {
                return;
            }
            // 打印请求入参
            String json = "";
            try {
                Object[] args = joinPoint.getArgs();
                if (!ArrayUtils.isEmpty(args)) {
                    json = new Gson().toJson(args);
                }
            } catch (Exception e) {
                json = "";
            }
            userOperateLog.setRequestParams(json);
            if (OperateLogPropertiesUtils.OPERATE_LOG_SYSTEM_OUT) {
                System.out.println(operateTimeStr + " ==>" + userOperateLog.toString());
            }
            LoggerUtils.writeUserOperateLog(getFilePathName(), userOperateLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * init log bean
     *
     * @return UserOperateLog
     */
    private UserOperateLogMsg initUserOperateLog(String requestMethod, String[] methodDesArr, OperateTypeEnum operateType, HttpServletRequest request, Date operateTime, String operateTimeStr) {
        UserOperateLogMsg userOperateLog = new UserOperateLogMsg();
        userOperateLog.setRequestUrl(request.getRequestURL().toString());
        userOperateLog.setRequestType(request.getMethod());
        userOperateLog.setRequestMethod(requestMethod);
        userOperateLog.setOperateTime(operateTime);

        userOperateLog.setOperateTimeStr(operateTimeStr);
        userOperateLog.setOperateObject(methodDesArr[1]);
        // 操作类型
        userOperateLog.setOperateType(operateType.getOperateType());
        userOperateLog.setOperateTypeId(operateType.getId());

        // 所属模块
        userOperateLog.setSysModelId(OperateLogPropertiesUtils.SYS_MODEL_ID);
        userOperateLog.setSysModelType(OperateLogPropertiesUtils.SYS_MODEL_CODE);
        if (methodDesArr.length > 2) {
            String modelTypeName = methodDesArr[2];
            SysModelTypeEnum modelTypeEnum = SysModelTypeEnum.getModelTypeByName(modelTypeName);
            if (null != modelTypeEnum) {
                userOperateLog.setSysModelId(modelTypeEnum.getId());
                userOperateLog.setSysModelType(modelTypeEnum.getModelType());
            }
        }
        return userOperateLog;
    }

    /**
     * 获取要写入的文件地址
     *
     * @return 获取要写入的文件地址
     */
    public static String getFilePathName() {
        String fileName = StringConst.USER_OPERATE_LOG_FILE_PREFIX + "-" + OperateLogPropertiesUtils.SYS_MODEL_CODE + ".log";
        return OperateLogPropertiesUtils.USER_OPERATE_LOG_PATH + "/" + fileName;
    }
}
