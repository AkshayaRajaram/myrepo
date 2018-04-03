package com.acc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.acc.dto.Account;
import com.acc.dto.DocRevStatus;
import com.acc.dto.Document;
import com.acc.exceptions.VirtualMainException;

@Repository
public class AccountInfoDaoImpl extends AbstractDao implements AccountInfoDao {
	/***
	 * @throws VirtualMainException
	 *             Returns list of account from database
	 */
	public List<Account> listAllAccount() throws VirtualMainException {
		Session session = getSession();
		Query query = session.createQuery("from Account");

		List<Account> accountList = query.list();

		return query.list();
	}

	/***
	 * @throws VirtualMainException
	 *             Returns a list with document status information
	 */
	public List<DocRevStatus> listAccDocStatus() throws VirtualMainException {

		Session session = getSession();

		Query query = session.createQuery("from DocRevStatus");
		return query.list();
	}

}
