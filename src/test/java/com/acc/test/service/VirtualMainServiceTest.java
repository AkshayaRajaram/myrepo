package com.acc.test.service;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.acc.dao.AccountInfoDaoImpl;
import com.acc.dao.VirtualMainDaoIImpl;
import com.acc.dto.Account;
import com.acc.dto.Account_UW_Mapping;
import com.acc.dto.DocRevStatus;
import com.acc.dto.ProductType;
import com.acc.dto.UW_Mapping;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoServiceImpl;
import com.acc.service.VirtualServiceImpl;

public class VirtualMainServiceTest {

	@Mock
	private VirtualMainDaoIImpl daoMock;

	@InjectMocks
	private VirtualServiceImpl servicemock;

	@Spy
	List<String> arraylist = new ArrayList<String>();

	@Spy
	List<UnderWriter> arraylist1 = new ArrayList<UnderWriter>();

	@Spy
	List<Account> arraylist2 = new ArrayList<Account>();

	@Spy
	List<Account_UW_Mapping> arraylist3 = new ArrayList<Account_UW_Mapping>();

	@Spy
	List<UW_Mapping> arraylist4 = new ArrayList<UW_Mapping>();

	Account a = new Account();
	Account a1 = new Account();
	UnderWriter uw = new UnderWriter();
	Account_UW_Mapping auwm = new Account_UW_Mapping();
	Account_UW_Mapping auwm1 = new Account_UW_Mapping();

	UW_Mapping uwm = new UW_Mapping();
	Date date = new Date(11, 11, 1995);
	ProductType producttype = new ProductType();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		arraylist1 = getUnderWriter();
		arraylist2 = getAccount();
		arraylist3 = getAccount_UW_Mapping();
		arraylist4 = getUW_Mapping();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestPositivegetUnderWriterList() throws VirtualMainException {

		Mockito.doReturn(arraylist4).when(daoMock).getUnderWriterList();

		Assert.assertEquals(servicemock.getUnderWriterList("fan"), arraylist1);

	}

	@Test
	public void TestNegativegetUnderWriterList() throws VirtualMainException {

		Mockito.doReturn(arraylist4).when(daoMock).getUnderWriterList();
		Assert.assertEquals(servicemock.getUnderWriterList("").size(), 0);
	}

	@Test
	public void TestPositivegetAccountList() throws VirtualMainException {
		Mockito.doReturn(arraylist3).when(daoMock).getAccountList();
		Assert.assertEquals(servicemock.getAccountList(2), arraylist2);
	}

	@Test
	public void TestNegativegetAccountList() throws VirtualMainException {

		Mockito.doReturn(null).when(daoMock).getAccountList();
		// Assert.assertEquals(servicemock.getAccountList(0), null );

	}

	private List<Account> getAccount() {
		// TODO Auto-generated method stub

		a.setAccount_Number("1001");

		a.setCreatedBy("AAA");
		a.setCreatedDate(date);
		a.setDivision("---");
		a.setName("ACC1");
		a.setUpdatedBy("AAA");
		a.setUpdatedDate(date);

		a1.setAccount_Number("1002");
		a1.setCreatedBy("AAA");
		a1.setCreatedDate(date);
		a1.setDivision("---");
		a1.setName("ACC1");
		a1.setUpdatedBy("AAA");
		a1.setUpdatedDate(date);

		arraylist2.add(a);
		arraylist2.add(a1);

		return arraylist2;
	}

	private List<UW_Mapping> getUW_Mapping() {

		// TODO Auto-generated method stub

		uwm.setCreatedBy("AAA");
		uwm.setCreatedDate(date);
		uwm.setProductType(producttype);
		uwm.setUnderWriter(uw);
		uwm.setUpdatedBy("BBB");
		uwm.setUpdatedDate(date);
		uwm.setUw_Mapping_Id(1);
		producttype.setProductType_Id(1);
		producttype.setProductType_Name("fan");
		producttype.setUpdatedBy("sdbn");
		producttype.setUpdatedDate(date);
		producttype.setCreatedBy("asdbn");
		producttype.setCreatedDate(date);

		arraylist4.add(uwm);
		return arraylist4;
	}

	private List<Account_UW_Mapping> getAccount_UW_Mapping() {

		// TODO Auto-generated method stub
		auwm.setAcc_UW_Mapping_Id(1);
		auwm.setAccount(a);
		auwm.setCreatedBy("AAA");
		auwm.setCreatedDate(date);
		auwm.setUnderWriter(uw);
		auwm.setUpdatedBy("BBB");
		auwm.setUpdatedDate(date);

		auwm1.setAcc_UW_Mapping_Id(2);
		auwm1.setAccount(a1);
		auwm1.setCreatedBy("AAA");
		auwm1.setCreatedDate(date);
		auwm1.setUnderWriter(uw);
		auwm1.setUpdatedBy("BBB");
		auwm1.setUpdatedDate(date);

		arraylist3.add(auwm);
		arraylist3.add(auwm1);
		return arraylist3;
	}

	private List<UnderWriter> getUnderWriter() {

		// TODO Auto-generated method stub
		uw.setUnderWriter_Id(2);
		uw.setUnderWriter_Name("");
		uw.setDivision("");
		uw.setCreatedBy("");
		uw.setCreatedDate(date);
		uw.setUpdatedBy("");
		uw.setUpdatedDate(date);

		arraylist1.add(uw);
		return arraylist1;

	}

}
