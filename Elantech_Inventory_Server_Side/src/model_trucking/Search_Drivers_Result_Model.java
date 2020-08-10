package model_trucking;

import java.io.Serializable;
import java.util.ArrayList;

public class Search_Drivers_Result_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6201415484620017359L;
	private ArrayList<String> driversList;
	public Search_Drivers_Result_Model(ArrayList<String> driversList) {
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
