package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.FAQ;
import com.thuocdo.ma.Utils.HibernateUtil;

public class FAQDAO extends HibernateUtil implements IFAQDAO {

	@Override
	public FAQ deleteFAQ(int faqid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		FAQ faq = (FAQ) session.load(FAQ.class, faqid);
		if (null != faq) {
			session.delete(faq);
		}
		session.getTransaction().commit();
		return faq;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FAQ> getFAQList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<FAQ> lstFAQ = null;
		try {
			lstFAQ = (List<FAQ>) session.createQuery("from FAQ").list();
		} catch (HibernateException e) {
		
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstFAQ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FAQ> getFAQList(boolean active) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<FAQ> lstFAQ = null;
		try {
			lstFAQ = (List<FAQ>) session.createQuery(
					"from FAQ where isActive=:active").setParameter("active",
					active).list();
			System.out.println(lstFAQ);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstFAQ;
	}

	@Override
	public List<FAQ> getFAQList(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FAQ saveAndUpdateFAQ(FAQ faq) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(faq);
		session.getTransaction().commit();
		return faq;
	}

	@Override
	public FAQ getFAQ(int faqid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		FAQ faq = (FAQ) session.load(FAQ.class, faqid);
		return faq;
	}

	
}
