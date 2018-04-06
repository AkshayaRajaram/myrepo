package com.acc.test.controller;

import static org.junit.Assert.*;

import org.junit.Test;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import com.acc.controller.AccountInfoController;
import com.acc.controller.VirtualMainController;
import com.acc.dto.Account;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoServiceImpl;
import com.acc.service.VirtualServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class VirtualMainControllerTest {

	@Mock
	private VirtualServiceImpl servicemock;
	
	@InjectMocks
	private VirtualMainController conmock;
	
	@Spy
	List<UnderWriter> arraylist1 = new ArrayList<UnderWriter>();
	@Spy
	List<Account> arraylist2 = new ArrayList<Account>();
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void Testload()
	{
		ModelAndView mav = conmock.load(null,null);
		assertEquals( "virtualMain", mav.getViewName());
	}
	
	@Test
	public void Testload_back() throws VirtualMainException, JsonProcessingException
	{
	//	ModelAndView mav = conmock.load_back(null,null);
		/*assertEquals( arraylist1, mav.getModel().get( "uList" ));
		assertEquals( arraylist2, mav.getModel().get( "aList" ));*/
		
	}
	@Test
	public void getUnderWriter() throws VirtualMainException, IOException
	{
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);    

     //   when(request.getParameter("productType")).thenReturn("B1");
       

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
       // when(response.getWriter()).thenReturn(writer);

        conmock.getUnderWriter(request, response);

      //  verify(request, atLeast(1)).getParameter("productType");
        
        // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
       // assertTrue(stringWriter.toString().contains("My expected string"));
		
	}

}
