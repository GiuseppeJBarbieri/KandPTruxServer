package event_objects;

import java.io.Serializable;
import java.sql.Date;

public class Search_TimeFrame_Event_Object implements Serializable {

	private static final long serialVersionUID = -8017733719681101800L;
	private int storeID;
	private Date date;

	public Search_TimeFrame_Event_Object(int storeID, Date date) {
		super();
		this.storeID = storeID;
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getStoreID() {
		return storeID;
	}

	public Date getDate() {
		return date;
	}

}
