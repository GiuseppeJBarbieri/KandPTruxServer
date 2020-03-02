package model_trucking;

import java.io.Serializable;

public class Store_Model implements Serializable {

	private String storeName;
	private String address;
	private String email;
	private String phoneNumber;
	private String fax;
	private String storeID;
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public Store_Model(String storeName, String address, String email, String phoneNumber, String fax, String storeID) {
		super();
		this.storeName = storeName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
		this.storeID = storeID;
	}
	
	
}
