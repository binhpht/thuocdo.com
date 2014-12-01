package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Job;
import com.thuocdo.ma.Utils.HibernateUtil;

public class JobDAO extends HibernateUtil implements IJobDAO {

	@Override
	public Job saveAndUpdateJob(Job job) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(job);
		session.getTransaction().commit();
		return job;
	}

	@Override
	public Job deleteJob(int jobID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Job job = (Job) session.load(Job.class, jobID);
		if (null != job) {
			session.delete(job);
		}
		session.getTransaction().commit();
		return job;
	}

	@Override
	public Job getJob(int jobID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Job job = (Job) session.load(Job.class, jobID);
		return job;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getJobList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Job> lstJob = null;
		try {
			lstJob = (List<Job>) session.createQuery("from Job").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstJob;
	}

	@Override
	public List<Job> getJobList(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}



}
