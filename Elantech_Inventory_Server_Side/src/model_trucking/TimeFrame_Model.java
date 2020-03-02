package model_trucking;

import java.io.Serializable;

public class TimeFrame_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5601902369161562450L;
	private String orderID;
	private String name;
	private String town;
	private String phoneNumber;
	private String driver;
	private String timeFrameStart;
	private String timeFrameEnd;
	private String orderDate;
	private String Store_ID;
	private Double cod;
	public TimeFrame_Model(String orderID, String name, String town, String phoneNumber, String driver,
			String timeFrameStart, String timeFrameEnd, String orderDate, String store_ID, Double cod) {
		super();
		this.orderID = orderID;
		this.name = name;
		this.town = town;
		this.phoneNumber = phoneNumber;
		this.driver = driver;
		this.timeFrameStart = timeFrameStart;
		this.timeFrameEnd = timeFrameEnd;
		this.orderDate = orderDate;
		Store_ID = store_ID;
		this.cod = cod;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getName() {
		return name;
	}
	public String getTown() {
		return town;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getDriver() {
		return driver;
	}
	public String getTimeFrameStart() {
		return timeFrameStart;
	}
	public String getTimeFrameEnd() {
		return timeFrameEnd;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getStore_ID() {
		return Store_ID;
	}
	public Double getCod() {
		return cod;
	}
	
	
	
}
