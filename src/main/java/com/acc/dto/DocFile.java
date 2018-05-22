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
@Table(name = "docfiles")
public class DocFile implements Comparator<DocFile> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "filename")
	private String fileName;

	@Column(name = "filecontent")
	private byte[] fileContent;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "filetype")
	private String fileType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	@CreationTimestamp
	private Date createdDate;

	/*public DocFile(Integer id, String fileName, String fileType) {
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
	}*/

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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public int compare(DocFile o1, DocFile o2) {

		return o2.getCreatedDate().compareTo(o1.getCreatedDate());
	}

}
