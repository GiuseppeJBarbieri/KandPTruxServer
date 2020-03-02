package event_objects;

import java.util.EventObject;

public class Message_Event_Object extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3568207851754658115L;
	private String s;

	public Message_Event_Object(Object source, String s) {
		super(source);
		this.s = s;
	}

	public String getS() {
		return s;
	}
	
	
}
