package com.liziyuan.hope.log.manager.core.exception;

public class DatahubDasException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 17339900531010037L;

	public DatahubDasException(String errorMessage, Object... args) {
        super(String.format(errorMessage, args));
    }

    public DatahubDasException(String errorMessage,Throwable cause) {
        super(errorMessage, cause);
    }
    
    public DatahubDasException(Throwable cause) {
        super(cause);
    }
}
