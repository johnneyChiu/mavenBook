package com.xiaoq.mvnbook.account.account_persist;

public interface AccountPersistService {
	Account createAcccount(Account account)throws AcccountPersistException;
	void deleteAcccount(String id)throws AcccountPersistException;
	Account updateAcccount(Account account)throws AcccountPersistException;
	Account readAcccount(String id)throws AcccountPersistException;
}
