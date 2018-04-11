package com.acc.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AccountUWMapping")
public class AccountUWMapping extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accUWMappingId;

	@OneToOne
	@JoinColumn(name = "accountId")
	private Account account;

	@OneToOne
	@JoinColumn(name = "underWriterId")
	private UnderWriter underWriter;

	public Integer getAccUWMappingId() {
		return accUWMappingId;
	}

	public void setAccUWMappingId(Integer accUWMappingId) {
		this.accUWMappingId = accUWMappingId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public UnderWriter getUnderWriter() {
		return underWriter;
	}

	public void setUnderWriter(UnderWriter underWriter) {
		this.underWriter = underWriter;
	}

}
