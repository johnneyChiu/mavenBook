package com.xiaoq.mvnBook.helloword;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
	
	@Test
	public void testSayHello(){
		App  app=new App();
		String say=app.sayHello("hello");
		assertEquals("say:hello",say);
	}
}
