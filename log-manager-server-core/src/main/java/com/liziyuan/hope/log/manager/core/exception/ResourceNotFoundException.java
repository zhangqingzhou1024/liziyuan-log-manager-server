package com.liziyuan.hope.log.manager.core.exception;

public class ResourceNotFoundException extends APISystemRuntimeException{

	private static final long serialVersionUID = -4687695140345112964L;

	public ResourceNotFoundException(APIReturnCode code, ErrorLevel level) {
		super(code, level);
	}

	public ResourceNotFoundException(APIReturnCode code, String errorMsg, ErrorLevel level) {
		super(code, errorMsg, null, level);
	}
}
