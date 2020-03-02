package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

import model_trucking.TimeFrame_Model;

public class Search_All_TimeFrame_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -718682929728343504L;
	private ArrayList<TimeFrame_Model> timeFramesList;
	public Search_All_TimeFrame_Model(ArrayList<TimeFrame_Model> timeFramesList) {
		super();
		this.timeFramesList = timeFramesList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<TimeFrame_Model> getTimeFramesList() {
		return timeFramesList;
	}
	
	

}
