package account.mail;

public class AccountEmailException extends Exception {
		private static final long serialVersionUID = 3494864855845628905L;
		public AccountEmailException(){
			
		};
		public AccountEmailException(String msg,Exception e){
			System.out.println(msg);
			e.printStackTrace();
		}
}
