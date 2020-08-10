package event_objects;

import java.io.Serializable;

public class Search_Driver_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4796663126255905750L;
	private String searchString;
	public Search_Driver_Event_Object(String searchString) {
		super();
		this.searchString = searchString;
	}
	
}
