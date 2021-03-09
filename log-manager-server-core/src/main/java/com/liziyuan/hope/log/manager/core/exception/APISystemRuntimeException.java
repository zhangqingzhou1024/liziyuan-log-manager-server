package com.liziyuan.hope.log.manager.core.exception;

public class APISystemRuntimeException extends APIRuntimeException {
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Error code */
    private final APIReturnCode code;

    /** Error level */
    private final ErrorLevel level;

    private Object result;

    private String property;

    private String errMessage;


    public APISystemRuntimeException(APIReturnCode code, ErrorLevel level) {
        this(code, null, level);
    }

    public APISystemRuntimeException(APIReturnCode code, String errMessage, Throwable cause, ErrorLevel level) {
        super(errMessage, cause);
        this.code = code;
        this.level = level;
        this.errMessage = errMessage;
    }

    public APISystemRuntimeException(APIReturnCode code, Throwable cause, ErrorLevel level) {
        super(code.getMessage(), cause);
        this.code = code;
        this.level = level;
    }

    public APISystemRuntimeException(APIReturnCode code, ErrorLevel level, String property) {
        this(code, null, level);
        this.property = property;
    }

    public APISystemRuntimeException(APIReturnCode code, String errMessage, Throwable cause, ErrorLevel level, String property) {
        super(errMessage, cause);
        this.code = code;
        this.level = level;
        this.property = property;
    }

    public APISystemRuntimeException(APIReturnCode code, Throwable cause, ErrorLevel level, String property) {
        super(code.getMessage(), cause);
        this.code = code;
        this.level = level;
        this.property = property;
    }

    public APIReturnCode getCode() {
        return code;
    }

    public ErrorLevel getLevel() {
        return level;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
