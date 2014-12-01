package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Illegal;
import com.thuocdo.ma.Utils.HibernateUtil;

public class IllegalDAO extends HibernateUtil {
	

	public Illegal saveAndUpdateIllegal(Illegal illegal) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(illegal);
		session.getTransaction().commit();
		return illegal;
	}


	public Illegal deleteIllegal(int illegalID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Illegal illegal = (Illegal) session.load(Illegal.class, illegalID);
		if (null != illegal) {
			session.delete(illegal);
		}
		session.getTransaction().commit();
		return illegal;
	}


	public Illegal getIllegal(int illegalID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Illegal illegal = (Illegal) session.load(Illegal.class, illegalID);
		return illegal;
	}

	@SuppressWarnings("unchecked")
	public List<Illegal> getIllegalList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Illegal> lstIllegal = null;
		try {
			lstIllegal = (List<Illegal>) session.createQuery("from Illegal").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstIllegal;
	}
	
	@SuppressWarnings("unchecked")
	public List<Illegal> getIllegalWithSurveyID(int surveyID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Illegal> lstIllegal = null;
		try {
			lstIllegal = (List<Illegal>) session.createQuery("from Illegal as i where i.survey.surveyID=:surveyID")
			.setParameter("surveyID", surveyID)
			.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstIllegal;
	}
}
