package com.thuocdo.ma.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Question;
import com.thuocdo.ma.Bean.Result;
import com.thuocdo.ma.Bean.Report;
import com.thuocdo.ma.Utils.HibernateUtil;

public class ResultDAO extends HibernateUtil implements IResultDAO {

	@Override
	public Result addResult(Result result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteResult(int resultID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Result getResult(int resultID) {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public List<Result> getResultList(int joinID) {
		return null;
		// TODO Auto-generated method stub
		
	}
	public List<Report> getReportList(int surveyID) {
		
		List<Report> ii;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			System.out.print("Danh Sach cau hoi");
			String s = " select Q.questionContent, R.contentFreeText,J.account.fullName,J.account.address, year(J.account.birthday),J.account.job.jobName" 
					 + " from Survey S right join S.questions Q right join Q.answers A"
					 + " left join A.results R left join R.joinSurvey J" 
					 + " where S.surveyID =:surveyID and R.contentFreeText != null"					;
			
			ii = session.createQuery(s).setParameter("surveyID", surveyID).list();

			
		} catch(Exception e){
			System.out.println(e.toString());
			session.getTransaction().rollback();
			return null;
		}
		System.out.println("Hien thi ket qua tu CSHDL\n");
		System.out.println(ii+"\n");

		return ii ;
	}

	@Override
	public Result updateResult(Result result) {
		// TODO Auto-generated method stub
		return null;
	}
	public Iterator getIterator(int surveyID) {
		Iterator i ;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			System.out.print("Danh Sach cau hoi");
			String s = "select S.surveyID as surveyID, Q.questionID as questionID, A.answerID as answerID, COUNT(J.account.accountID) as coutAnswer" 
					 + " from Survey S right join S.questions Q right join Q.answers A"
					 + " left join A.results R left join R.joinSurvey J" 
					 + " where S.surveyID =:surveyID"
					 + " group by S.surveyID, Q.questionID, A.answerID";
			i = session.createQuery(s).setParameter("surveyID", surveyID).list().iterator();

			
		} catch(Exception e){
			System.out.println(e.toString());
			session.getTransaction().rollback();
			return null;
		}
		System.out.println("Hien thi ket qua tu CSHDL\n");

		return i ;
		
	}

}
