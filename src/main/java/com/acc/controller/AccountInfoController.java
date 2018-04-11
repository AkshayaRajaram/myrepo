package com.acc.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.AccountInfoService;

@Controller
public class AccountInfoController extends AbstractController {
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
		Integer accid;
		accid = !id.isEmpty() ? Integer.parseInt(id) : 0;
		List<Account> accountList = accountInfoService.listAllAccount(accid);
		log.info("listAllAccount method in accountInfoService class returned successfully");
		List<DocRevStatus> docList = accountInfoService.listDocRevsts(accid);
		log.info("listDocRevsts method in accountInfoService class returned successfully");
		List<String> reviewerList = accountInfoService.listAllReviewer();
		log.info("listAllReviewer method in accountInfoService class returned successfully");
		String errormessage = "No data Found";
		modelandview.addObject(CommonConstants.DOC_LIST, !docList.isEmpty() ? docList : errormessage);
		modelandview.addObject(CommonConstants.ACCOUNT_LIST, !accountList.isEmpty() ? accountList : errormessage);
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

}
