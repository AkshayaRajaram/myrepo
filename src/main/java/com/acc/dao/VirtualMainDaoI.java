package com.acc.dao;

import java.util.List;

import com.acc.dto.AccountUWMapping;
import com.acc.dto.UWMapping;
import com.acc.exceptions.VirtualMainException;

public interface VirtualMainDaoI {
	
	public List<UWMapping> getUnderWriterList() throws VirtualMainException;
	
	public List<AccountUWMapping> getAccountList() throws VirtualMainException;
	
}
