package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Survey database table.
 * 
 */
@Entity
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SurveyID")
	private int surveyID;

	@Column(name="BeginTime")
	private Timestamp beginTime;

	@Column(name="Description")
	private String description;

	@Column(name="EndTime")
	private Timestamp endTime;

	@Column(name="IsActive")
	private boolean isActive;

	@Column(name="IsIllegal")
	private boolean isIllegal;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-one association to Illegal
	@OneToMany(mappedBy="survey")
	private List<Illegal> illegals;

	//bi-directional many-to-one association to JoinSurvey
	@OneToMany(mappedBy="survey")
	private List<JoinSurvey> joinSurveys;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="survey")
	private List<Question> questions;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="AccountID")
	private Account account;

	//bi-directional many-to-one association to AgeRank
    @ManyToOne
	@JoinColumn(name="AgeRankID")
	private AgeRank ageRank;

	//bi-directional many-to-one association to Category
    @ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;

	//bi-directional many-to-one association to Job
    @ManyToOne
	@JoinColumn(name="JobID")
	private Job job;

    public Survey() {
    }

	public int getSurveyID() {
		return this.surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsIllegal() {
		return this.isIllegal;
	}

	public void setIsIllegal(boolean isIllegal) {
		this.isIllegal = isIllegal;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Illegal> getIllegals() {
		return this.illegals;
	}

	public void setIllegals(List<Illegal> illegals) {
		this.illegals = illegals;
	}
	
	public List<JoinSurvey> getJoinSurveys() {
		return this.joinSurveys;
	}

	public void setJoinSurveys(List<JoinSurvey> joinSurveys) {
		this.joinSurveys = joinSurveys;
	}
	
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public AgeRank getAgeRank() {
		return this.ageRank;
	}

	public void setAgeRank(AgeRank ageRank) {
		this.ageRank = ageRank;
	}
	
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
}