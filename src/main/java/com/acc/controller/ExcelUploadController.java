package com.acc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.dto.ExcelFile;
import com.acc.entity.ColumnCount;
import com.acc.entity.FileUpload;
import com.acc.entity.RowCount;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.ExcelUploadService;

@Controller
public class ExcelUploadController {
	
    @Autowired
	ExcelUploadService exceluploadservice;
	 

	static Logger log = Logger.getLogger(ExcelUploadController.class.getName());

	@RequestMapping("sample.htm")
	public ModelAndView load(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("sample");
		return modelandview;
	}
	
	 @RequestMapping("uploadExcel.htm")
	 public ModelAndView uploadExcel(HttpServletRequest request, FileUpload uploadItem) throws IOException, VirtualMainException {
		 
	
			ModelAndView modelandview = new ModelAndView();
			List<MultipartFile> files = uploadItem.getFile();
		
		
			
		//	InputStream inputStream = null;
			//InputStream inputStream1 = null;
			//InputStream inputStream2 = null;
			for (MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				//inputStream = file.getInputStream();
				//inputStream1 = file.getInputStream();
				//inputStream2 = file.getInputStream();
				ExcelFile excelFile = new ExcelFile();
				int position = fileName.lastIndexOf(".");
				System.out.println(position);
				String fileType = fileName.substring(position);
				System.out.println(fileType);
				if (".xlsx".equals(fileType)) {
					excelFile.setRowcount(RowCount.xlsxRowCount(file.getInputStream()));
					excelFile.setColCount(ColumnCount.xlsxColumnCount(file.getInputStream()));

				} else if (".xls".equals(fileType)) {
					excelFile.setRowcount(RowCount.xlsRowCount(file.getInputStream()));
					excelFile.setColCount(ColumnCount.xlsColumnCount(file.getInputStream()));
					
				}
			
				byte[] excelfileData = IOUtils.toByteArray(file.getInputStream());
		
				excelFile.setFileName(fileName);
				
				excelFile.setFileContent(excelfileData);
				exceluploadservice.saveExcelFile(excelFile);
			}

			List<ExcelFile> excelFiles = exceluploadservice.listAllExcels();
		
			modelandview.addObject("excelFiles", excelFiles);
			modelandview.addObject("message", "uploadsuccessfully");
			modelandview.setViewName("success");
			return modelandview;
			
	 }

}
