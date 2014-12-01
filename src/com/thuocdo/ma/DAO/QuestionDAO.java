package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Question;
import com.thuocdo.ma.Utils.HibernateUtil;

public class QuestionDAO extends HibernateUtil implements IQuestionDAO{

	@Override
	public Question addQuestion(Question question) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		session.save(question);
		session.getTransaction().commit();
		
		AnswerDAO answerDao=new AnswerDAO();
		for(int i=0;i<question.getAnswers().size();i++){
			question.getAnswers().get(i).setAnswerID(0);
			question.getAnswers().get(i).setQuestion(question);
			answerDao.addAnswer(question.getAnswers().get(i));
		}
		return question;
	}

	@Override
	public boolean deleteQuestion(int questionID) {
		boolean result = false;
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Question question = (Question) session.load(Question.class, questionID);
			if (null != question) {
				session.delete(question);
			}
			session.getTransaction().commit();
			result = true;
		}catch(Exception e){}
		return result;
	}

	@Override
	public Question getQuestion(int questionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionList(int surveyID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Question> lstQuestion = null;
		try {
			lstQuestion = (List<Question>) session.createQuery("from Question where SurveyID='52'")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstQuestion;
	}

	@Override
	public Question updateQuestion(Question question) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		for(int i=0;i<question.getAnswers().size();i++){		
			question.getAnswers().get(i).setQuestion(question);	
			session.saveOrUpdate(question.getAnswers().get(i));
		}
		session.update(question);
		session.getTransaction().commit();	
		return question;
	}

}
