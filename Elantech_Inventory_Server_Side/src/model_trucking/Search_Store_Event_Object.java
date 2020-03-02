package model_trucking;

import java.io.Serializable;

public class Search_Store_Event_Object implements Serializable {

	private static final long serialVersionUID = -8346961899738168904L;
	private String storeName;
	public Search_Store_Event_Object(String storeName) {
		super();
		this.storeName = storeName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStoreName() {
		return storeName;
	}
	
	
}
