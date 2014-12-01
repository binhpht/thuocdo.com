package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Answer;
import com.thuocdo.ma.Utils.HibernateUtil;

public class AnswerDAO extends HibernateUtil implements IAnswerDAO{

	@Override
	public Answer addAnswer(Answer answer) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		session.save(answer);
		session.getTransaction().commit();
		return answer;
	}

	@Override
	public boolean deleteAnswer(int answerID) {
		boolean result = false;
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Answer answer = (Answer) session.load(Answer.class, answerID);
			if (null != answer) {
				session.delete(answer);
			}
			session.getTransaction().commit();
			result = true;
		}catch(Exception e){}
		return result;
	}

	@Override
	public List<Answer> getAnswerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> getAnswerList(int questionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Answer updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return null;
	}

}
