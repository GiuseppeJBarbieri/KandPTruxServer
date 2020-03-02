package model_trucking;

import java.io.Serializable;

public class COD_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2898343779274511957L;
	private String orderNumber;
	private String customerName;
	private String storeName;
	private String driver;
	private String orderDate;
	private Double cod;
	public COD_Model(String orderNumber, String customerName, String storeName, String driver, String orderDate,
			Double cod) {
		super();
		this.orderNumber = orderNumber;
		this.customerName = customerName;
		this.storeName = storeName;
		this.driver = driver;
		this.orderDate = orderDate;
		this.cod = cod;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getDriver() {
		return driver;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public Double getCod() {
		return cod;
	}
	
	

}
