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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.dto.Account;
import com.acc.dto.Document;
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
/***
 * 
 * @param request
 * @param response
 * @return
 */
	@RequestMapping("virtualMain.htm")
	public ModelAndView load(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("virtualMain");
		return modelandview;
	}

	/***
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws VirtualMainException
	 * @throws JsonProcessingException
	 */
	@RequestMapping("virtualMainBack.htm")
	public ModelAndView load_back(HttpServletRequest request, HttpServletResponse response)
			throws VirtualMainException, JsonProcessingException {
		ModelAndView modelandview = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();

		System.out.println("ssss" + session);
		String coverageType = (String) session.getAttribute("coverageType");
		String productType = (String) session.getAttribute("productType");
		String underWriterId = (String) session.getAttribute("id");

		List<UnderWriter> underWriterList = (List<UnderWriter>) session.getAttribute("underWriterList");
		List<Account> accountList = (List<Account>) session.getAttribute("accountList");
		System.out.println("----------------------------back----------------" + coverageType + productType
				+ underWriterList + accountList);
		String uList = "";
		String aList = "";
		uList = mapper.writeValueAsString(underWriterList);
		aList = mapper.writeValueAsString(accountList);

		modelandview.addObject("uList", uList);
		modelandview.addObject("aList", aList);
		modelandview.addObject("coverageType", coverageType);
		modelandview.addObject("underWriterId", underWriterId);
		modelandview.addObject(CommonConstants.PRODUCT_TYPE, productType);

		modelandview.setViewName("virtualMain");
		return modelandview;
	}
/***
 * 
 * @param request
 * @param response
 * @throws IOException
 * @throws VirtualMainException
 */
	@RequestMapping("getUnderWriter.htm")

	public void getUnderWriter(HttpServletRequest request, HttpServletResponse response)
			throws IOException, VirtualMainException

	{
		HttpSession session = request.getSession();
		String coverageType = request.getParameter("coverageType");
		String productType = request.getParameter("productType");
		try {
			List<UnderWriter> sendUnderWriterList = virtualservice.getUnderWriterList(productType);

			Gson gson = new Gson();

			response.setContentType("application/json");

			PrintWriter out = response.getWriter();

			out.println(gson.toJson(sendUnderWriterList));

			if (sendUnderWriterList.size() > 0) {
				session.setAttribute("underWriterList", sendUnderWriterList);
				session.setAttribute("coverageType", coverageType);
				session.setAttribute("productType", productType);
			}
		} catch (VirtualMainException e) {
			// TODO Auto-generated catch block

			System.out.println("msg" + e.getMessage());

			response.setStatus(400);
			response.getWriter().write(e.getMessage());
		}

	}

	@RequestMapping("getAccountList.htm")

	public void getAccountList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, VirtualMainException

	{
		HttpSession session = request.getSession();
		int underWriterId = Integer.parseInt(request.getParameter("id"));
		String id = request.getParameter("id");
		try {
			ArrayList<Account> accountList = (ArrayList<Account>) virtualservice.getAccountList(underWriterId);

			Gson gson = new Gson();

			response.setContentType("application/json");

			PrintWriter out = response.getWriter();

			out.println(gson.toJson(accountList));
			if (accountList.size() > 0) {
				session.setAttribute("accountList", accountList);
				session.setAttribute("underWriterId", id);
			}
		} catch (VirtualMainException e) {
			// TODO Auto-generated catch block

			System.out.println("msg" + e.getMessage());

			response.setStatus(400);
			response.getWriter().write(e.getMessage());
		}

	}

	@ExceptionHandler(VirtualMainException.class)
	public ModelAndView errorHandling(HttpServletRequest req, Exception ex, HttpServletResponse response)
			throws IOException {

		ModelAndView modelandview = new ModelAndView();
		log.error("Request" + req.getRequestURL() + "raised" + ex);
		modelandview.addObject("exception" + ex);

		modelandview.addObject("url", req.getRequestURL());
		modelandview.setViewName("error.jsp");

		return modelandview;

	}
}
