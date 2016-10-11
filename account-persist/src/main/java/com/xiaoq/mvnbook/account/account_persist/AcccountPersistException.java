package com.xiaoq.mvnbook.account.account_persist;

public class AcccountPersistException extends Exception {
	private String msg;
	public AcccountPersistException(String msg,Exception e){
		System.out.println(msg);
		e.printStackTrace();
	}
}
