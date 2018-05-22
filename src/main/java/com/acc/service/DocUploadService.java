package com.acc.service;

import java.util.List;

import com.acc.dto.DocFile;

import com.acc.exceptions.VirtualMainException;

public interface DocUploadService {

	public void saveDocFile(DocFile docfile) throws VirtualMainException;

	public List<DocFile> listAllDocs() throws VirtualMainException;

	public DocFile getDocFileById(Integer fileId) throws VirtualMainException;

	public void deleteDoc(DocFile docfile) throws VirtualMainException;

}
