package event_objects;

import java.io.Serializable;

public class Search_All_Time_Frame_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9128048540189252700L;
	private String search;
	public Search_All_Time_Frame_Event_Object(String search) {
		super();
		this.search = search;
	}
	
	
	
}
