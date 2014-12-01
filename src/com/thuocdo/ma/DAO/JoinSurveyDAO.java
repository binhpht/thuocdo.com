package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.JoinSurvey;
import com.thuocdo.ma.Bean.Question;
import com.thuocdo.ma.Bean.Result;
import com.thuocdo.ma.Bean.Survey;
import com.thuocdo.ma.Utils.HibernateUtil;

public class JoinSurveyDAO extends HibernateUtil implements IJoinSurveyDAO {

	@Override
	public JoinSurvey addJoinSurvey(JoinSurvey joinsurvey) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(joinsurvey);
		for(int i=0;i<joinsurvey.getResults().size();i++){
			Result result= joinsurvey.getResults().get(i);
			result.setJoinSurvey(joinsurvey);
			session.saveOrUpdate(result);
		}
		session.getTransaction().commit();	
		return joinsurvey;
	}

	@Override
	public boolean deleteJoinSurvey(int joinID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JoinSurvey getJoinSurvey(int joinID) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		JoinSurvey joinSurvey = (JoinSurvey) session.load(JoinSurvey.class, joinID);
		return joinSurvey;
	}

	@Override
	public List<JoinSurvey> getJoinSurveyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JoinSurvey> getJoinSurveyList(int surveyID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<JoinSurvey> lstJoinSurvey = null;
		try {
			lstJoinSurvey = (List<JoinSurvey>) session.createQuery("from JoinSurvey where SurveyID='52'")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstJoinSurvey;
	}

	@Override
	public List<JoinSurvey> getJoinSurveyList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JoinSurvey updateJoinSurvey(JoinSurvey joinSurvey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isSurveyed(Account account, Survey survey){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<JoinSurvey> lstJoinSurvey = null;
		try {
			lstJoinSurvey = (List<JoinSurvey>) session.createQuery("from JoinSurvey as s where s.account.accountID=:accountID and s.survey.surveyID=:surveyID")
			.setParameter("accountID", account.getAccountID()).setParameter("surveyID", survey.getSurveyID())
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		session.getTransaction().commit();
		if(lstJoinSurvey.size()!=0){
			return true;
		}else{
			return false;
		}
		//return true;
	}

}
