package com.acc.dto;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "docfiles")
public class DocFile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "filename")
	private String fileName;

	@Column(name = "filecontent")
	private byte[] fileContent;

	@Column(name = "filetype")
	private String fileType;
	
	public DocFile(Integer id,String fileName,String fileType) {
		this.id=id;
		this.fileName= fileName;
		this.fileType =fileType;
	}

	/*@JsonCreator
	public DocFile(@JsonProperty("id") Integer id,    		
    		@JsonProperty("fileName") String fileName,
    		@JsonProperty("filetype") String filetype
                     ) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
       
    }*/

	public DocFile() {
		
		// TODO Auto-generated constructor stub
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
