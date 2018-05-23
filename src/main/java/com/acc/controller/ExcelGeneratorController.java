package com.acc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.ExcelUploadService;
@Controller
public class ExcelGeneratorController {
	
	@Autowired
	ExcelUploadService exceluploadservice;

	static Logger log = Logger.getLogger(ExcelUploadController.class.getName());
	
	
	@RequestMapping("createexcel.htm")
	public ModelAndView deleteExcel(HttpServletRequest request, @RequestParam("id") String id)
			throws IOException, VirtualMainException {
		System.out.println("controller");
	System.out.println(id);
		ExcelFile excelFile = exceluploadservice.getExcelFileById(Integer.valueOf(id));
		
		 List<ExcelFile> employees = new ArrayList();
		  employees.add(excelFile);
		  ModelAndView modelAndView = new ModelAndView("excelView", "employees",employees);
		  
		  return modelAndView;
	}

}
