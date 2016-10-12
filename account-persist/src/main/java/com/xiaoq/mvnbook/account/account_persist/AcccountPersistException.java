package com.xiaoq.mvnbook.account.account_persist;

public class AcccountPersistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2921656644878181819L;
	private String msg;
	public AcccountPersistException(String msg,Exception e){
		System.out.println(msg);
		e.printStackTrace();
	}
}
