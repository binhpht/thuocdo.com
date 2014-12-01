package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.JoinSurvey;

public interface IJoinSurveyDAO {
	public JoinSurvey addJoinSurvey(JoinSurvey joinsurvey);
	public JoinSurvey updateJoinSurvey (JoinSurvey joinSurvey);
	public boolean deleteJoinSurvey(int joinID);
	public JoinSurvey getJoinSurvey(int joinID);
	public List<JoinSurvey> getJoinSurveyList();
	public List<JoinSurvey> getJoinSurveyList(int surveyID);
	public List<JoinSurvey> getJoinSurveyList(String username);
}
