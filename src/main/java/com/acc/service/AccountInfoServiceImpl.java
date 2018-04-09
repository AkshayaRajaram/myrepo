package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.constants.CommonConstants;
import com.acc.dao.AccountInfoDao;
import com.acc.dao.AccountInfoDaoImpl;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

	@Autowired
	AccountInfoDao accountinfodao;
	static Logger log = Logger.getLogger(AccountInfoServiceImpl.class.getName());

	/**
	 * This method creates Reviewer ArrayList Adds Reviewer data to ArrayList
	 * Returns ArrayList
	 * 
	 * @return reviewer list
	 */
	public List<String> listAllReviewer() {
		List<String> tempreviewer = new ArrayList<String>();
		tempreviewer.add(CommonConstants.TEAM1);
		tempreviewer.add(CommonConstants.TEAM2);
		tempreviewer.add(CommonConstants.TEAM3);
		tempreviewer.add(CommonConstants.TEAM4);
		tempreviewer.add(CommonConstants.TEAM5);
		log.info("data added to tempreviewer list");
		return tempreviewer;
	}

	/**
	 * This method returns a AccountList
	 * 
	 * @return account list
	 * @throws VirtualMainException
	 */
	@Transactional(readOnly = true)
	public List<Account> listAllAccount(Integer accid) throws VirtualMainException {
		List<Account> accountList = accountinfodao.listAllAccount(accid);
		log.info("listAllAccount method in AccountInfoDao class returned successsfully");
		return accountList;

	}

	/**
	 * Adds the Document Status information to a list based on accountID creates map
	 * to store document status(missing,incorrect,incomplete) as true or false
	 * Returns document status
	 * 
	 * @return document status list
	 * @param accid
	 *            - AccountId
	 * @throws VirtualMainException
	 */
	@Transactional(readOnly = true)
	public List<DocRevStatus> listDocRevsts(Integer accid) throws VirtualMainException {
		List<DocRevStatus> docrevsts = accountinfodao.listAccDocStatus(accid);
		log.info("listAccDocStatus method in AccountInfoDao class returned successsfully");
		return docrevsts;
	}
}