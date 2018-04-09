package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.acc.dao.VirtualMainDaoI;
import com.acc.dto.Account;
import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.UW_Mapping;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;

@Service
public class VirtualServiceImpl implements VirtualService {

	@Autowired
	VirtualMainDaoI virtualmaindao;
	static Logger log = Logger.getLogger(VirtualServiceImpl.class.getName());

	/**
	 * Adds the UnderWriter information to a list based on productType Returns
	 * Underwriter list
	 * 
	 * @return underwriter list
	 * @param productType
	 *            - productType
	 * @throws VirtualMainException
	 */
	@Transactional(readOnly = true)
	public List<UnderWriter> getUnderWriterList(String productType) throws VirtualMainException {
		ArrayList<UnderWriter> UnderWriterList = new ArrayList<UnderWriter>();
		List<UW_Mapping> UW_Mapping = virtualmaindao.getUnderWriterList();
		log.info("getUnderWriterList method in virtualmaindao class returned successfully");
		for (UW_Mapping uw_map : UW_Mapping) {
			if (uw_map.getProductType().getProductType_Name().equals(productType)) {
				UnderWriterList.add(uw_map.getUnderWriter());
			}
		}
		return UnderWriterList;
	}

	/**
	 * Adds the Account information to a list based on UnderWriter Id Returns
	 * Account list
	 * 
	 * @return account list
	 * @param underWriterId
	 *            - UnderWriterId
	 * @throws VirtualMainException
	 */
	@Transactional(readOnly = true)
	public List<Account> getAccountList(int underWriterId) throws VirtualMainException {
		ArrayList<Account> accountList = new ArrayList<Account>();
		List<Account_UW_Mapping> UW_Account_Mapping = virtualmaindao.getAccountList();
		log.info("getAccountList method in virtualmaindao class returned successfully");
		for (Account_UW_Mapping map : UW_Account_Mapping) {
			if (map.getUnderWriter().getUnderWriter_Id() == underWriterId) {
				accountList.add(map.getAccount());
			}
		}
		return accountList;
	}
}
