package com.liziyuan.hope.log.manager.core.exception;

public class APIRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 6301465301084131424L;

    public APIRuntimeException() {
        super();
    }

    public APIRuntimeException(String message, Throwable t) {
        super(message, t);
    }

    public APIRuntimeException(String message) {
        super(message);
    }

    public APIRuntimeException(Throwable t) {
        super(t);
    }

}
