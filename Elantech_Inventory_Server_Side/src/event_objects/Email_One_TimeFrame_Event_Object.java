package event_objects;

import java.io.Serializable;

public class Email_One_TimeFrame_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2063805897947234973L;
	private String storeID;
	public Email_One_TimeFrame_Event_Object(String storeID) {
		super();
		this.storeID = storeID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStoreID() {
		return storeID;
	}
	
	

}
