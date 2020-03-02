package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

import model_trucking.Store_Model;

public class Billing_Store_Search_Result_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8734055025009955422L;
	private ArrayList<Store_Model> storeResultsList;
	public Billing_Store_Search_Result_Model(ArrayList<Store_Model> storeResultsList) {
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
