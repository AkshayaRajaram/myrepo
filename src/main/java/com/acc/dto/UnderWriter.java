package com.acc.dto;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnderWriter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int underWriter_Id;
	
	@Column(name = "underWriter_Name")
	String underWriter_Name;
	
	@Column(name = "DIVISION")
	String division;
	
	@Column(name = "createdBy")
	String createdBy;
	
	@Column(name = "createdDate")
	Date createdDate;
	
	@Column(name = "updatedBy")
	String updatedBy;
	
	@Column(name = "updatedDate")
	Date updatedDate;
	
	public int getUnderWriter_Id() {
		return underWriter_Id;
	}
	
	public void setUnderWriter_Id(int underWriter_Id) {
		this.underWriter_Id = underWriter_Id;
	}
	
	public String getUnderWriter_Name() {
		return underWriter_Name;
	}
	
	public void setUnderWriter_Name(String underWriter_Name) {
		this.underWriter_Name = underWriter_Name;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
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
