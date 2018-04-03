package com.acc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.UW_Mapping;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;

public interface VirtualMainDaoI {
	
	public List<UW_Mapping> getUnderWriterList() throws VirtualMainException;
	public List<Account_UW_Mapping> getAccountList() throws VirtualMainException;

}
