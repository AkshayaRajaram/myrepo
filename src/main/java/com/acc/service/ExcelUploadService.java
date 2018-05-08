package com.acc.service;

import java.util.List;

import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;

public interface ExcelUploadService {
	
	public void saveExcelFile(ExcelFile excelFile)throws VirtualMainException;
	
	public List<ExcelFile>  listAllExcels()throws VirtualMainException;

}