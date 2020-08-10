package event_objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Add_Store_Event_Object implements Serializable {

	private static final long serialVersionUID = 2268230655859993974L;
	private String storeName;
	private ArrayList<String> emailList;

	public Add_Store_Event_Object(String storeName, ArrayList<String> emailList) {
		super();
		this.storeName = storeName;
		this.emailList = emailList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStoreName() {
		return storeName;
	}

	public ArrayList<String> getEmailList() {
		return emailList;
	}

}
