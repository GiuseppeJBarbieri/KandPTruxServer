package event_objects;

import java.io.Serializable;

public class Email_One_TimeFrame_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2063805897947234973L;
	private int storeID;
	public Email_One_TimeFrame_Event_Object(int storeID) {
		super();
		this.storeID = storeID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getStoreID() {
		return storeID;
	}
	
	
}
