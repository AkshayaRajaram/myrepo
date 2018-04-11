package com.acc.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UWMAPPING")
public class UWMapping extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uwMappingId;

	@OneToOne
	@JoinColumn(name = "productTypeId")
	private ProductType productType;

	@OneToOne
	@JoinColumn(name = "underWriterId")
	private UnderWriter underWriter;

	public Integer getUwMappingId() {
		return uwMappingId;
	}

	public void setUwMappingId(Integer uwMappingId) {
		this.uwMappingId = uwMappingId;
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

}
