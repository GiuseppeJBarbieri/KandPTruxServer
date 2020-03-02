package models;

import java.io.Serializable;

public class Logout_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4034951796166812357L;
	private Server_To_Client_Message_Model message;

	public Logout_Model(Server_To_Client_Message_Model message) {
		super();
		this.message = message;
	}

	public Server_To_Client_Message_Model getMessage() {
		return message;
	}
	
}
