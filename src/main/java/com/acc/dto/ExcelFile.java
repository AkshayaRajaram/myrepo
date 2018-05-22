package com.acc.dto;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "excelfiles")
public class ExcelFile implements Comparator<ExcelFile> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "filename")
	private String fileName;

	@Column(name = "filecontent")
	private byte[] fileContent;

	@Column(name = "rowcount")
	private Integer rowcount;

	@Column(name = "colcount")
	private Integer colCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	@CreationTimestamp
	private Date createdDate;

	/*
	 * @PrePersist protected void onCreate() { createdDate = new Date(); }
	 */

	public Integer getRowcount() {
		return rowcount;
	}

	public void setRowcount(Integer rowcount) {
		this.rowcount = rowcount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public Integer getColCount() {
		return colCount;
	}

	public void setColCount(Integer colCount) {
		this.colCount = colCount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int compare(ExcelFile o1, ExcelFile o2) {

		return o2.getCreatedDate().compareTo(o1.getCreatedDate());
	}

}
