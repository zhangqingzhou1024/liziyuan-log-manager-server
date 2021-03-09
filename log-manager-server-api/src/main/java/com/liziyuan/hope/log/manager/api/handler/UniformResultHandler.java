package com.liziyuan.hope.log.manager.api.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 结果结构封装
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-02 15:21
 */
@RestControllerAdvice
public class UniformResultHandler implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        // 判断响应的Content-Type为JSON格式的body,如果响应返回的对象为统一响应体，则直接返回body
        if (MediaType.APPLICATION_JSON.equals(mediaType) || MediaType.APPLICATION_JSON_UTF8.equals(mediaType)) {
            //swagger接口直接放过
            String url = serverHttpRequest.getURI().getPath();
            if (StringUtils.contains(url, "/v2/api-docs") || StringUtils.contains(url, "swagger")) {
                return object;
            }

            //异常直接返回
            if (object instanceof UniformReturnResult) {
                return object;
            }
            return new UniformReturnResult<>(HttpStatus.OK.value(), true, "请求成功", object);
        }
        return object;
    }
}
