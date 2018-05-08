package com.acc.dao;

import java.util.List;

import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;

public interface ExcelUploadDao {

	
	public void saveExcelFile(ExcelFile excelFile) throws VirtualMainException;
	
	public List<ExcelFile>  listAllExcels() throws VirtualMainException;

}
