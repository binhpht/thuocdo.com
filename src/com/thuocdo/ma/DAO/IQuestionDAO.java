package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Question;

public interface IQuestionDAO {
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public boolean deleteQuestion (int questionID);
	public Question getQuestion(int questionID);
	public List<Question> getQuestionList(int surveyID);
	public List<Question> getQuestion();
}
