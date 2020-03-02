package models;

import java.io.Serializable;

public class Create_Account_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275273549643270342L;
	private Server_To_Client_Message_Model mesasge;

	public Create_Account_Model(Server_To_Client_Message_Model mesasge) {
		super();
		this.mesasge = mesasge;
	}

	public Server_To_Client_Message_Model getMesasge() {
		return mesasge;
	}
	
	
}
