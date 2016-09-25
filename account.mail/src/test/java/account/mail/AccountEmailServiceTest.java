package account.mail;

import static org.junit.Assert.*;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest {
private GreenMail greenMail;
	
	@Before
	public void startGreenMailServer(){
		greenMail=new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("xiaoQ@test.com", "123456");
		greenMail.start();
	}
	
	@After
	public void stopMailServer()
		throws Exception{
		greenMail.stop();
	}
	
	@Test
	public void testSendMail() throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService emailService=(AccountEmailService) context.getBean("accountEmailService");
		String subject="my Subject";
		String htmlText="<h3>1111</h3>";
		emailService.sendMail("xiaoMei@test.com", subject, htmlText);
		greenMail.waitForIncomingEmail(20000,1);
		Message[] msg=greenMail.getReceivedMessages();
		assertEquals(1,msg.length);
		assertEquals(subject, msg[0].getSubject());
		assertEquals(htmlText, GreenMailUtil.getBody(msg[0]).trim());
		
	}
}
