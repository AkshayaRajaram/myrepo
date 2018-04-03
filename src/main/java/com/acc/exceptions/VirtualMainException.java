package com.acc.exceptions;

import org.apache.log4j.Logger;

public class VirtualMainException extends Exception {
	// LOGGER to handle custom exceptions
		private static Logger log = Logger.getLogger(VirtualMainException.class);


		public VirtualMainException(String message, Throwable object ) {
			super(message,object);
			log.info("Exception Message is :" + message);
		}
		public VirtualMainException( Throwable object ) {
			super(object);
			log.info("Exception Message is :" + object.getMessage());
		}
		public VirtualMainException() {
		super();
			log.info("Exception Message is :" );
		}

}
