package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.VirtualMainDaoI;
import com.acc.dto.Account;
import com.acc.dto.AccountUWMapping;
import com.acc.dto.UWMapping;
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
		ArrayList<UnderWriter> underWriterList = new ArrayList<>();
		List<UWMapping> uWMapping = virtualmaindao.getUnderWriterList();
		log.info("getUnderWriterList method in virtualmaindao class returned successfully");
		for (UWMapping uwmap : uWMapping) {
			if (uwmap.getProductType().getProductTypeName().equals(productType)) {
				underWriterList.add(uwmap.getUnderWriter());
			}
		}
		return underWriterList;
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
		ArrayList<Account> accountList = new ArrayList<>();
		List<AccountUWMapping> uWAccountMapping = virtualmaindao.getAccountList();
		log.info("getAccountList method in virtualmaindao class returned successfully");
		for (AccountUWMapping map : uWAccountMapping) {
			if (map.getUnderWriter().getUnderWriterId() == underWriterId) {
				accountList.add(map.getAccount());
			}
		}
		return accountList;
	}
}
