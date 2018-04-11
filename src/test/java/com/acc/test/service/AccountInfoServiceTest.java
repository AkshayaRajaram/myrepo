package com.acc.test.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.acc.dao.AccountInfoDaoImpl;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.dto.Document;
import com.acc.dto.ValidationStatus;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoServiceImpl;

public class AccountInfoServiceTest {

	@Mock
	private AccountInfoDaoImpl daoMock;

	@InjectMocks
	private AccountInfoServiceImpl servicemock;

	@Spy
	List<String> arraylist = new ArrayList<String>();

	@Spy
	List<DocRevStatus> arraylist1 = new ArrayList<DocRevStatus>();

	@Spy
	List<Account> arraylist2 = new ArrayList<Account>();

	Account a = new Account();
	Account a1 = new Account();

	@SuppressWarnings("deprecation")
	Date date = new Date(11, 11, 1995);

	DocRevStatus ds = new DocRevStatus();
	DocRevStatus ds1 = new DocRevStatus();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		arraylist1 = getDocRevStatus();
		arraylist2 = getAccount();
	}

	
	
	

	@Test
	public void TestPositivelistAllAccount() throws VirtualMainException {

		Mockito.doReturn(arraylist2).when(daoMock).listAllAccount(1);
		Assert.assertEquals(arraylist2.get(0).getAccountId(), servicemock.listAllAccount(1).get(0).getAccountId());

	}

	@Test
	public void TestNegativelistAllAccount() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<Account>()).when(daoMock).listAllAccount(90);
		Assert.assertEquals(true, servicemock.listAllAccount(90).isEmpty());
	}

	@Test
	public void TestPositivelistDocRevsts() throws VirtualMainException {
		Mockito.doReturn(arraylist1).when(daoMock).listAccDocStatus(1);
		Assert.assertEquals(arraylist1.get(0).getDocRevStatusId(),
				servicemock.listDocRevsts(1).get(0).getDocRevStatusId());
	}

	@Test
	public void TestNegativelistDocRevsts() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<DocRevStatus>()).when(daoMock).listAccDocStatus(90);
		Assert.assertEquals(true, servicemock.listDocRevsts(90).isEmpty());

	}

	private List<Account> getAccount() {
		// TODO Auto-generated method stub

		a.setAccountId(1);
		a.setAccountNumber("1001");
		a.setCreatedBy("AAA");
		a.setCreatedDate(date);
		a.setDivision("---");
		a.setName("ACC1");
		a.setUpdatedBy("AAA");
		a.setUpdatedDate(date);

		arraylist2.add(a);

		return arraylist2;
	}

	private List<DocRevStatus> getDocRevStatus() {
		// TODO Auto-generated method stub

		Document d = new Document();
		d.setCreatedBy("");
		d.setCreatedDate(date);
		d.setDivision("");
		d.setDocId(1);
		d.setDocName("doc1");
		d.setFileName("file1");
		d.setUpdatedBy("");
		d.setUpdatedDate(date);

		ValidationStatus v = new ValidationStatus();
		v.setCreatedBy("");
		v.setCreatedDate(date);
		v.setStatus("MISSED");
		v.setStatusId(2);
		v.setUpdatedBy("");
		v.setUpdatedDate(date);

		DocRevStatus drs = new DocRevStatus();
		drs.setAccount(a);
		drs.setCreatedBy("");
		drs.setCreatedDate(date);
		drs.setDocRevStatusId(1);
		drs.setDocument(d);
		drs.setUpdatedBy("");
		drs.setUpdatedDate(date);
		drs.setValidationstatus(v);

		arraylist1.add(drs);

		return arraylist1;
	}

}
