package com.acc.dto;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int doc_Id;
	
	@Column(name = "doc_Name")
	String doc_Name;
	
	@Column(name = "division")
	String division;
	
	@Column(name = "file_Name")
	String file_Name;
	
	@Column(name = "created_By")
	String createdBy;
	
	@Column(name = "created_Date")
	Date createdDate;
	
	@Column(name = "updated_By")
	String updatedBy;
	
	@Column(name = "updated_Date")
	Date updatedDate;
	
	public int getDoc_Id() {
		return doc_Id;
	}
	
	public void setDoc_Id(int doc_Id) {
		this.doc_Id = doc_Id;
	}
	
	public String getDoc_Name() {
		return doc_Name;
	}
	
	public void setDoc_Name(String doc_Name) {
		this.doc_Name = doc_Name;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	public String getFile_Name() {
		return file_Name;
	}
	
	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
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
