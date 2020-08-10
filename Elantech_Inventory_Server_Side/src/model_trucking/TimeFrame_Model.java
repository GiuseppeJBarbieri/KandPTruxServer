package model_trucking;

import java.io.Serializable;
import java.sql.Date;

public class TimeFrame_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5601902369161562450L;

	private int storeID;
	private int orderID;
	private String customerName;
	private String town;
	private String orderNumber;
	private String driver;
	private String timeFrame;
	private Date orderDate;

	public TimeFrame_Model(int storeID, int orderID, String customerName, String town, String orderNumber,
			String driver, String timeFrame, Date orderDate) {
		super();
		this.storeID = storeID;
		this.orderID = orderID;
		this.customerName = customerName;
		this.town = town;
		this.orderNumber = orderNumber;
		this.driver = driver;
		this.timeFrame = timeFrame;
		this.orderDate = orderDate;
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

	public String getTown() {
		return town;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getDriver() {
		return driver;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public Date getOrderDate() {
		return orderDate;
	}

}
