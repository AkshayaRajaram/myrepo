package com.acc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.constants.DocStatus;
import com.acc.dto.Account;
import com.acc.dto.Document;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoService;
import com.acc.service.VirtualService;

@Controller
public class AccountInfoController {

	@Autowired
	AccountInfoService accountInfoService;
	static Logger log = Logger.getLogger(AccountInfoController.class.getName());

	/***
	 * 
	 * 
	 * 
	 * @param request
	 * @param id
	 *            an accountid
	 * @return
	 * @throws VirtualMainException
	 */
	@RequestMapping("accountInfo.htm")
	public ModelAndView accountinfo(HttpServletRequest request, @RequestParam("id") String id)
			throws VirtualMainException {
		ModelAndView modelandview = new ModelAndView();

		List<Account> accountList;

		accountList = accountInfoService.listAllAccount();
		List<Account> accountList2 = new ArrayList<Account>();

		for (Account var : accountList) {
			if (var.getAccount_Id() == Integer.valueOf(id)) {
				accountList2.add(var);
			}
		}

		Integer var = Integer.valueOf(id);
		List<DocStatus> DocList = accountInfoService.listDocRevsts(var);
		List<String> reviewerList = accountInfoService.listAllReviewer();
		modelandview.addObject(CommonConstants.DOC_LIST, DocList);
		modelandview.addObject(CommonConstants.ACCOUNT_LIST, accountList2);
		modelandview.addObject(CommonConstants.REVIEWER_LIST, reviewerList);
		modelandview.setViewName("account");

		return modelandview;
	}

	/***
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("accountSave.htm")
	public ModelAndView accountSave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("success");
		return modelandview;
	}

	/****
	 * 
	 * @param req
	 * @param ex
	 * @param response
	 * @return
	 * @throws IOException
	 */
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

	/***
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("generic_error");
		model.addObject("errMsg", "ERROR OCCURRED");
		return model;

	}
}
