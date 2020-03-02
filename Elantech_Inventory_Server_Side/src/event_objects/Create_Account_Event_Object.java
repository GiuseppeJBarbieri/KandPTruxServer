package event_objects;

import java.util.EventObject;

public class Create_Account_Event_Object extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869353256873267308L;
	private String username;
	private String password;
	private String firstName;
	private String email;
	private String lastName;
	private String accountPrivilege;

	public Create_Account_Event_Object(Object arg0, String username, String password, String email, String firstName,
			String lastName, String accountPrivilege) {
		super(arg0);
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountPrivilege = accountPrivilege;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAccountPrivilege() {
		return accountPrivilege;
	}

	public String getEmail() {
		return email;
	}

}
