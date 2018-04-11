package com.acc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.acc.constants.CommonConstants;


@ControllerAdvice
public abstract class AbstractController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject(CommonConstants.ERR_MSG, CommonConstants.ERROR_OCCURRED);
		model.setViewName(CommonConstants.GENERIC_ERROR);
		return model;
	}
	
}
