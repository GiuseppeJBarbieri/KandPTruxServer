package models;

import java.io.Serializable;

public class Server_Logout_Request_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4129747185992018075L;
	private String s;

	public Server_Logout_Request_Model(String s) {
		super();
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
}
