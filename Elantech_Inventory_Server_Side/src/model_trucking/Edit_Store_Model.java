package model_trucking;

import java.io.Serializable;

import models.Server_To_Client_Message_Model;

public class Edit_Store_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -564543360702630821L;

	public Edit_Store_Model(Server_To_Client_Message_Model message) {
		super();
		this.message = message;
	}

	private Server_To_Client_Message_Model message;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Server_To_Client_Message_Model getMessage() {
		return message;
	}

}
