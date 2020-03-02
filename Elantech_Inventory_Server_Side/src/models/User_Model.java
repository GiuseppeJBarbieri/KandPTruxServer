package models;

import java.io.Serializable;

public class User_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8989290823611119129L;

	private User_Account_Information userAccountInformation;
	private String localIpAddy;

	public User_Model(String localIpAddy) {
		this.localIpAddy = localIpAddy;
	}
	
	public User_Model(User_Account_Information userAccountInformation, String localIpAddy) {
		super();
		this.userAccountInformation = userAccountInformation;
		this.localIpAddy = localIpAddy;
	}

	public User_Account_Information getUserAccountInformation() {
		return userAccountInformation;
	}

	public void setUserAccountInformation(User_Account_Information userAccountInformation) {
		this.userAccountInformation = userAccountInformation;
	}

	public String getLocalIpAddy() {
		return localIpAddy;
	}

	public void setLocalIpAddy(String localIpAddy) {
		this.localIpAddy = localIpAddy;
	}
}
