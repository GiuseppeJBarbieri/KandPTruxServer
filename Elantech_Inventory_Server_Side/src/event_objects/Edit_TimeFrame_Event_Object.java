package event_objects;

import java.io.Serializable;

public class Edit_TimeFrame_Event_Object implements Serializable {

	private static final long serialVersionUID = 304193258042188232L;

	private String storeID;
	private String orderID;
	private String customerName;
	private String orderDate;
	private String town;
	private String driver;
	private String phoneNumber;
	private String timeFrameStart;
	private String timeFrameEnd;
	private Double cod;
	public Edit_TimeFrame_Event_Object(String storeID, String orderID, String customerName, String orderDate,
			String town, String driver, String phoneNumber, String timeFrameStart, String timeFrameEnd, Double cod) {
		super();
		this.storeID = storeID;
		this.orderID = orderID;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.town = town;
		this.driver = driver;
		this.phoneNumber = phoneNumber;
		this.timeFrameStart = timeFrameStart;
		this.timeFrameEnd = timeFrameEnd;
		this.cod = cod;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStoreID() {
		return storeID;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getTown() {
		return town;
	}
	public String getDriver() {
		return driver;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getTimeFrameStart() {
		return timeFrameStart;
	}
	public String getTimeFrameEnd() {
		return timeFrameEnd;
	}
	public Double getCod() {
		return cod;
	}
	
	
}
