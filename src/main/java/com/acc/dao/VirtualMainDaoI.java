package com.acc.dao;

import java.util.List;
import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.UW_Mapping;
import com.acc.exceptions.VirtualMainException;

public interface VirtualMainDaoI {
	
	public List<UW_Mapping> getUnderWriterList() throws VirtualMainException;
	
	public List<Account_UW_Mapping> getAccountList() throws VirtualMainException;
	
}
