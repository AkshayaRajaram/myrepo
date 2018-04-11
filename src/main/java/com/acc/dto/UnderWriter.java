package com.acc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnderWriter extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int underWriterId;

	@Column(name = "underWriter_Name")
	String underWriterName;

	@Column(name = "DIVISION")
	String division;

	public int getUnderWriterId() {
		return underWriterId;
	}

	public void setUnderWriterId(int underWriterId) {
		this.underWriterId = underWriterId;
	}

	public String getUnderWriterName() {
		return underWriterName;
	}

	public void setUnderWriterName(String underWriterName) {
		this.underWriterName = underWriterName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

}
