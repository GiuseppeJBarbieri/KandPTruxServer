package model_trucking;

import java.io.Serializable;

public class Remove_TimeFrame_Event_Object implements Serializable {

	private static final long serialVersionUID = 6925213949320742522L;
	
	private int orderID;

	public Remove_TimeFrame_Event_Object(int orderID) {
		super();
		this.orderID = orderID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getOrderID() {
		return orderID;
	}

}
