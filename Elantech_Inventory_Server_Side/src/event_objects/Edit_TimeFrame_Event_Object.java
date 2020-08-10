package event_objects;

import java.io.Serializable;
import java.sql.Date;

public class Edit_TimeFrame_Event_Object implements Serializable {

	private static final long serialVersionUID = 304193258042188232L;

	private int storeID;
	private int orderID;
	private String customerName;
	private Date orderDate;
	private String town;
	private String driver;
	private String orderNumber;
	private String timeFrame;
	public Edit_TimeFrame_Event_Object(int storeID, int orderID, String customerName, Date orderDate, String town,
			String driver, String orderNumber, String timeFrame) {
		super();
		this.storeID = storeID;
		this.orderID = orderID;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.town = town;
		this.driver = driver;
		this.orderNumber = orderNumber;
		this.timeFrame = timeFrame;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getStoreID() {
		return storeID;
	}
	public int getOrderID() {
		return orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public String getTown() {
		return town;
	}
	public String getDriver() {
		return driver;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public String getTimeFrame() {
		return timeFrame;
	}

	
}
