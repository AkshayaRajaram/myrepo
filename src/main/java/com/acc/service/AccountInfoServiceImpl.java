package com.acc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.constants.CommonConstants;
import com.acc.constants.DocStatus;
import com.acc.dao.AccountInfoDao;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
	
	@Autowired
	AccountInfoDao accountinfodao;
	
	/**
	 * This method creates Reviewer ArrayList
	 * Adds Reviewer data to ArrayList
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
		return tempreviewer;
	}
	
	/**
	 * This method returns a AccountList
	 * 
	 * @return account list
	 * @throws VirtualMainException
	 */
	@Transactional(readOnly = true)
	public List<Account> listAllAccount() throws VirtualMainException {
		List<Account> accountList = accountinfodao.listAllAccount();
		return accountList;
		
	}
	
	/**
	 * Adds the Document Status information to a list based on accountID
	 * creates map to store document status(missing,incorrect,incomplete) as
	 * true or false
	 * Returns document status
	 * 
	 * @return document status list
	 * @param accid
	 *            - AccountId
	 * @throws VirtualMainException
	 */
	@Transactional(readOnly = true)
	public List<DocStatus> listDocRevsts(Integer accid) throws VirtualMainException {
		List<DocRevStatus> docrevsts = accountinfodao.listAccDocStatus();
		List<DocRevStatus> docrevsts1 = new ArrayList<DocRevStatus>();
		for (DocRevStatus drs : docrevsts) {
			if (drs.getAccount().getAccount_Id() == accid) {
				docrevsts1.add(drs);
			}
		}
		List<DocStatus> docsts = new ArrayList<DocStatus>();
		for (DocRevStatus temp : docrevsts1) {
			DocStatus dc = new DocStatus();
			Map<String, Boolean> map = new HashMap<String, Boolean>();
			String sts;
			if (temp.getValidationstatus().getStatus_Id() == 2) {
				sts = temp.getValidationstatus().getStatus();
				dc.setDocid(temp.getDocument().getDoc_Id());
				dc.setDocname(temp.getDocument().getDoc_Name());
				dc.setFilename(temp.getDocument().getFile_Name());
				map.put(sts, true);
				dc.setStatus(map);
				dc.setSts(CommonConstants.INCOMPLETE);
				docsts.add(dc);
				
			} else if (temp.getValidationstatus().getStatus_Id() == 3) {
				sts = temp.getValidationstatus().getStatus();
				dc.setDocid(temp.getDocument().getDoc_Id());
				dc.setDocname(temp.getDocument().getDoc_Name());
				dc.setFilename(temp.getDocument().getFile_Name());
				map.put(sts, true);
				dc.setStatus(map);
				dc.setSts(CommonConstants.MISSING);
				docsts.add(dc);
				
			} else if (temp.getValidationstatus().getStatus_Id() == 4) {
				sts = temp.getValidationstatus().getStatus();
				dc.setDocid(temp.getDocument().getDoc_Id());
				dc.setDocname(temp.getDocument().getDoc_Name());
				dc.setFilename(temp.getDocument().getFile_Name());
				map.put(sts, true);
				dc.setStatus(map);
				dc.setSts(CommonConstants.INCORRECT);
				docsts.add(dc);
			}
		}
		return docsts;
	}
}