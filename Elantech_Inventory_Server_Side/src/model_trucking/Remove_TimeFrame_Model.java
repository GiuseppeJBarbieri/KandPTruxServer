package model_trucking;

import java.io.Serializable;

import models.Server_To_Client_Message_Model;

public class Remove_TimeFrame_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -532050531862076313L;
	private Server_To_Client_Message_Model message;
	public Remove_TimeFrame_Model(Server_To_Client_Message_Model message) {
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
