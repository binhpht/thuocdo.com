package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.AgeRank;
import com.thuocdo.ma.Utils.HibernateUtil;

public class AgeRankDAO extends HibernateUtil implements IAgeRankDAO {

	@Override
	public AgeRank addAgeRank(int ar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgeRank deleteAgeRank(int ar) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AgeRank ageRank = (AgeRank) session.load(AgeRank.class, ar);
		if (null != ageRank) {
			session.delete(ageRank);
		}
		session.getTransaction().commit();
		return ageRank;
		
	}

	@Override
	public AgeRank getAgeRank(int AgeRankID) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AgeRank ageRank = (AgeRank) session.load(AgeRank.class, AgeRankID);
		return ageRank;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgeRank> getAgeRankList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<AgeRank> lstAgeRank = null;
		try {
			lstAgeRank = (List<AgeRank>) session.createQuery("from AgeRank").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstAgeRank;
	
	}

	@Override
	public AgeRank updateAgeRank(AgeRank ar) {
		// TODO Auto-generated method stub
		return null;
	}
	public AgeRank saveAndUpdateAgeRank(AgeRank ageRank) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(ageRank);
		session.getTransaction().commit();
		return ageRank;
		
	}

}
