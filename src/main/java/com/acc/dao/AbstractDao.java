package com.acc.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acc.exceptions.VirtualMainException;

public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(AbstractDao.class);

	public Session getSession() throws VirtualMainException {

		if (sessionFactory != null) {
			return sessionFactory.getCurrentSession();

		} else {

			log.info("Connection to database is not correctly set..... ");
			throw new VirtualMainException(
					"Error in Transaction, Please re-Try. for more information check Logfile in C:\\VirtualExceptionLog\\virtualLog.txt",
					new NullPointerException());
		}

	}

}
