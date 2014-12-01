package com.thuocdo.ma.DAO;

import java.sql.Date;
import java.util.List;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Survey;

public interface ISurveyDAO {
	public Survey saveAndUpdateSurvey(Survey survey);	
	public Survey deleteSurvey(int surveyID);
	public Survey getSurvey(int surveyID);
	public List<Survey> getSurveyList();
	public List<Survey> getSurveyList(int categoryID);
	public List<Survey> getNewSurveyList();
	public List<Survey> getMostOfSurveyList();
	public List<Survey> getSurveyListByUsername(String username);
	public List<Survey> getSurveyList(String title, String username, Date begindate, Date endDate, boolean isActice);
	public List<Survey> getSurveyList(String categoryname, String jobName, String agerank);
	public List<Survey> getIllegalSurveyList(boolean isIllegal);
	public List<Survey> getSurveyOfCustomer(Account account);
}
