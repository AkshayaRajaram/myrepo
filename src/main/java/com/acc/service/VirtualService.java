package com.acc.service;

import java.util.List;

import com.acc.dto.Account;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;

public interface VirtualService {
	public List<UnderWriter> getUnderWriterList(String productType) throws VirtualMainException;

	public List<Account> getAccountList(int underWriterId) throws VirtualMainException;

}
