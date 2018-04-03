package com.acc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "DOC_REV_STATUS")
public class DocRevStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doc_Rev_Status_Id;

	@OneToOne
	@JoinColumn(name = "ACC_ID")
	private Account account;

	@OneToOne
	@JoinColumn(name = "DOC_ID")
	private Document document;

	@OneToOne
	@JoinColumn(name = "STATUS_ID")
	private ValidationStatus validationstatus;

	@Column(name = "CREATED_BY")
	private String created_By;

	@Column(name = "CREATED_DATE")
	private Date created_Date;

	@Column(name = "UPDATED_BY")
	private String updated_By;

	@Column(name = "UPDATED_DATE")
	private Date updated_Date;

	public Integer getDoc_Rev_Status_Id() {
		return doc_Rev_Status_Id;
	}

	public void setDoc_Rev_Status_Id(Integer doc_Rev_Status_Id) {
		this.doc_Rev_Status_Id = doc_Rev_Status_Id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public ValidationStatus getValidationstatus() {
		return validationstatus;
	}

	public void setValidationstatus(ValidationStatus validationstatus) {
		this.validationstatus = validationstatus;
	}

	public String getCreated_By() {
		return created_By;
	}

	public void setCreated_By(String created_By) {
		this.created_By = created_By;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public String getUpdated_By() {
		return updated_By;
	}

	public void setUpdated_By(String updated_By) {
		this.updated_By = updated_By;
	}

	public Date getUpdated_Date() {
		return updated_Date;
	}

	public void setUpdated_Date(Date updated_Date) {
		this.updated_Date = updated_Date;
	}

}