package com.thuocdo.ma.DAO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import com.thuocdo.ma.DAO.QuestionDAO;
import org.hibernate.HibernateException;

import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Survey;
import com.thuocdo.ma.Utils.HibernateUtil;

public class SurveyDAO extends HibernateUtil implements ISurveyDAO {

	@Override
	public List<Survey> getIllegalSurveyList(boolean isIllegal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Survey getSurvey(int surveyID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Survey survey = (Survey) session.load(Survey.class, surveyID);
		return survey;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getSurveyList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {

			lstSurvey = (List<Survey>) session.createQuery("from Survey")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

	@Override
	public List<Survey> getSurveyList(String title, String username,
			Date begindate, Date endDate, boolean isActice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> getSurveyList(String categoryname, String jobName,
			String agerank) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getSurveyListByUsername(String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {
			lstSurvey = (List<Survey>) session.createQuery(
					"from Survey as s where s.account.username=:username")
					.setParameter("username", username).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

	@Override
	public Survey deleteSurvey(int surveyID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Survey survey = (Survey) session.load(Survey.class, surveyID);
		if (null != survey) {
			session.delete(survey);
		}
		session.getTransaction().commit();
		return survey;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getMostOfSurveyList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {/*select * from Survey s
			inner join (select surveyID, count(surveyID) as jcount
					from JoinSurvey
					group by surveyID
					) as tam
					on s.surveyID=tam.surveyID
					order by jcount desc*/
			lstSurvey = (List<Survey>) session.createSQLQuery("select * from Survey s inner join (select surveyID, count(surveyID) as jcount from JoinSurvey group by surveyID ) as tam on s.surveyID=tam.surveyID order by jcount desc")			
					.addEntity(Survey.class).setMaxResults(3).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getNewSurveyList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {
			lstSurvey = (List<Survey>) session.createQuery(
					"from Survey order by surveyID desc").setMaxResults(3)
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getSurveyList(int categoryID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {
			lstSurvey = (List<Survey>) session.createQuery(
					"from Survey as s where s.category.categoryID=:categoryID")
					.setParameter("categoryID", categoryID).list();
			System.out.println("Danh sach cac khao sat theo chu de");
			System.out.println(lstSurvey);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

	@Override
	public Survey saveAndUpdateSurvey(Survey survey) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(survey);
		session.getTransaction().commit();
		System.out.println(survey.getSurveyID());
		QuestionDAO questionDao = new QuestionDAO();
		for (int i = 0; i < survey.getQuestions().size(); i++) {
			survey.getQuestions().get(i).setSurvey(survey);
			questionDao.addQuestion(survey.getQuestions().get(i));
		}
		return survey;

	}

	@SuppressWarnings("unchecked")
	public List<Survey> searchSurvey(String keyword, Timestamp beginTime,
			Timestamp endTime, int category, boolean active) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {
			lstSurvey = (List<Survey>) session
					.createQuery(
							"from Survey as s where isActive=:active and ( beginTime between :startBegin and :endBegin and endTime between :startEnd and :endEnd)")
					.setParameter("active", active).setParameter("startBegin",
							beginTime).setParameter("endBegin", endTime)
					.setParameter("startEnd", beginTime).setParameter("endEnd",
							endTime).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

	public Survey updateSurvey(Survey survey) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	//	/session.merge(survey);
		session.saveOrUpdate(survey);
		session.getTransaction().commit();
		return survey;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getSurveyOfCustomer(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Survey> lstSurvey = null;
		try {
			lstSurvey = (List<Survey>) session.createQuery(
					"from Survey as s where s.account.accountID=:accountID")
					.setParameter("accountID", account.getAccountID()).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstSurvey;
	}

}
