package com.liziyuan.hope.log.manager.api.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-02 15:21
 */
@SuppressWarnings("rawtypes")
@RestControllerAdvice
@Slf4j
public class UniformExceptionHandler {

    /**
     * 异常绑定及封装返回结果
     *
     * @return 封装后的异常结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UniformReturnResult exceptionHandler(Exception ex) {
        return new UniformReturnResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, ex.getMessage()+"==>"+ex.getCause());
    }
}
