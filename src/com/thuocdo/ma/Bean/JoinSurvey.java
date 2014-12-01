package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the JoinSurvey database table.
 * 
 */
@Entity
public class JoinSurvey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JoinID")
	private int joinID;

	@Column(name="JoinDate")
	private Timestamp joinDate;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="AccountID")
	private Account account;

	//bi-directional many-to-one association to Survey
    @ManyToOne
	@JoinColumn(name="SurveyID")
	private Survey survey;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="joinSurvey")
	private List<Result> results;

    public JoinSurvey() {
    }

	public int getJoinID() {
		return this.joinID;
	}

	public void setJoinID(int joinID) {
		this.joinID = joinID;
	}

	public Timestamp getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
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
	
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}