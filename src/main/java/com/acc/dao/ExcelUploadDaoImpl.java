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
			Query query = session.createQuery("from ExcelFile");
			return query.list();
		}
	
}
