package com.acc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.acc.constants.CommonConstants;
import com.acc.dto.Account;
import com.acc.dto.UnderWriter;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.VirtualService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Controller
public class VirtualMainController {

	@Autowired
	VirtualService virtualservice;
	static Logger log = Logger.getLogger(VirtualMainController.class.getName());

	/**
	 * Returns Home Page Model and View object
	 * 
	 * @param request
	 * @param response
	 * @return ModelandView
	 */
	@RequestMapping(CommonConstants.VIRTUAL_MAIN_HTM)
	public ModelAndView load(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName(CommonConstants.VIRTUAL_MAIN);
		modelandview.addObject(CommonConstants.ISBACK, false);
		return modelandview;
	}

	/**
	 * Returns Model and View Object which contains UnderWriter List, Account
	 * List, CoverageType, UnderWriterId, ProductType
	 * 
	 * Stores the Session values in the model and view object
	 * 
	 * @param request
	 * @param response
	 * @return ModelandView
	 * @throws VirtualMainException
	 * @throws JsonProcessingException
	 */
	@RequestMapping(CommonConstants.VIRTUAL_MAIN_BACK_HTM)
	public ModelAndView loadBack(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
		ModelAndView modelandview = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();
		String coverageType = (String) session.getAttribute(CommonConstants.COVERAGE_TYPE);
		String productType = (String) session.getAttribute(CommonConstants.PRODUCT_TYPE);
		String underWriterId = (String) session.getAttribute(CommonConstants.ID);
		List<UnderWriter> underWriterList = (List<UnderWriter>) session.getAttribute(CommonConstants.UNDER_WRITER_LIST);
		List<Account> accountList = (List<Account>) session.getAttribute(CommonConstants.ACCOUNT_LIST);
		String uList ="";
			uList=	mapper.writeValueAsString(underWriterList);
		
		String aList ="";
			aList	=mapper.writeValueAsString(accountList);
		modelandview.addObject(CommonConstants.U_LIST, uList);
		modelandview.addObject(CommonConstants.A_LIST, aList);
		modelandview.addObject(CommonConstants.COVERAGE_TYPE, coverageType);
		modelandview.addObject(CommonConstants.UNDER_WRITER_ID, underWriterId);
		modelandview.addObject(CommonConstants.PRODUCT_TYPE, productType);
		modelandview.setViewName(CommonConstants.VIRTUAL_MAIN);
		modelandview.addObject(CommonConstants.ISBACK, true);
		return modelandview;
	}

	/**
	 * JSON Object for UnderWriterList when an ajax call is hit
	 * 
	 * Stores the Session values 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws VirtualMainException
	 */
	@RequestMapping(CommonConstants.GET_UNDER_WRITER_HTM)
	public void getUnderWriter(HttpServletRequest request, HttpServletResponse response)
			throws IOException, VirtualMainException

	{
		HttpSession session = request.getSession();
		String coverageType = request.getParameter(CommonConstants.COVERAGE_TYPE);
		String productType = request.getParameter(CommonConstants.PRODUCT_TYPE);
	
		try {
			List<UnderWriter> sendUnderWriterList = virtualservice.getUnderWriterList(productType);
			log.info("getUnderWriterList method in virtualservice class returned successfully");
			Gson gson = new Gson();
			response.setContentType(CommonConstants.APPLICATION_JSON);
			PrintWriter out = response.getWriter();
			out.println(gson.toJson(sendUnderWriterList));
			if (!sendUnderWriterList.isEmpty()) {
				session.setAttribute(CommonConstants.UNDER_WRITER_LIST, sendUnderWriterList);
				session.setAttribute(CommonConstants.COVERAGE_TYPE, coverageType);
				session.setAttribute(CommonConstants.PRODUCT_TYPE, productType);
			}
		} catch (VirtualMainException e) {
			response.setStatus(400);
			response.getWriter().write(e.getMessage());
			log.info(e.getMessage());
		}
	}

	/**
	 *  JSON Object for AccountList when an ajax call is hit
	 * 
	 * Stores the Session values 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws VirtualMainException
	 */
	@RequestMapping(CommonConstants.GET_ACCOUNT_LIST_HTM)
	public void getAccountList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, VirtualMainException {
		HttpSession session = request.getSession();
		int underWriterId = Integer.parseInt(request.getParameter(CommonConstants.ID));
		String id = request.getParameter(CommonConstants.ID);
		try {
			ArrayList<Account> accountList = (ArrayList<Account>) virtualservice.getAccountList(underWriterId);
			Gson gson = new Gson();
			response.setContentType(CommonConstants.APPLICATION_JSON);
			PrintWriter out = response.getWriter();
			out.println(gson.toJson(accountList));
			if (!accountList.isEmpty()) {
				session.setAttribute(CommonConstants.ACCOUNT_LIST, accountList);
				session.setAttribute(CommonConstants.UNDER_WRITER_ID, id);
			}
		} catch (VirtualMainException e) {
			response.setStatus(400);
			response.getWriter().write(e.getMessage());
			log.info(e.getMessage());
		}

	}

	/**
	 * Returns ModelandView Object - Exception - Url to VirtualException class
	 * 
	 * @param req
	 * @param ex
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(VirtualMainException.class)
	public ModelAndView errorHandling(HttpServletRequest req, Exception ex, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();
		log.error("Request" + req.getRequestURL() + "raised" + ex);
		modelandview.addObject(CommonConstants.EXCEPTION + ex);
		modelandview.addObject(CommonConstants.URL, req.getRequestURL());
		modelandview.setViewName(CommonConstants.ERROR_JSP);
		return modelandview;

	}
}
