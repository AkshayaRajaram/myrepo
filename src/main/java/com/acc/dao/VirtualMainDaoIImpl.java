package com.acc.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.UW_Mapping;

import com.acc.exceptions.VirtualMainException;

@Repository
public class VirtualMainDaoIImpl extends AbstractDao implements VirtualMainDaoI{
	
	public List<UW_Mapping> getUnderWriterList() throws VirtualMainException 
	{
		Session session=getSession();
		//Session session=null;
		
		Query query=session.createQuery("from UW_Mapping u ORDER BY u.uw_Mapping_Id  ASC");
		
		List<UW_Mapping> list1;
		
		list1 =  (List<UW_Mapping>) query.list();
		return list1;
				
	}

	public List<Account_UW_Mapping> getAccountList() throws VirtualMainException {
		// TODO Auto-generated method stub
		Session session=getSession();
		
		Query query=session.createQuery("from Account_UW_Mapping m ORDER BY m.account.account_Id DESC");
		List<Account_UW_Mapping> list2 ;
		
		list2 = (List<Account_UW_Mapping>) query.list();
		return list2;
		
	}
	

}
