package com.xiaoq.mvnbook.account.account_persist;

import java.io.Closeable;
import java.io.IOException;

public class FileResource implements Closeable {
	
	private final boolean throwInClose;
	private final String name;
	

	public FileResource(boolean throwInConstruction,boolean throwInClose, String name)  throws IOException{
		super();
		if(throwInConstruction)
			throw new IOException("throwing in construction");
		this.throwInClose = throwInClose;
		this.name = name;
	}


	public void close() throws IOException {
		// TODO Auto-generated method stub
		if (throwInClose) {  
            throw new IOException("throwing in close");  
        }  
        System.out.println(name + " is closing...");  
	}

}
