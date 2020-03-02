package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

import model_trucking.COD_Model;

public class COD_Search_Result_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3704318814247223875L;
	private ArrayList<COD_Model> codList;
	public COD_Search_Result_Model(ArrayList<COD_Model> codList) {
		super();
		this.codList = codList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<COD_Model> getCodList() {
		return codList;
	}
	
	

}
