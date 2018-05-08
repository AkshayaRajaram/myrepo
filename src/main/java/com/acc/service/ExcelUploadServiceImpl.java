package com.acc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.ExcelUploadDao;
import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;
@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {
	
	@Autowired
	ExcelUploadDao exceluploaddao;
	
	@Transactional
	public void saveExcelFile(ExcelFile excelFile) throws VirtualMainException {
		
	       exceluploaddao.saveExcelFile(excelFile);
	}
@Transactional
	public List<ExcelFile>  listAllExcels() throws VirtualMainException{
               return exceluploaddao.listAllExcels();

		
	}
}
