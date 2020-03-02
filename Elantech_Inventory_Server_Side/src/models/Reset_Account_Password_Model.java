package models;

import java.io.Serializable;

public class Reset_Account_Password_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1576372961141289161L;
	private Server_To_Client_Message_Model message;

	public Reset_Account_Password_Model(Server_To_Client_Message_Model message) {
		super();
		this.message = message;
	}

	public Server_To_Client_Message_Model getMessage() {
		return message;
	}
	
	
}
