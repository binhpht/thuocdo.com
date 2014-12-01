package com.thuocdo.ma.Bean;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
public class Report implements Serializable  {
	private static final long serialVersionUID = 1L;
	String questionContent;
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	String fullName;
	String address;
	String birthday;
	String jobname;
	Integer questionID;
	Integer answerID;
	Integer surveyID;
	Integer count;
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	public Integer getAnswerID() {
		return answerID;
	}
	public void setAnswerID(Integer answerID) {
		this.answerID = answerID;
	}
	public Integer getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(Integer surveyID) {
		this.surveyID = surveyID;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getContentFreeText() {
		return contentFreeText;
	}
	public void setContentFreeText(String contentFreeText) {
		this.contentFreeText = contentFreeText;
	}
	String  contentFreeText;
	

}
