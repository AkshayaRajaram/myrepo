package com.acc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.acc.constants.CommonConstants;
import com.acc.dto.AccountUWMapping;
import com.acc.dto.UWMapping;
import com.acc.exceptions.VirtualMainException;

@Repository
public class VirtualMainDaoIImpl extends AbstractDao implements VirtualMainDaoI {
	static Logger log = Logger.getLogger(VirtualMainDaoIImpl.class.getName());

	/**
	 * Returns UnderWriter Details from database using Session Factory Object
	 * 
	 * @return list of underwriter
	 * @throws VirtualMainException
	 */
	@SuppressWarnings(CommonConstants.UNCHECKED)
	public List<UWMapping> getUnderWriterList() throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery(CommonConstants.FROM_UW_MAPPING_U_ORDER_BY_U_UW_MAPPING_ID_ASC);
		log.info("Database Connected.." + " " + "Data Fetched successfully from UW_Mapping table");
		return query.list();
	}

	/**
	 * Returns Account_Underwriter Details from database using Session Factory
	 * Object
	 * 
	 * @return list of account_underwriter(account_uw_mapping)
	 * @throws VirtualMainException
	 */
	@SuppressWarnings(CommonConstants.UNCHECKED)
	public List<AccountUWMapping> getAccountList() throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery(CommonConstants.FROM_ACCOUNT_UW_MAPPING_M_ORDER_BY_M_ACCOUNT_ACCOUNT_ID_DESC);
		log.info("Database Connected.." + " " + "Data Fetched successfully from Account_UW_Mapping");
		return query.list();
	}
}
