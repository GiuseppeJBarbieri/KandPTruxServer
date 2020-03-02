package event_objects;

import java.io.Serializable;

public class Search_Store_Billing_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5566096245966383462L;
	private String search;
	public Search_Store_Billing_Event_Object(String search) {
		super();
		this.search = search;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSearch() {
		return search;
	}
	
	

}
