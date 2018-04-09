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
		System.out.println(mav.getModel().get(0));
		assertEquals( arraylist2, mav.getModel().get( "accountList" ));
		assertEquals( arraylist1, mav.getModel().get( "DocList" ));
		assertEquals( reviewerList, mav.getModel().get( "reviewerList" ));
		assertEquals( "accountInfo", mav.getViewName());
		
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void TestNegativeAccountInfo() throws  VirtualMainException
	{
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		when( servicemock.listAllAccount(60)).thenReturn(arraylist2);
		when( servicemock.listDocRevsts(60)).thenReturn(arraylist1);
		when( servicemock.listAllReviewer()).thenReturn(reviewerList);	
		ModelAndView mav = acccon.accountinfo(null,"");
		//assertEquals(0,((List<Account>) mav.getModel().get("accountList")).size());
		//assertEquals(true,mav.getModel().get("accountList")).equals(new ArrayList<Account>()));
		System.out.println(mav.getModel().containsValue(null));
		System.out.println(mav.getModel().get(0));
		//assertEquals(0,((List<Document>) mav.getModel().get("DocList")).size());
		//assertEquals(0,((List<Reviewer>) mav.getModel().get("reviewerList")).size());
		
		
	}
	
	
	
	@Test
	public void TestAccountSave()
	{
		ModelAndView mav = acccon.accountSave(null,null);
		assertEquals( "success", mav.getViewName());
	}
	private List<Account> getAccount() {
		// TODO Auto-generated method stub
	
		a.setAccount_Id(1);
		a.setAccount_Number("1001");
		a.setCreatedBy("AAA");
		a.setCreatedDate(date);
		a.setDivision("---");
		a.setName("ACC1");
		a.setUpdatedBy("AAA");
		a.setUpdatedDate(date);
		
		
	    a1.setAccount_Id(2);
		a1.setAccount_Number("1001");
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
		//List<String> reviewer = new ArrayList<String>();
		reviewerList.add("Team1");
		reviewerList.add("Team2");
		reviewerList.add("Team3");
		reviewerList.add("Team4");
		reviewerList.add("Team5");
		/*List<String> reviewerList = new ArrayList<String>();	
		
		reviewerList.addAll(reviewer);*/
		
		return reviewerList;
	}

	private List<DocRevStatus> getDocRevStatus() {
		// TODO Auto-generated method stub

		Document d = new Document();
		d.setCreatedBy("");
		d.setCreatedDate(date);
		d.setDivision("");
		d.setDoc_Id(1);
		d.setDoc_Name("doc1");
		d.setFile_Name("file1");
		d.setUpdatedBy("");
		d.setUpdatedDate(date);

		ValidationStatus v = new ValidationStatus();
		v.setCreatedBy("");
		v.setCreatedDate(date);
		v.setStatus("MISSED");
		v.setStatus_Id(2);
		v.setUpdatedBy("");
		v.setUpdatedDate(date);

		DocRevStatus drs = new DocRevStatus();
		drs.setAccount(a);
		drs.setCreated_By("");
		drs.setCreated_Date(date);
		drs.setDoc_Rev_Status_Id(1);
		drs.setDocument(d);
		drs.setUpdated_By("");
		drs.setUpdated_Date(date);
		drs.setValidationstatus(v);

		arraylist1.add(drs);

		return arraylist1;
	}

}
