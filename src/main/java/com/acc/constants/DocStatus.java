package com.acc.constants;

import java.util.Map;

public class DocStatus {
	
	int docid;
	String docname;
	String filename;
	Map<String,Boolean> status;
	String sts;
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Map<String, Boolean> getStatus() {
		return status;
	}
	public void setStatus(Map<String, Boolean> status) {
		this.status = status;
	}
	
	

}
