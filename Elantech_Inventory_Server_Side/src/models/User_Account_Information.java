package models;

import java.io.Serializable;

public class User_Account_Information implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4108786947435847467L;
	
	private int id;
	private String username, email_address, first_name, last_name, privilege_level;
	
	public User_Account_Information(int id, String username, String email_address,
			String first_name, String last_name, String privilege_level) {
		super();
		this.id = id;
		this.privilege_level = privilege_level;
		this.username = username;
		this.email_address = email_address;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrivilege_level() {
		return privilege_level;
	}

	public void setPrivilege_level(String privilege_level) {
		this.privilege_level = privilege_level;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
}
