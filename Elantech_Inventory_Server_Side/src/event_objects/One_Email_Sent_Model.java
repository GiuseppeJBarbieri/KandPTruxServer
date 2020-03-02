package event_objects;

import java.io.Serializable;

import models.Server_To_Client_Message_Model;

public class One_Email_Sent_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1654546997148525373L;
	private Server_To_Client_Message_Model message;
	public One_Email_Sent_Model(Server_To_Client_Message_Model message) {
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
