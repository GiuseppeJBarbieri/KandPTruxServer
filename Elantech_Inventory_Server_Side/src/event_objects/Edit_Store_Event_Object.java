package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Edit_Store_Event_Object implements Serializable {

	private static final long serialVersionUID = 4935997342886029469L;
	private int id;
	private String storeName;
	private ArrayList<String> emailList;

	public Edit_Store_Event_Object(int id, String storeName, ArrayList<String> emailList) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.emailList = emailList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getStoreName() {
		return storeName;
	}

	public ArrayList<String> getEmailList() {
		return emailList;
	}

}
