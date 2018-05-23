package com.acc.excelcreater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.acc.dto.Account;
import com.acc.dto.ExcelFile;

public class ExcelBuilder extends AbstractExcelView {

	@Override
	 protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
	   HttpServletRequest request, HttpServletResponse response)
	   throws Exception {

	  List<ExcelFile> emp = (List) model.get("employees");
	  HSSFSheet sheet = workbook.createSheet("Employee Report");

	  HSSFRow header = sheet.createRow(0);
	  header.createCell(0).setCellValue("filename");
	  header.createCell(1).setCellValue("col count");
	  header.createCell(2).setCellValue("id");
	  header.createCell(3).setCellValue("rowcount");

	  int counter = 1;
	  for (ExcelFile e : emp ) {
	   HSSFRow row = sheet.createRow(counter++);
	   row.createCell(0).setCellValue(e.getFileName());
	   row.createCell(1).setCellValue(e.getColCount());
	   row.createCell(2).setCellValue(e.getId());
	   row.createCell(3).setCellValue(e.getRowcount());
	  }
	 }
}
