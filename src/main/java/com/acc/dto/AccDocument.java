package com.acc.dto;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "ACC_DOCUMENT")
public class AccDocument extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accDocId;
	
	@OneToOne
	@JoinColumn(name = "accountId")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "docId")
	private Document document;

	public Integer getAccDocId() {
		return accDocId;
	}

	public void setAccDocId(Integer accDocId) {
		this.accDocId = accDocId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	
}
