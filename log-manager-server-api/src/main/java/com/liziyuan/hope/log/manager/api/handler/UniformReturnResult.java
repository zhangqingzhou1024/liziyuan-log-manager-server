package com.liziyuan.hope.log.manager.api.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 统一返回结果结构
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-02 15:21
 */
@Data
public class UniformReturnResult<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 成功标志
     */
    private Boolean success;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据实体
     */
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private T data;

    public UniformReturnResult(Integer code, Boolean success, String message) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = null;
    }

    public UniformReturnResult(Integer code, Boolean success, String message, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }
}
