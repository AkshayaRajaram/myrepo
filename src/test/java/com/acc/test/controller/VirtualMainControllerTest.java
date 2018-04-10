package com.acc.test.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.controller.VirtualMainController;
import com.acc.dto.Account;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;

import com.acc.service.VirtualServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VirtualMainControllerTest {

	@Mock
	private VirtualServiceImpl servicemock;

	@InjectMocks
	private VirtualMainController conmock;

	 @Mock 
	 private HttpSession mockHttpSession;

	@Spy
	List<UnderWriter> arraylist1 = new ArrayList<UnderWriter>();
	@Spy
	List<Account> arraylist2 = new ArrayList<Account>();
	Account a = new Account();
	Account a1 = new Account();
	UnderWriter uw = new UnderWriter();
	Date date = new Date(11, 11, 1995);
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		arraylist1 = getUnderWriterList();
		arraylist2 = getAccount();

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void Testload() {
		ModelAndView mav = conmock.load(null, null);
		assertEquals(CommonConstants.VIRTUAL_MAIN, mav.getViewName());
		assertEquals( false, mav.getModel().get( CommonConstants.ISBACK ));
		
	}

	@Test
	public void Testload_back() throws VirtualMainException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		when(request.getSession()).thenReturn(mockHttpSession);
		when(mockHttpSession.getAttribute(CommonConstants.COVERAGE_TYPE)).thenReturn("B");
		when(mockHttpSession.getAttribute(CommonConstants.PRODUCT_TYPE)).thenReturn("B1");
		when(mockHttpSession.getAttribute(CommonConstants.ID)).thenReturn("1");
		when(mockHttpSession.getAttribute(CommonConstants.UNDER_WRITER_LIST)).thenReturn(arraylist1);
		when(mockHttpSession.getAttribute(CommonConstants.ACCOUNT_LIST)).thenReturn(arraylist2);
		ModelAndView mav = conmock.loadBack(request, response);		
		String uList = mapper.writeValueAsString(arraylist1);
		String aList = mapper.writeValueAsString(arraylist2);
		assertEquals(CommonConstants.VIRTUAL_MAIN, mav.getViewName());
		assertEquals( "B", mav.getModel().get(CommonConstants.COVERAGE_TYPE));
		assertEquals( "B1", mav.getModel().get(CommonConstants.PRODUCT_TYPE));
		assertEquals( "1", mav.getModel().get(CommonConstants.UNDER_WRITER_ID));
		assertEquals( uList, mav.getModel().get(CommonConstants.U_LIST));
		assertEquals(aList, mav.getModel().get(CommonConstants.A_LIST));

	}
	
	
	@Test
	public void TestgetUnderWriter() throws VirtualMainException, IOException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		when(request.getSession()).thenReturn(mockHttpSession);
	    when(request.getParameter(CommonConstants.PRODUCT_TYPE)).thenReturn("B1");
	    when( servicemock.getUnderWriterList("B1")).thenReturn(arraylist1);
	    StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);
		conmock.getUnderWriter(request, response);
	    Assert.assertEquals(servicemock.getUnderWriterList("B1"), arraylist1);
	   

	}
	
    
	@Test
	public void TestgetAccountList() throws VirtualMainException,IOException{
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		when(request.getSession()).thenReturn(mockHttpSession);
	    when(request.getParameter(CommonConstants.ID)).thenReturn("1");
	    when( servicemock.getAccountList(1)).thenReturn(arraylist2);
	    StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);
		conmock.getUnderWriter(request, response);
	    Assert.assertEquals(servicemock.getAccountList(1), arraylist2);
		
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
	private List<UnderWriter> getUnderWriterList() {

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
