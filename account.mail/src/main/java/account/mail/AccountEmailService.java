package account.mail;

public interface AccountEmailService {
	void sendMail(String to,String subject,String htmlText)
			throws AccountEmailException;
}
