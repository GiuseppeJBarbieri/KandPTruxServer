package event_objects;

import java.io.Serializable;

public class Search_COD_Event_Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5281095483077645363L;
	private String cod;
	public Search_COD_Event_Object(String cod) {
		super();
		this.cod = cod;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCod() {
		return cod;
	}
	
	

}
