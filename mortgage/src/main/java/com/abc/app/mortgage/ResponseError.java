/**
 * 
 */
package com.abc.app.mortgage.util;

/**
 * @author Rambabu Keshetti
 *
 */
public class ResponseError {
	public ResponseError() {
	}

	String msg;
	String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ResponseError(String msg, String code) {
		super();
		this.msg = msg;
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResponseError [msg=" + msg + ", code=" + code + "]";
	}

}
