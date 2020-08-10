package model_trucking;

import java.io.Serializable;
import java.util.ArrayList;

public class Drivers_Search_Result_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4287902102259974208L;
	private ArrayList<String> driversList;

	public Drivers_Search_Result_Model(ArrayList<String> driversList) {
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
