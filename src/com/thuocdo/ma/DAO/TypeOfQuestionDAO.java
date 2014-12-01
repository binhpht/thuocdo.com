package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.TypeOfQuestion;
import com.thuocdo.ma.Utils.HibernateUtil;

public class TypeOfQuestionDAO extends HibernateUtil implements ITypeOfQuestionDAO {

	@Override
	public TypeOfQuestion addTypeOfQuestion(TypeOfQuestion typeofquestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTypeOfQuestion(int typeOfQuestionID) {
		return false;
	}

	@Override
	public TypeOfQuestion getTypeOfQuestion(int typeOfQuestionID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TypeOfQuestion typeOfQuestion = (TypeOfQuestion) session.load(TypeOfQuestion.class, typeOfQuestionID);
		return typeOfQuestion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfQuestion> getTypeOfQuestion() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();		
		List<TypeOfQuestion> typeOfQuestions = null;
		try {
			
			typeOfQuestions = (List<TypeOfQuestion>) session.createQuery("from TypeOfQuestion")
			.list();		
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return typeOfQuestions;
	}

	@Override
	public TypeOfQuestion updateTypeOfQuestion(TypeOfQuestion typeOfQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

}
