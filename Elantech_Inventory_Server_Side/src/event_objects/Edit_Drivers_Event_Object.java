package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Edit_Drivers_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5413661697874101508L;
	private ArrayList<String> driversList;
	public Edit_Drivers_Event_Object(ArrayList<String> driversList) {
		super();
		this.driversList = driversList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<String> getDriversList() {
		return driversList;
	}
	
}
