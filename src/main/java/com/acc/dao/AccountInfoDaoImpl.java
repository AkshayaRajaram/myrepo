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

	

	
	/**
	 * Returns Account Details from database using Session Factory Object for the provided accid
	 * 
	 * @Param accid 
	 *@return list of account
	 * 
	 * @throws VirtualMainException
	 */

	public List<Account> listAllAccount(Integer accid) throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery(CommonConstants.FROM_ACCOUNT_A_WHERE_A_ACCOUNT_ID_ACCID);
		query.setParameter(CommonConstants.ACCID2, accid);
		return query.list();
	}

	/**
	 * Returns Document status information from database using Session Factory for the provided accid
	 * Object
	 * 
	 * @Param accid
	 * @return list of document status information
	 * @throws VirtualMainException
	 */

	public List<DocRevStatus> listAccDocStatus(Integer accid) throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery(CommonConstants.FROM_DOC_REV_STATUS_D_WHERE_D_ACCOUNT_ACCOUNT_ID_ACCID);
		query.setParameter(CommonConstants.ACCID2, accid);
		return query.list();
	}

}
