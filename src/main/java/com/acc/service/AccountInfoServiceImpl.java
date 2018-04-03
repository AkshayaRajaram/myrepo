package com.acc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.constants.DocStatus;
import com.acc.dao.AccountInfoDao;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
	@Autowired
	AccountInfoDao accountinfodao;

	public List<String> listAllReviewer() {
		// Adding data to reviewer
		List<String> tempreviewer = new ArrayList<String>();
		tempreviewer.add("Team1");
		tempreviewer.add("Team2");
		tempreviewer.add("Team3");
		tempreviewer.add("Team4");
		tempreviewer.add("Team5");
		//reviewer.setReviewerList(tempreviewer);
		List<String> tempreviewer1 = new ArrayList<String>();
		//tempreviewer1 = reviewer.getReviewerList();
		return tempreviewer;
	}

	@Transactional(readOnly=true)
	public List<Account> listAllAccount() throws VirtualMainException  {

		List<Account> accountList = new ArrayList<Account>();
		accountList = accountinfodao.listAllAccount();

		return accountList;

	}

	@Transactional(readOnly=true)
	public List<DocStatus> listDocRevsts(Integer accid) throws VirtualMainException {

		List<DocRevStatus> docrevsts = accountinfodao.listAccDocStatus(accid);
		List<DocRevStatus> docrevsts1 = new ArrayList<DocRevStatus>();

		for (DocRevStatus drs : docrevsts) {
			if (drs.getAccount().getAccount_Id()==accid) {
				docrevsts1.add(drs);
			}		
		}



		List<DocStatus> docsts = new ArrayList();


		for (DocRevStatus temp : docrevsts1) {
			DocStatus dc = new DocStatus();
			Map<String,Boolean> map = new HashMap<String,Boolean>();
			Boolean flag;
			String sts;
			if(temp.getValidationstatus().getStatus_Id()==2)
			{
				sts=temp.getValidationstatus().getStatus();

				dc.setDocid(temp.getDocument().getDoc_Id());
				dc.setDocname(temp.getDocument().getDoc_Name());
				dc.setFilename(temp.getDocument().getFile_Name());
				map.put(sts, true);
				dc.setStatus(map);
				dc.setSts("Incomplete");
				docsts.add(dc);

			}
			if(temp.getValidationstatus().getStatus_Id()==3) 
			{
				sts=temp.getValidationstatus().getStatus();
				dc.setDocid(temp.getDocument().getDoc_Id());
				dc.setDocname(temp.getDocument().getDoc_Name());
				dc.setFilename(temp.getDocument().getFile_Name());
				map.put(sts, true);
				dc.setStatus(map);
				dc.setSts("Missing");
				docsts.add(dc);

			}
			if(temp.getValidationstatus().getStatus_Id()==4) {
				sts=temp.getValidationstatus().getStatus();
				dc.setDocid(temp.getDocument().getDoc_Id());
				dc.setDocname(temp.getDocument().getDoc_Name());
				dc.setFilename(temp.getDocument().getFile_Name()); 
				map.put(sts, true);
				dc.setStatus(map);
				dc.setSts("Incorrect");
				docsts.add(dc);


			}

		}


		return docsts;
	}
}
