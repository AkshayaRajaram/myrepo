package com.acc.test.service;

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

import com.acc.dao.VirtualMainDaoIImpl;
import com.acc.dto.Account;
import com.acc.dto.AccountUWMapping;
import com.acc.dto.ProductType;
import com.acc.dto.UWMapping;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;
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
	List<AccountUWMapping> arraylist3 = new ArrayList<AccountUWMapping>();

	@Spy
	List<UWMapping> arraylist4 = new ArrayList<UWMapping>();

	Account a = new Account();
	Account a1 = new Account();
	UnderWriter uw = new UnderWriter();
	AccountUWMapping auwm = new AccountUWMapping();
	AccountUWMapping auwm1 = new AccountUWMapping();

	UWMapping uwm = new UWMapping();
	Date date = new Date(11, 11, 1995);
	ProductType producttype = new ProductType();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		arraylist1 = getUnderWriter();
		arraylist2 = getAccount();
		arraylist3 = getAccountUWMapping();
		arraylist4 = getUWMapping();

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

		
		Mockito.doReturn(new ArrayList<UWMapping>()).when(daoMock).getUnderWriterList();
		Assert.assertEquals(true, (servicemock.getUnderWriterList("").isEmpty()));

	}

	@Test
	public void TestPositivegetAccountList() throws VirtualMainException {
		Mockito.doReturn(arraylist3).when(daoMock).getAccountList();
		Assert.assertEquals(servicemock.getAccountList(2), arraylist2);
	}

	@Test
	public void TestNegativegetAccountList() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<AccountUWMapping>()).when(daoMock).getAccountList();
		 Assert.assertEquals(true,servicemock.getAccountList(90).isEmpty());

	}

	private List<Account> getAccount() {
		// TODO Auto-generated method stub

		a.setAccountNumber("1001");

		a.setCreatedBy("AAA");
		a.setCreatedDate(date);
		a.setDivision("---");
		a.setName("ACC1");
		a.setUpdatedBy("AAA");
		a.setUpdatedDate(date);

		a1.setAccountNumber("1002");
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

		arraylist4.add(uwm);
		return arraylist4;
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

		auwm1.setAccUWMappingId(2);
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
		uw.setUnderWriterId(2);
		uw.setUnderWriterName("");
		uw.setDivision("");
		uw.setCreatedBy("");
		uw.setCreatedDate(date);
		uw.setUpdatedBy("");
		uw.setUpdatedDate(date);

		arraylist1.add(uw);
		return arraylist1;

	}

}
