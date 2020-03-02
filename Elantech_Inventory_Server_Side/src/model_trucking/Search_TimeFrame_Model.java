package model_trucking;

import java.io.Serializable;
import java.util.ArrayList;

public class Search_TimeFrame_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2970927436486460203L;
	private ArrayList<TimeFrame_Model> timeframeResultsList;
	public Search_TimeFrame_Model(ArrayList<TimeFrame_Model> timeframeResultsList) {
		super();
		this.timeframeResultsList = timeframeResultsList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<TimeFrame_Model> getTimeframeResultsList() {
		return timeframeResultsList;
	}
	
	


}
