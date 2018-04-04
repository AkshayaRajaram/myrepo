package com.acc.dao;

import java.util.List;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;

public interface AccountInfoDao {
	public List<Account> listAllAccount() throws VirtualMainException;

	public List<DocRevStatus> listAccDocStatus() throws VirtualMainException;
}
