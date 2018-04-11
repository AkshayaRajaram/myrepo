package com.acc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoverageType extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "coverageType_Id")
	String coverageTypeId;

	@Column(name = "coverageType_Name")
	String coverageTypeName;

	public int getId() {
		return id;
	}

	public void setId(int cid) {
		id = cid;
	}

	public String getCoverageTypeId() {
		return coverageTypeId;
	}

	public void setCoverageTypeId(String coverageTypeId) {
		this.coverageTypeId = coverageTypeId;
	}

	public String getCoverageTypeName() {
		return coverageTypeName;
	}

	public void setCoverageTypeName(String coverageTypeName) {
		this.coverageTypeName = coverageTypeName;
	}

}
