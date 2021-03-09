package com.liziyuan.hope.log.manager.api.aspect;


import com.liziyuan.hope.log.manager.core.utils.user.UserUtils;
import com.liziyuan.hope.log.manager.core.constant.NumberConst;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面 - 打印请求、返回参数信息、请求用时
 *
 * @author zqz
 * @version 1.0
 * @date 2020-12-25 09:21
 */
@Aspect
@Component
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(public * com.liziyuan.hope.log.manager.api.controller..*.*(..))")
    public void webLog() {

    }


    /**
     * 在切点之前织入
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null == attributes) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info(" URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info(" HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info(" Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info(" IP             : {}", request.getRemoteAddr());
        // 打印请求账号
        String account = "";
        try {
            account = UserUtils.getUserInfo().getAccount();
        } catch (Exception e) {
            account = "";
        }
        logger.info(" Request User   : {}", account);
        // 打印请求入参
        String json = null;
        try {
            json = new Gson().toJson(joinPoint.getArgs());
        } catch (Exception e) {
            json = "";
        }
        logger.info(" Request Args   : {}", json);
    }

    /**
     * 在切点之后织入
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        logger.info("=========================================== End ===========================================");
        // 每个请求之间空一行
        logger.info("");
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint proceedingJoinPoint
     * @return 执行结果
     * @throws Throwable 异常信息
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        String json;
        try {
            json = new Gson().toJson(result);
        } catch (Exception e) {
            logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
            return result;
        }
        if (json != null && json.length() < 3 * NumberConst.ONE_THOUSAND) {
            logger.info("Response Args  : {}", json);
        }
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}
