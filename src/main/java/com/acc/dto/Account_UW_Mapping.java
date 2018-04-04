package com.acc.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account_UW_Mapping")
public class Account_UW_Mapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer acc_UW_Mapping_Id;
	
	@OneToOne
	@JoinColumn(name = "ACC_ID")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "UNDER_WRITER_ID")
	private UnderWriter underWriter;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;
	@Column(name = "UPDATEDDATE")
	private Date updatedDate;
	
	public Integer getAcc_UW_Mapping_Id() {
		return acc_UW_Mapping_Id;
	}
	
	public void setAcc_UW_Mapping_Id(Integer acc_UW_Mapping_Id) {
		this.acc_UW_Mapping_Id = acc_UW_Mapping_Id;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public UnderWriter getUnderWriter() {
		return underWriter;
	}
	
	public void setUnderWriter(UnderWriter underWriter) {
		this.underWriter = underWriter;
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
