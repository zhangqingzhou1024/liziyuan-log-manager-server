package com.liziyuan.hope.log.manager.core.exception;

/**
 * 认证异常
 * @author moqh
 *
 */
public class AuthenticationException extends APISystemRuntimeException {
    private static final long serialVersionUID = 5020494299624728280L;

    public AuthenticationException(APIReturnCode code, ErrorLevel level) {
        super(code, level);
    }

    public AuthenticationException(APIReturnCode code, String errorMsg, ErrorLevel level) {
        super(code, errorMsg, null, level);
    }
}