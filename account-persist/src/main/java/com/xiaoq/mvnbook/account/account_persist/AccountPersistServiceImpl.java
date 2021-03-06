package com.xiaoq.mvnbook.account.account_persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AccountPersistServiceImpl implements AccountPersistService {
	
	private final String ELEMENT_ROOT="account-persist";
	private final String ELEMENT_ACCOUNTS="accounts";
	private final String ELEMENT_ACCOUNT="account";
	
	private String file;
	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	private SAXReader reader=new SAXReader();
	
	public Account createAcccount(Account account) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Document document=readDocument();
		Element accountsFile=document.getRootElement().element(ELEMENT_ACCOUNTS);
		transferToElement(account,accountsFile);
		writeDocument(document);
		return account;
	}

	@SuppressWarnings("unchecked")
	public void deleteAcccount(String id) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Document document=readDocument();
		Element accountsFile=document.getRootElement().element(ELEMENT_ACCOUNTS);
		for(Element accountFile:(List<Element>)accountsFile.elements())
		{
			if(!ELEMENT_ACCOUNT.equals(accountFile.getName()))
				continue;
			Attribute attribute=accountFile.attribute("id");
			if(attribute==null||!id.equals(attribute.getText()))
				continue;
			accountsFile.remove(accountFile);
			writeDocument(document);
		}
	}

	@SuppressWarnings("unchecked")
	public Account updateAcccount(Account account) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Document document=readDocument();
		Element accountsFile=document.getRootElement().element(ELEMENT_ACCOUNTS);
		for(Element accountFile:(List<Element>)accountsFile.elements())
		{
			if(!ELEMENT_ACCOUNT.equals(accountFile.getName()))
				continue;
			Attribute attribute=accountFile.attribute("id");
			if(attribute==null||!account.getId().equals(attribute.getText()))
				continue;
			transferToElement(account,accountsFile);
			writeDocument(document);
			break;
			
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	public Account readAcccount(String id) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Document document=readDocument();
		Account account=null;
		Element accountsFile=document.getRootElement().element(ELEMENT_ACCOUNTS);
		for(Element accountFile:(List<Element>)accountsFile.elements())
		{
			if(!ELEMENT_ACCOUNT.equals(accountFile.getName()))
				continue;
			Attribute attribute=accountFile.attribute("id");
			if(attribute==null||!id.equals(attribute.getText()))
				continue;
			account= transferToPO(accountFile);
			break;
			
		}
		return account;
	}
	private Account transferToPO(Element accountFile) throws AcccountPersistException{
		// TODO Auto-generated method stub
		Account account=new Account();
		try{
			account.setId(accountFile.attribute("id").getText());
			account.setName(accountFile.element("name").getText());
			account.setEmail(accountFile.elementText("email"));
			account.setPassword(accountFile.elementText("password"));
			account.setActivated("true".equals(accountFile.elementText("activated")));
			return account;
		}catch (Exception e){
			throw new AcccountPersistException("parse element error",e);
		}
	}
	private void transferToElement(Account account,Element parentElement) throws AcccountPersistException{
		// TODO Auto-generated method stub
		Element element=parentElement.addElement(ELEMENT_ACCOUNT);
		try{
			element.addAttribute("id", account.getId());
			element.addElement("email").setText(account.getEmail());;
			element.addElement("name").setText(account.getName());;
			element.addElement("password").setText(account.getPassword());;
			element.addElement("activated").setText(account.isActivated()?"true":"false");;
		}catch (Exception e){
			throw new AcccountPersistException("parse to element error",e);
		}
	}

	/*private Document readDocument() throws AcccountPersistException{
		File dataFile=new File(file);
		if(!dataFile.exists())
		{
			dataFile.getParentFile().mkdirs();
			Document document=DocumentFactory.getInstance().createDocument();
			Element rootElement=document.addElement(ELEMENT_ROOT);
			rootElement.addElement(ELEMENT_ACCOUNTS);
			writeDocument(document);
		}
		try(DocumentResource resource=new DocumentResource(true,"file exception test")){
			return reader.read(new File(file));
		}catch(DocumentException e){
			throw new AcccountPersistException("unable to read persist data xml", e);
		}
	}
	
	private void writeDocument(Document document) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Writer out=null;
		try(FileResource rescource=new FileResource(false, false, "file exception")){
			out=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			XMLWriter writer= new XMLWriter(out,OutputFormat.createPrettyPrint());
			writer.write(document);
		}catch(IOException e){
			throw new AcccountPersistException("unable to write persist data xml", e);
		}
	}
	*/
	private Document readDocument() throws AcccountPersistException{
		File dataFile=new File(file);
		if(!dataFile.exists())
		{
			dataFile.getParentFile().mkdirs();
			Document document=DocumentFactory.getInstance().createDocument();
			Element rootElement=document.addElement(ELEMENT_ROOT);
			rootElement.addElement(ELEMENT_ACCOUNTS);
			writeDocument(document);
		}
		try{
			return reader.read(new File(file));
		}catch(DocumentException e){
			throw new AcccountPersistException("unable to read persist data xml", e);
		}
	}
	private void writeDocument(Document document) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Writer out=null;
		try{
			out=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			XMLWriter writer= new XMLWriter(out,OutputFormat.createPrettyPrint());
			writer.write(document);
		}catch(IOException e){
			throw new AcccountPersistException("unable to write persist data xml", e);
		}finally{
			try{
				if(out!=null)
					out.close();
			}catch(IOException e){
				throw new AcccountPersistException("unable to close persist data xml", e);
			}
		}
	}

}
