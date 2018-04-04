package com.acc.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.acc.exceptions.VirtualMainException;

public abstract class AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(AbstractDao.class);
	
	/**
	 * Returns Session Factory Object
	 * If session is Not Null
	 * Else throws Exception
	 * 
	 * @return session factory object
	 * @throws VirtualMainException
	 */
	public Session getSession() throws VirtualMainException {
		if (sessionFactory != null) {
			return sessionFactory.getCurrentSession();
		} else {
			log.error("Connection to database is not correctly set..... ");
			throw new VirtualMainException(
					"Error in Transaction, Please re-Try. for more information check Logfile in C:\\VirtualExceptionLog\\virtualLog.txt",
					new NullPointerException());
		}
	}
}
