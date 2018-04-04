package com.acc.dto;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Validation_Status")
public class ValidationStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int status_Id;
	
	@Column(name = "status")
	String status;
	
	@Column(name = "created_By")
	String createdBy;
	
	@Column(name = "created_Date")
	Date createdDate;
	
	@Column(name = "updated_By")
	String updatedBy;
	
	@Column(name = "updated_Date")
	Date updatedDate;
	
	public int getStatus_Id() {
		return status_Id;
	}
	
	public void setStatus_Id(int status_Id) {
		this.status_Id = status_Id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
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
