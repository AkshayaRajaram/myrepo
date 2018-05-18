package com.acc.dao;

import java.util.List;

import com.acc.dto.DocFile;
import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;

public interface DocUploadDao {
	
	
	public void saveDocFile(DocFile docfile) throws VirtualMainException;
	
	public List<DocFile>  listAllDocs()throws VirtualMainException;
	
	public DocFile getDocFileById(Integer fileId) throws VirtualMainException;
	
	
	public void deleteDoc(DocFile docfile) throws VirtualMainException;


}
