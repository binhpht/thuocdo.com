package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Illegal database table.
 * 
 */
@Entity
public class Illegal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IllegalID")
	private int illegalID;

	@Column(name="IsSolved")
	private boolean isSolved;

	private String reason;

	@Column(name="ReportDate")
	private Timestamp reportDate;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="AccountID")
	private Account account;

	//bi-directional many-to-one association to Survey
    @ManyToOne
	@JoinColumn(name="SurveyID")
	private Survey survey;

    public Illegal() {
    }

	public int getIllegalID() {
		return this.illegalID;
	}

	public void setIllegalID(int illegalID) {
		this.illegalID = illegalID;
	}

	public boolean getIsSolved() {
		return this.isSolved;
	}

	public void setIsSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
}