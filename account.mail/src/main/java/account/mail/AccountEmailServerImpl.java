package account.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServerImpl implements AccountEmailService{

	private JavaMailSender javaMailSender;
	private String systemEmail;
	
	public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
		// TODO Auto-generated method stub
		
		try{
			MimeMessage msg=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(msg);
			helper.setFrom(systemEmail);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(htmlText);
			javaMailSender.send(msg);
		}catch (MessagingException e) {
			// TODO: handle exception
			throw new AccountEmailException("faild to send email",e);
		}
		
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
	
}
