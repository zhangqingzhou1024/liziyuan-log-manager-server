package com.liziyuan.hope.log.manager.core.exception;

public class ResourceConflictException extends APISystemRuntimeException{

	private static final long serialVersionUID = -7315532810173931725L;

	public ResourceConflictException(APIReturnCode code, ErrorLevel level) {
		super(code, level);
	}

	public ResourceConflictException(APIReturnCode code, String errorMsg, ErrorLevel level) {
		super(code, errorMsg, null, level);
	}

}
