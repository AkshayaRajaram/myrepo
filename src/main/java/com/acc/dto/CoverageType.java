package com.acc.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoverageType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;

	@Column(name = "coverageType_Id")
	String coverageType_Id;

	@Column(name = "coverageType_Name")
	String coverageType_Name;

	@Column(name = "createdBy")
	String createdBy;

	@Column(name = "createdDate")
	Date createdDate;

	@Column(name = "updatedBy")
	String updatedBy;

	@Column(name = "updatedDate")
	Date updatedDate;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCoverageType_Id() {
		return coverageType_Id;
	}

	public void setCoverageType_Id(String coverageType_Id) {
		this.coverageType_Id = coverageType_Id;
	}

	public String getCoverageType_Name() {
		return coverageType_Name;
	}

	public void setCoverageType_Name(String coverageType_Name) {
		this.coverageType_Name = coverageType_Name;
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
