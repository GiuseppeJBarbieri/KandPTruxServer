package model_trucking;

import java.io.Serializable;
import java.util.ArrayList;

public class Store_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2098154870229327349L;
	private int storeID;
	private String storeName;
	private ArrayList<String> emailList;
	public Store_Model(int storeID, String storeName, ArrayList<String> emailList) {
		super();
		this.storeID = storeID;
		this.storeName = storeName;
		this.emailList = emailList;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public ArrayList<String> getEmailList() {
		return emailList;
	}
	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
