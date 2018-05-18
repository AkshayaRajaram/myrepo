package com.acc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.acc.dto.DocFile;
import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;
@Repository
public class DocUploadDaoImpl extends AbstractDao implements DocUploadDao {

	
	public void saveDocFile(DocFile docfile) throws VirtualMainException {
		Session session = getSession();
		session.save(docfile);
	}
	
	public List<DocFile>  listAllDocs() throws VirtualMainException{

		Session session = getSession();
		//Query query = session.createQuery("Select D.fileName,D.fileType,D.id from DocFile D");
		//Query query = session.createQuery("from DocFile ");
		//Query query = session.createQuery("Select new DocFile(D.fileName,D.fileType,D.id) from DocFile D");
		Query query = session.createQuery("Select new map(D.fileName as fileName ,D.fileType as fileType,D.id as id) from DocFile D");
	
		return query.list();
	}


	public DocFile getDocFileById(Integer fileId) throws VirtualMainException {
		
		Session session = getSession();
	
		//ExcelFile excelFile = new ExcelFile();
		DocFile docfile = new DocFile();
		Query query = session.createQuery("select e from DocFile e where e.id=:fileId ");
		query.setParameter("fileId", fileId);
		List<DocFile> doclist = query.list();
		for (DocFile file : doclist) {
			docfile = file;
		}
		return docfile;	
		
	}
	public void deleteDoc(DocFile docfile) throws VirtualMainException {
		Session session = getSession();
		session.delete(docfile);
	}	
}
