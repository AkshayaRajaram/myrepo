package com.acc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.DocUploadDao;
import com.acc.dto.DocFile;

import com.acc.exceptions.VirtualMainException;

@Service
public class DocUploadServiceImpl implements DocUploadService {
	@Autowired
	DocUploadDao docuploaddao;

	@Transactional
	public void saveDocFile(DocFile docfile) throws VirtualMainException {
		docuploaddao.saveDocFile(docfile);

	}

	@Transactional
	public List<DocFile> listAllDocs() throws VirtualMainException {
		return docuploaddao.listAllDocs();
	}

	@Transactional
	public DocFile getDocFileById(Integer fileId) throws VirtualMainException {
		return docuploaddao.getDocFileById(fileId);
	}

	@Transactional
	public void deleteDoc(DocFile docfile) throws VirtualMainException {
		docuploaddao.deleteDoc(docfile);
	}
}
