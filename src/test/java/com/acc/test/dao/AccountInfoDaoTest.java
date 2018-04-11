package com.acc.test.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

public class AccountInfoDaoTest {

	@Mock
	private AccountInfoDaoImpl daoMock;

	@Spy
	List<Account> arraylist = new ArrayList<Account>();

	@Spy
	List<DocRevStatus> arraylist3 = new ArrayList<DocRevStatus>();

	Account a = new Account();

	@SuppressWarnings("deprecation")
	Date date = new Date(11, 11, 1995);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		arraylist = getAccount();
		arraylist3 = getDocRevStatus();

	}

	@Test
	public void TestPositivelistAllAccount() throws VirtualMainException {

		Mockito.doReturn(arraylist).when(daoMock).listAllAccount(1);
		Assert.assertEquals(arraylist, daoMock.listAllAccount(1));

	}

	@Test
	public void TestNegativelistAllAccount() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<Account>()).when(daoMock).listAllAccount(90);
		Assert.assertEquals(true, (daoMock.listAllAccount(90).isEmpty()));

	}

	@Test
	public void TestPositivelistAccDocStatus() throws VirtualMainException {

		Mockito.doReturn(arraylist3).when(daoMock).listAccDocStatus(1);
		Assert.assertEquals(arraylist3, daoMock.listAccDocStatus(1));
	}

	@Test
	public void TestNegativelistAccDocStatus() throws VirtualMainException {

		Mockito.doReturn(new ArrayList<DocRevStatus>()).when(daoMock).listAccDocStatus(90);
		Assert.assertEquals(true, (daoMock.listAllAccount(90)).isEmpty());

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

		arraylist.add(a);

		return arraylist;
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

		arraylist3.add(drs);

		return arraylist3;
	}

}
