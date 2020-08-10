package model_trucking;

import java.io.Serializable;

import models.Server_To_Client_Message_Model;

public class Edit_Driver_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5857046298722448159L;
	private Server_To_Client_Message_Model message;

	public Edit_Driver_Model(Server_To_Client_Message_Model message) {
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
