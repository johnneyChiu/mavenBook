package com.xiaoq.mvnbook.account.account_persist;

import java.io.Closeable;

import org.dom4j.DocumentException;

public class DocumentResource implements Closeable {
	
	private final String msg;
	private final boolean mytemp;
	
	public DocumentResource(boolean myTemp,String msg){
		super();
		this.msg=msg;
		this.mytemp=myTemp;
		
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
