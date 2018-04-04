package com.acc.exceptions;

import org.apache.log4j.Logger;

import com.acc.constants.CommonConstants;

public class VirtualMainException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4612760935543485294L;
	// LOGGER to handle custom exceptions
	private static Logger log = Logger.getLogger(VirtualMainException.class);
	
	public VirtualMainException(String message, Throwable object) {
		super(message, object);
		log.info(CommonConstants.EXCEPTION_MESSAGE + message);
	}
	
	public VirtualMainException(Throwable object) {
		super(object);
		log.info(CommonConstants.EXCEPTION_MESSAGE + object.getMessage());
	}
	
	public VirtualMainException() {
		super();
		log.info(CommonConstants.EXCEPTION_MESSAGE);
	}
	
}
