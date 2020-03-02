package models;

import java.io.Serializable;

public class Server_Message_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7071234571121032980L;
	private String message;

	public Server_Message_Model(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
