package com.acc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;
import com.acc.exceptions.VirtualMainException;
import com.acc.service.VirtualService;

@ControllerAdvice
public abstract class AbstractController {
	
	
	
	//static Logger log = Logger.getLogger(VirtualMainController.class.getName());
	
	
	/*@ExceptionHandler(VirtualMainException.class)
	public ModelAndView errorHandling(HttpServletRequest req, Exception ex, HttpServletResponse response)
			throws IOException {
		ModelAndView modelandview = new ModelAndView();
		//log.error("Request" + req.getRequestURL() + "raised" + ex);
		modelandview.addObject(CommonConstants.EXCEPTION + ex);
		modelandview.addObject(CommonConstants.URL, req.getRequestURL());
		modelandview.setViewName(CommonConstants.ERROR_JSP);
		return modelandview;
	}*/
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject(CommonConstants.ERR_MSG, CommonConstants.ERROR_OCCURRED);
		model.setViewName(CommonConstants.GENERIC_ERROR);
		return model;
	}
	
}
