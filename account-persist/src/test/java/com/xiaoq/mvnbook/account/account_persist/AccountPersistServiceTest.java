package com.xiaoq.mvnbook.account.account_persist;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)
public class AccountPersistServiceTest {

	private AccountPersistService service;
	
	@Before
	public void prepare()throws Exception{
		File persistDataFile=new File("target/test-classes/persist-data.xml");
		if(persistDataFile.exists())
			persistDataFile.delete();
		ApplicationContext context=new ClassPathXmlApplicationContext("account-persist.xml");
		service=(AccountPersistService)context.getBean("accountPersistService");
		
	}
	
	@Test
	public void test0Account() throws Exception{
		Account account=new Account();
		account.setId("xiaoq");
		account.setName("my name");
		account.setEmail("xiaoq@163.com");
		account.setPassword("ni cai");
		account.setActivated(true);
		service.createAcccount(account);
	}
	
	@Test
	public void test1Account() throws Exception{
		Account account=new Account();
		account.setId("xiaoq");
		account.setName("my name");
		account.setEmail("xiaoq@163.com");
		account.setPassword("ni cai");
		account.setActivated(true);
		service.createAcccount(account);
		account=service.readAcccount("xiaoq");
		assertNotNull(account);
		assertEquals("my name",account.getName());
		assertEquals("xiaoq@163.com",account.getEmail());
		assertEquals("ni cai",account.getPassword());
		assertTrue(account.isActivated());
	}
	@Test
	public void test2Account() throws Exception{
		Account account=new Account();
		account.setId("xiaoq");
		account.setName("my name");
		account.setEmail("xiaoq@163.com");
		account.setPassword("ni cai");
		account.setActivated(true);
		service.createAcccount(account);
		account=service.readAcccount("xiaoq");
		account.setName("xiaomei");
		account=service.updateAcccount(account);
		assertNotNull(account);
		assertEquals("xiaomei",account.getName());
		assertEquals("xiaoq@163.com",account.getEmail());
		assertEquals("ni cai",account.getPassword());
		assertTrue(account.isActivated());
	}
	
	/*@Test
	public void test3Account() throws Exception{
		service.deleteAcccount("xiaomei");
	}
	@Test
	public void test4Account() throws Exception{
		Account account=service.readAcccount("xiaoq");
		assertNull(account);
	}*/
	
}
