package com.acc.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.dto.DocFile;
import com.acc.dto.ExcelFile;
import com.acc.entity.ColumnCount;
import com.acc.entity.FileUpload;
import com.acc.entity.RowCount;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.DocUploadService;
import com.acc.service.ExcelUploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Controller
public class ExcelUploadController {

	@Autowired
	ExcelUploadService exceluploadservice;

	static Logger log = Logger.getLogger(ExcelUploadController.class.getName());
	
	@RequestMapping("preparetrainingdata.htm")
	public ModelAndView loadpage(HttpServletRequest request)throws IOException, VirtualMainException {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("preparetrainingdata");
		return modelandview;
	}

	@RequestMapping(value = "listexcel.htm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String load(HttpServletRequest request, HttpServletResponse response) throws VirtualMainException, IOException {
		
		List<ExcelFile> excelFiles = exceluploadservice.listAllExcels();
		
		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(excelFiles);

	}

	@RequestMapping(value = "uploadExcel.htm",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadExcel(HttpServletRequest request, FileUpload uploadItem)
			throws IOException, VirtualMainException {


		List<MultipartFile> files = uploadItem.getFile();

		
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			
			ExcelFile excelFile = new ExcelFile();
			int position = fileName.lastIndexOf(".");

			String fileType = fileName.substring(position);
			

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
		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(excelFiles);
	
	}

	@RequestMapping("downloadExcel.htm")
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id)
			throws IOException, VirtualMainException {
		
		ExcelFile excelFile = exceluploadservice.getExcelFileById(Integer.valueOf(id));

		ByteArrayInputStream in = new ByteArrayInputStream(excelFile.getFileContent());
		OutputStream outStream = response.getOutputStream();
		String fileName = URLEncoder.encode(excelFile.getFileName(), "UTF-8");
		fileName = URLDecoder.decode(fileName, "ISO8859_1");
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = in.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

	}

	@RequestMapping("deleteExcel.htm")
	public ModelAndView deleteExcel(HttpServletRequest request, @RequestParam("id") String id)
			throws IOException, VirtualMainException {
		ModelAndView modelandview = new ModelAndView();

		ExcelFile excelFile = exceluploadservice.getExcelFileById(Integer.valueOf(id));

		exceluploadservice.deleteExcel(excelFile);

		modelandview.addObject("message", "deletedSuccessfully");
		
		modelandview.setViewName("preparetrainingdata");
		return modelandview;
	}
}
