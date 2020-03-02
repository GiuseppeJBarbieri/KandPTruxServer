package models;

import java.io.Serializable;

public class Login_Message_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3070135669677592663L;
	private Server_To_Client_Message_Model message;
	private User_Account_Information account;
	public Login_Message_Model(Server_To_Client_Message_Model message, User_Account_Information account) {
		super();
		this.message = message;
		this.account = account;
	}
	public Server_To_Client_Message_Model getMessage() {
		return message;
	}
	public User_Account_Information getAccount() {
		return account;
	}
	
	
}
