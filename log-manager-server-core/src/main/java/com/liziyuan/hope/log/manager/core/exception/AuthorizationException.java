package com.liziyuan.hope.log.manager.core.exception;

/**
 * 授权异常
 * @author moqh
 *
 */
public class AuthorizationException extends APISystemRuntimeException {
    private static final long serialVersionUID = 5020494299624728280L;

    public AuthorizationException(APIReturnCode code, ErrorLevel level) {
        super(code, level);
    }

    public AuthorizationException(APIReturnCode code, String errorMsg, ErrorLevel level) {
        super(code, errorMsg, null, level);
    }
}
