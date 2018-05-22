package com.acc.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
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

import com.acc.dto.DocFile;

import com.acc.entity.FileUpload;

import com.acc.exceptions.VirtualMainException;
import com.acc.service.DocUploadService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DocUploadController {

	@Autowired
	DocUploadService docuploadservice;
	static Logger log = Logger.getLogger(DocUploadController.class.getName());

	@RequestMapping(value = "listdoc.htm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String docload(HttpServletRequest request, HttpServletResponse response)
			throws VirtualMainException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(docuploadservice.listAllDocs());
		List<DocFile> asList = mapper.readValue(jsonArray, new TypeReference<List<DocFile>>() {
		});
		Collections.sort(asList, new DocFile());
		return mapper.writeValueAsString(asList);
	}

	@RequestMapping(value = "uploadPdf.htm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadExcel(HttpServletRequest request, HttpServletResponse response, FileUpload uploadItem)
			throws IOException, VirtualMainException {

		List<MultipartFile> files = uploadItem.getFile();
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			DocFile docfile = new DocFile();
			int position = fileName.lastIndexOf(".");
			String fileType = fileName.substring(position);
			byte[] docfileData = IOUtils.toByteArray(file.getInputStream());
			docfile.setFileType(fileType);
			docfile.setFileName(fileName);
			docfile.setFileContent(docfileData);
			docuploadservice.saveDocFile(docfile);
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(docuploadservice.listAllDocs());
		List<DocFile> asList = mapper.readValue(jsonArray, new TypeReference<List<DocFile>>() {
		});
		Collections.sort(asList, new DocFile());
		return mapper.writeValueAsString(asList);
	}

	@RequestMapping("downloadDocument.htm")
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id)
			throws IOException, VirtualMainException {

		DocFile docFile = docuploadservice.getDocFileById(Integer.valueOf(id));
		ByteArrayInputStream in = new ByteArrayInputStream(docFile.getFileContent());
		OutputStream outStream = response.getOutputStream();
		String fileName = URLEncoder.encode(docFile.getFileName(), "UTF-8");
		fileName = URLDecoder.decode(fileName, "ISO8859_1");
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = in.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

	}

	@RequestMapping(value = "deleteDoc.htm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id)
			throws IOException, VirtualMainException {

		DocFile docFile = docuploadservice.getDocFileById(Integer.valueOf(id));
		docuploadservice.deleteDoc(docFile);
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(docuploadservice.listAllDocs());
		List<DocFile> asList = mapper.readValue(jsonArray, new TypeReference<List<DocFile>>() {
		});
		Collections.sort(asList, new DocFile());
		return mapper.writeValueAsString(asList);

	}
}
