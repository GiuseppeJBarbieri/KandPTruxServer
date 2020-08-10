package event_objects;

import java.io.Serializable;
import java.sql.Date;

public class Add_TimeFrame_Event_Object implements Serializable {

	private static final long serialVersionUID = 4629079775686561015L;
	private int storeId;
	private String customerName;
	private Date orderDate;
	private String town;
	private String driver;
	private String orderNumber;
	private String timeFrame;

	public Add_TimeFrame_Event_Object(int storeId, String customerName, Date orderDate, String town, String driver,
			String orderNumber, String timeFrame) {
		super();
		this.storeId = storeId;
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

	public int getStoreId() {
		return storeId;
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
