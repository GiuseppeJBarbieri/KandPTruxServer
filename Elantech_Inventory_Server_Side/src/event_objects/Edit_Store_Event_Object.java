package event_objects;

import java.io.Serializable;

public class Edit_Store_Event_Object implements Serializable {

	private static final long serialVersionUID = 4935997342886029469L;
	private String id;
	private String storeName;
	private String address;
	private String email;
	private String phoneNum;
	private String fax;
	
	public Edit_Store_Event_Object(String id, String storeName, String address, String email, String phoneNum,
			String fax) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.fax = fax;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getFax() {
		return fax;
	}
	
	
}
