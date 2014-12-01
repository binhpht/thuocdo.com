package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Job database table.
 * 
 */
@Entity
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JobID")
	private int jobID;

	@Column(name="Description")
	private String description;

	@Column(name="JobName")
	private String jobName;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="job")
	private List<Account> accounts;

	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="job")
	private List<Survey> surveys;

    public Job() {
    }

	public int getJobID() {
		return this.jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}
	
}