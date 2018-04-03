package com.acc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.AccountInfoDao;
import com.acc.dao.AccountInfoDaoImpl;

import com.acc.dao.VirtualMainDaoI;
import com.acc.dao.VirtualMainDaoIImpl;
import com.acc.dto.Account;
import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.Document;
import com.acc.dto.UW_Mapping;
//import com.acc.dto.Reviewer;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;

@Service
public class VirtualServiceImpl implements VirtualService {
	
	@Autowired
	VirtualMainDaoI virtualmaindao;

	@Transactional(readOnly=true)
	public List<UnderWriter> getUnderWriterList(String productType) throws VirtualMainException

	{
		
		ArrayList<UnderWriter> UnderWriterList = new ArrayList<UnderWriter>();
		List<UW_Mapping> UW_Mapping = virtualmaindao.getUnderWriterList();
		for (UW_Mapping uw_map : UW_Mapping) {
			
			if (uw_map.getProductType().getProductType_Name().equals(productType)) {
				UnderWriterList.add(uw_map.getUnderWriter());
				
			}
		}
	
		return UnderWriterList;
		
		

	}
	
	@Transactional(readOnly=true)
	public List<Account> getAccountList(int underWriterId) throws VirtualMainException

	{
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		List<Account_UW_Mapping> UW_Account_Mapping = virtualmaindao.getAccountList();
		for (Account_UW_Mapping map : UW_Account_Mapping) {
			
			if (map.getUnderWriter().getUnderWriter_Id() == underWriterId) {
				accountList.add(map.getAccount());
			}
		}

		
		return accountList;
	}

	

	
}