package com.acc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.acc.dto.ExcelFile;
import com.acc.exceptions.VirtualMainException;
@Repository
public class ExcelUploadDaoImpl extends AbstractDao implements ExcelUploadDao {

	
	public void saveExcelFile(ExcelFile excelFile) throws VirtualMainException {
		 Session session = getSession();
			session.save(excelFile);
	}
	
	public List<ExcelFile>  listAllExcels() throws VirtualMainException{

			Session session = getSession();
			Query query = session.createQuery("Select new map(e.fileName as fileName ,e.rowcount as rowcount,e.colCount as colCount,e.id as id) from ExcelFile e");
			return query.list();
		}
	public ExcelFile getExcelFileById(Integer excelId) throws VirtualMainException{
		Session session = getSession();
		ExcelFile excelFile = new ExcelFile();
		Query query = session.createQuery("select e from ExcelFile e where e.id=:excelId ");
		query.setParameter("excelId", excelId);
		List<ExcelFile> excelList = query.list();
		for (ExcelFile file : excelList) {
			excelFile = file;
		}
		return excelFile;	
	}
	
	public void deleteExcel(ExcelFile excelFile) throws VirtualMainException {
		Session session = getSession();
		session.delete(excelFile);
	}
}
