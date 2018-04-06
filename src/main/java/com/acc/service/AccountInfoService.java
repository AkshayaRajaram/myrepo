package com.acc.service;

import java.util.List;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;

public interface AccountInfoService {
	public List<String> listAllReviewer();
	
	public List<Account> listAllAccount(Integer var) throws VirtualMainException;
	
	public List<DocRevStatus> listDocRevsts(Integer var) throws VirtualMainException;
}
