package event_objects;

import java.io.Serializable;

public class Add_Store_Event_Object implements Serializable {

	private static final long serialVersionUID = 2268230655859993974L;
	private String storeName;
	private String address;
	private String email;
	private String phoneNumber;
	private String fax;
	
	public Add_Store_Event_Object(String storeName, String address, String email, String phoneNumber, String fax) {
		super();
		this.storeName = storeName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getFax() {
		return fax;
	}
	
	
}
