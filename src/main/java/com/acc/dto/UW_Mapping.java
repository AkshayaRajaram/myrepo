package com.acc.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UW_MAPPING")
public class UW_Mapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uw_Mapping_Id;

	@OneToOne
	@JoinColumn(name = "PRODUCT_TYPE_ID")
	private ProductType productType;

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

	public Integer getUw_Mapping_Id() {
		return uw_Mapping_Id;
	}

	public void setUw_Mapping_Id(Integer uw_Mapping_Id) {
		this.uw_Mapping_Id = uw_Mapping_Id;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
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
