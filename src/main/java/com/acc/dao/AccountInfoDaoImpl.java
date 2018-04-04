package com.acc.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.acc.constants.CommonConstants;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;

@Repository
public class AccountInfoDaoImpl extends AbstractDao implements AccountInfoDao {
	
	/*
	 * Returns Account Details from database using Session Factory Object
	 * 
	 * @return list of account
	 * @throws VirtualMainException
	 */
	
	public List<Account> listAllAccount() throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery(CommonConstants.FROM_ACCOUNT);
		return query.list();
	}
	
	/*
	 * Returns Document status information from database using Session Factory Object
	 * 
	 * @return list of document status information
	 * @throws VirtualMainException
	 */
	
	public List<DocRevStatus> listAccDocStatus() throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery(CommonConstants.FROM_DOC_REV_STATUS);
		return query.list();
	}
	
}
