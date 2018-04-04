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
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoService;

@Controller
public class AccountInfoController {
	@Autowired
	AccountInfoService accountInfoService;
	static Logger log = Logger.getLogger(AccountInfoController.class.getName());
	
	/**
	 * Returns Account List based on given @param id, Document List based on
	 * given @param id, Reviewer List
	 * 
	 * @param request
	 * @param id
	 * @return modelandview
	 * @throws VirtualMainException
	 */
	@RequestMapping(CommonConstants.ACCOUNT_INFO_HTM)
	public ModelAndView accountinfo(HttpServletRequest request, @RequestParam(CommonConstants.ID2) String id)
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
		modelandview.setViewName(CommonConstants.ACCOUNT_INFO);
		return modelandview;
	}
	
	/**
	 * This method saves the data into the database
	 * 
	 * @param request
	 * @param response
	 * @return modelandview
	 */
	@RequestMapping(CommonConstants.ACCOUNT_SAVE_HTM)
	public ModelAndView accountSave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName(CommonConstants.SUCCESS);
		return modelandview;
	}
	
	/**
	 * Returns ModelandView Object
	 * - Exception
	 * - Url
	 * to VirtualException class
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
		modelandview.addObject(CommonConstants.EXCEPTION + ex);
		modelandview.addObject(CommonConstants.URL, req.getRequestURL());
		modelandview.setViewName(CommonConstants.ERROR_JSP);
		return modelandview;
	}
	
	/**
	 * Returns ModelandView Object
	 * - Exception Message
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView(CommonConstants.GENERIC_ERROR);
		model.addObject(CommonConstants.ERR_MSG, CommonConstants.ERROR_OCCURRED);
		return model;
	}
}
