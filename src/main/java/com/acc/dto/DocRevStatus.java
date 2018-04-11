package com.acc.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "DOC_REV_STATUS")
public class DocRevStatus extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docRevStatusId;
	
	@OneToOne
	@JoinColumn(name = "accountId")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "docId")
	private Document document;
	
	@OneToOne
	@JoinColumn(name = "statusId")
	private ValidationStatus validationstatus;

	public Integer getDocRevStatusId() {
		return docRevStatusId;
	}

	public void setDocRevStatusId(Integer docRevStatusId) {
		this.docRevStatusId = docRevStatusId;
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

	public ValidationStatus getValidationstatus() {
		return validationstatus;
	}

	public void setValidationstatus(ValidationStatus validationstatus) {
		this.validationstatus = validationstatus;
	}

}
