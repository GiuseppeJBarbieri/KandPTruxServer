package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

import model_trucking.Store_Model;
import model_trucking.TimeFrame_Model;

public class All_Time_Frame_Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8689179990374973147L;
	private ArrayList<TimeFrame_Model> timeFramesList;
	private ArrayList<Store_Model> storeList;
	public All_Time_Frame_Request(ArrayList<TimeFrame_Model> timeFramesList, ArrayList<Store_Model> storeList) {
		super();
		this.timeFramesList = timeFramesList;
		this.storeList = storeList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<TimeFrame_Model> getTimeFramesList() {
		return timeFramesList;
	}
	public ArrayList<Store_Model> getStoreList() {
		return storeList;
	}
	
	

}
