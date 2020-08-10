package event_objects;

import java.io.Serializable;

public class Remove_Store_Event_Object implements Serializable {

	private static final long serialVersionUID = 5165194403152032429L;
	private int storeID;

	public Remove_Store_Event_Object(int storeID) {
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
