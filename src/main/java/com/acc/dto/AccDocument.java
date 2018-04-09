package com.acc.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "ACC_DOCUMENT")
public class AccDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer acc_doc_id;
	
	@OneToOne
	@JoinColumn(name = "ACC_ID")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "DOC_ID")
	private Document document;
	
	@Column(name = "CREATED_BY")
	private String created_By;
	
	@Column(name = "CREATED_DATE")
	private Date created_Date;
	
	@Column(name = "UPDATED_BY")
	private String updated_By;
	
	@Column(name = "UPDATED_DATE")
	private Date updated_Date;
	
	public Integer getAcc_Doc_Id() {
		return acc_doc_id;
	}
	
	public void setAcc_Doc_Id(Integer acc_Doc_Id) {
		this.acc_doc_id = acc_Doc_Id;
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
