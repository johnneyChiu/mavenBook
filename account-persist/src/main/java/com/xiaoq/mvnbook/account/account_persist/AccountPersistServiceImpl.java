package com.xiaoq.mvnbook.account.account_persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
	
	
	private String file;
	
	private SAXReader reader=new SAXReader();
	
	public Account createAcccount(Account account) throws AcccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAcccount(String id) throws AcccountPersistException {
		// TODO Auto-generated method stub

	}

	public Account updateAcccount(Account account) throws AcccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	public Account readAcccount(String id) throws AcccountPersistException {
		// TODO Auto-generated method stub
		Document document=readDocument();
		Element accountsFile=document.getRootElement().element(ELEMENT_ACCOUNTS);
		for(Element accountFile:(List<Element>)accountsFile.elements());
	}
	
	
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
		try(DocumentResource resource=new DocumentResource(true,"file exception test")){
			return reader.read(dataFile);
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
	

}
