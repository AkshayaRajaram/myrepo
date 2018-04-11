package com.acc.test.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.acc.dao.VirtualMainDaoIImpl;
import com.acc.dto.Account;
import com.acc.dto.AccountUWMapping;
import com.acc.dto.ProductType;
import com.acc.dto.UWMapping;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.VirtualServiceImpl;

public class VirtualMainInfoDaoTest {

	@Mock
	private VirtualMainDaoIImpl daoMock;

	@Mock
	private VirtualServiceImpl serviceMock;

	@Spy
	ArrayList<UWMapping> arraylist = new ArrayList<UWMapping>();
	@Spy
	List<AccountUWMapping> arraylist3 = new ArrayList<AccountUWMapping>();

	UnderWriter uw = new UnderWriter();
	UWMapping uwm = new UWMapping();
	AccountUWMapping auwm = new AccountUWMapping();
	AccountUWMapping auwm1 = new AccountUWMapping();
	Account a = new Account();
	Account a1 = new Account();
	Date date = new Date(11, 11, 1995);
	ProductType producttype = new ProductType();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestPositivegetUnderWriterList() throws VirtualMainException {
		Mockito.doReturn(arraylist).when(daoMock).getUnderWriterList();
		Assert.assertEquals(arraylist, daoMock.getUnderWriterList());
	}

	@Test
	public void TestNegativegetUnderWriterList() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<UWMapping>()).when(daoMock).getUnderWriterList();
		Assert.assertEquals(true, (daoMock.getUnderWriterList().isEmpty()));

	}

	@Test
	public void TestPositivegetAccountList() throws VirtualMainException {
		Mockito.doReturn(arraylist3).when(daoMock).getAccountList();
		Assert.assertEquals(arraylist3, daoMock.getAccountList());
	}

	@Test
	public void TestNegativegetAccountList() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<AccountUWMapping>()).when(daoMock).getAccountList();
		Assert.assertEquals(true, (daoMock).getAccountList().isEmpty());

	}

	private List<UWMapping> getUWMapping() {

		// TODO Auto-generated method stub

		uwm.setCreatedBy("AAA");
		uwm.setCreatedDate(date);
		uwm.setProductType(producttype);
		uwm.setUnderWriter(uw);
		uwm.setUpdatedBy("BBB");
		uwm.setUpdatedDate(date);
		uwm.setUwMappingId(1);
		producttype.setProductTypeId(1);
		producttype.setProductTypeName("fan");
		producttype.setUpdatedBy("sdbn");
		producttype.setUpdatedDate(date);
		producttype.setCreatedBy("asdbn");
		producttype.setCreatedDate(date);

		arraylist.add(uwm);
		return arraylist;
	}

	private List<AccountUWMapping> getAccountUWMapping() {

		// TODO Auto-generated method stub
		auwm.setAccUWMappingId(1);
		auwm.setAccount(a);
		auwm.setCreatedBy("AAA");
		auwm.setCreatedDate(date);
		auwm.setUnderWriter(uw);
		auwm.setUpdatedBy("BBB");
		auwm.setUpdatedDate(date);

		auwm1.setAccUWMappingId(1);
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
}
