package com.liziyuan.hope.log.manager.core.exception;

public class ResourceProxyException extends APISystemRuntimeException{

	public ResourceProxyException(APIReturnCode code, ErrorLevel level) {
		super(code, level);
	}

	public ResourceProxyException(APIReturnCode code, String errorMsg, ErrorLevel level) {
		super(code, errorMsg, null, level);
	}
}
