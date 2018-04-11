package com.acc.test.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.web.servlet.ModelAndView;
import com.acc.controller.AccountInfoController;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.dto.Document;
import com.acc.dto.ValidationStatus;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoServiceImpl;


public class AccountInfoControllerTest {
	
	@Mock
	private AccountInfoServiceImpl servicemock;
	
	@InjectMocks
	private AccountInfoController acccon;
	
	@Spy
	List<Account> arraylist2 = new ArrayList<Account>();
	@Spy
	List<DocRevStatus> arraylist1 = new ArrayList<DocRevStatus>();
	@Spy
	List<String> reviewerList = new ArrayList<String>();
	
	@Spy
	List<Account> ac = new ArrayList<Account>();
	

	
	Account a = new Account();
	Account a1 = new Account();
	
	@SuppressWarnings("deprecation")
	Date date = new Date(11, 11, 1995);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		arraylist2 = getAccount();
		arraylist1 = getDocRevStatus();
		reviewerList = getReviewerList();
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void TestPositiveAccountInfo() throws    VirtualMainException {

		HttpServletRequest request = Mockito.mock(HttpServletRequest.class); 
		when( servicemock.listAllAccount(1)).thenReturn(arraylist2);
		when( servicemock.listDocRevsts(1)).thenReturn(arraylist1);
		when( servicemock.listAllReviewer()).thenReturn(reviewerList);
		
		ModelAndView mav = acccon.accountinfo(request,"1");
		assertEquals( arraylist2, mav.getModel().get( "accountList" ));
		assertEquals( arraylist1, mav.getModel().get( "DocList" ));
		assertEquals( reviewerList, mav.getModel().get( "reviewerList" ));
		assertEquals( "accountInfo", mav.getViewName());
		
		
	
		
		when( servicemock.listAllAccount(0)).thenReturn(new ArrayList<Account>());
		when( servicemock.listDocRevsts(0)).thenReturn(new ArrayList<DocRevStatus>());
		when( servicemock.listAllReviewer()).thenReturn(reviewerList);
		String accid="";
		 mav = acccon.accountinfo(request,accid);
		 assertFalse(mav.getModel().containsValue(getAccount()));
		 assertFalse(mav.getModel().containsValue(getDocRevStatus()));
			assertEquals( reviewerList, mav.getModel().get( "reviewerList" ));
			assertEquals( "accountInfo", mav.getViewName());
		  
			System.out.println(mav.getModel().containsValue(getAccount()));
			
	}
	

	@Test
	public void TestAccountSave()
	{
		ModelAndView mav = acccon.accountSave(null,null);
		assertEquals( "success", mav.getViewName());
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
		
		
	    a1.setAccountId(2);
		a1.setAccountNumber("1001");
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
	
	private List<String> getReviewerList()
	{
		reviewerList.add("Team1");
		reviewerList.add("Team2");
		reviewerList.add("Team3");
		reviewerList.add("Team4");
		reviewerList.add("Team5");		
		return reviewerList;
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
