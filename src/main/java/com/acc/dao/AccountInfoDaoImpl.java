package com.acc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.dto.Document;
import com.acc.exceptions.VirtualMainException;



@Repository
public class AccountInfoDaoImpl extends AbstractDao implements AccountInfoDao{
/***
 * 
 */
	public List<Account> listAllAccount() throws VirtualMainException {
		Session session=getSession();
		//Session session=null;
		
		Query query=session.createQuery("from Account");
		
		

List<Account> accountList = query.list();

		
		return query.list();
	}

	
	/***
	 * 
	 */
	public List<DocRevStatus> listAccDocStatus(Integer accid) throws VirtualMainException {
		// TODO Auto-generated method stub
		Session session=getSession();
		
		Query query = session.createQuery("from DocRevStatus");
		return query.list() ;
	}

	

	

	
}
