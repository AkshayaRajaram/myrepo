package com.acc.service;

import java.util.List;
import com.acc.constants.DocStatus;
import com.acc.dto.Account;
import com.acc.exceptions.VirtualMainException;

public interface AccountInfoService {
	public List<String> listAllReviewer();
	
	public List<Account> listAllAccount() throws VirtualMainException;
	
	public List<DocStatus> listDocRevsts(Integer var) throws VirtualMainException;
}
