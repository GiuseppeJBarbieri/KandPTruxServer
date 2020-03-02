package model_trucking;

import java.io.Serializable;

import models.Server_To_Client_Message_Model;

public class Email_Sent_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2755977217262487127L;
	private Server_To_Client_Message_Model message;
	public Email_Sent_Model(Server_To_Client_Message_Model message) {
		super();
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Server_To_Client_Message_Model getMessage() {
		return message;
	}
	
	

}
