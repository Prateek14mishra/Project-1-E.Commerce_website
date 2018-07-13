package com.onlinesShopingBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier {
	@Id
	@GeneratedValue
	private int supplierId;
	private String supplierName;
	private String supplierAdd;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAdd() {
		return supplierAdd;
	}
	public void setSupplierAdd(String supplierAdd) {
		this.supplierAdd = supplierAdd;
	}
	
	
}
