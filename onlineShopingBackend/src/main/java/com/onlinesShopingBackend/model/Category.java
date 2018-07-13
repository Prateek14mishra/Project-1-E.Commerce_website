package com.onlinesShopingBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue
	int categoryId;
	
	String categoryName;
	String categoryDesc;
	public int getcategoryId() {
		return categoryId;
	}
	public void setcategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getcategoryName() {
		return categoryName;
	}
	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getcategoryDesc() {
		return categoryDesc;
	}
	public void setcategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	
	
}
