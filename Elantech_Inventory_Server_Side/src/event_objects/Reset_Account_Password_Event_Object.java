package event_objects;

import java.util.EventObject;

public class Reset_Account_Password_Event_Object extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7424398230992190329L;
	private String username;
	private String email;
	private String password;

	public Reset_Account_Password_Event_Object(Object source, String username, String email, String password) {
		super(source);
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
