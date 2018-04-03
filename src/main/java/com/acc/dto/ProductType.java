package com.acc.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductType {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	int productType_Id; 
	
	
	@Column(name = "productType_Name")  
	String productType_Name;
	
	@Column(name = "createdBy")  
	String createdBy;

	@Column(name = "createdDate")  
	Date createdDate;

	@Column(name = "updatedBy")  
	String updatedBy;

	@Column(name = "updatedDate")  
	Date updatedDate;

	public int getProductType_Id() {
		return productType_Id;
	}

	public void setProductType_Id(int productType_Id) {
		this.productType_Id = productType_Id;
	}

	public String getProductType_Name() {
		return productType_Name;
	}

	public void setProductType_Name(String productType_Name) {
		this.productType_Name = productType_Name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

}
