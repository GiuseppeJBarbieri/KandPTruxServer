package event_objects;

import java.io.Serializable;

public class Search_TimeFrame_Event_Object implements Serializable {

	private static final long serialVersionUID = -8017733719681101800L;
	private String storeID;
	public Search_TimeFrame_Event_Object(String storeID) {
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
