package model_trucking;

import java.io.Serializable;

public class Billing_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5261746803398626774L;
	private String storeId, storeName;
	private Double cost;
	public Billing_Model(String storeId, String storeName, Double cost) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.cost = cost;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStoreId() {
		return storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public Double getCost() {
		return cost;
	}

	
	
}
