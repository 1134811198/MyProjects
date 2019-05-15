package com.atguigu.spring.tx.exception;

public class UserAccountExcception extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAccountExcception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccountExcception(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserAccountExcception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAccountExcception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAccountExcception(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
