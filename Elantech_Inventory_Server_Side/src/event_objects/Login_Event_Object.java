package event_objects;

import java.util.EventObject;

public class Login_Event_Object extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842335775957662655L;
	private String username;
	private String password;

	public Login_Event_Object(Object source, String username, String password) {
		super(source);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
