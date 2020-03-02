package model_trucking;

import java.io.Serializable;
import java.util.ArrayList;

public class Store_Search_Result_Model implements Serializable {

	private static final long serialVersionUID = 4124011601847741084L;
	private ArrayList<Store_Model> storeResultsList;
	public Store_Search_Result_Model(ArrayList<Store_Model> storeResultsList) {
		super();
		this.storeResultsList = storeResultsList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<Store_Model> getStoreResultsList() {
		return storeResultsList;
	}
	
}
