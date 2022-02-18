package com.jumia.exception;

public class JumiaException {

	private String errMsg;
	
	public JumiaException(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
	
}
