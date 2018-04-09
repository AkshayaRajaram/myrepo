package com.acc.test.dao;



import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.acc.dao.VirtualMainDaoIImpl;
import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.UW_Mapping;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.VirtualServiceImpl;


public class VirtualMainInfoDaoTest {


	@Mock
	private VirtualMainDaoIImpl daoMock;
	
	@Mock
	private VirtualServiceImpl serviceMock;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestPositivegetUnderWriterList() throws VirtualMainException {

		ArrayList<UW_Mapping> arraylist = new ArrayList<UW_Mapping>();
		Mockito.doReturn(arraylist).when(daoMock).getUnderWriterList();
		Assert.assertEquals(arraylist, daoMock.getUnderWriterList());
	}
	
	@Test
	public void TestNegativegetUnderWriterList() throws VirtualMainException {

		Mockito.doReturn(null).when(daoMock).getUnderWriterList();
		// Assert.assertEquals(null, daoMock.listAllAccount());
	}

	@Test
	public void TestPositivegetAccountList() throws VirtualMainException {

		List<Account_UW_Mapping> arraylist = new ArrayList<Account_UW_Mapping>();
		Mockito.doReturn(arraylist).when(daoMock).getAccountList();
		// Assert.assertEquals(arraylist, daoMock.getAccountList());
	}

	@Test
	public void TestNegativegetAccountList() throws VirtualMainException {

		Mockito.doReturn(null).when(daoMock).getAccountList();
		
	}

}
