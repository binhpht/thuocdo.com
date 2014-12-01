package com.thuocdo.ma.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Utils.HibernateUtil;

public class AccountDAO extends HibernateUtil implements IAccountDAO {

	@Override
	public Account getAccountByAccountID(int accountID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = (Account) session.load(Account.class, accountID);
		return account;
	}

	@Override
	public Account getAccountByUserName(String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = null;
		try {
			account = (Account) ((SQLQuery) session.createSQLQuery(
					"select * from Account where username=:username")
					.setParameter("username", username)).addEntity(
					Account.class).uniqueResult();
			System.out.println(account);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getListAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Account> lstAccount = null;
		try {
			lstAccount = (List<Account>) session.createQuery("from Account where isAccountTemp='false'")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lstAccount;
	}

	@Override
	public List<Account> getListAccount(String roleName, String jobName,
			String active) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = null;
		try {
			account = (Account) ((SQLQuery) (session
					.createSQLQuery("select * from Account where username=:username and password=:password")
					.setParameter("username", username)).setParameter(
					"password", password)).addEntity(Account.class)
					.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return account;
	}

	@Override
	public Account changePassword(Account acc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = null;
		try {
			account = getAccountByAccountID(acc.getAccountID());

			account.setPassword(acc.getPassword());
			/*
			 * account =session.createQuery(
			 * "update Account set password=:npassword where username=:username"
			 * ) .setParameter("username", username).setParameter( "npassword",
			 * npassword).executeUpdate();
			 */
			session.saveOrUpdate(account);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return account;
	}

	@Override
	public Account deleteAccount(int accountID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = (Account) session.load(Account.class, accountID);
		if (null != account) {
			session.delete(account);
		}
		session.getTransaction().commit();
		return account;
	}

	@Override
	public Account saveAndUpdateAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(account);
		session.getTransaction().commit();
		return account;
	}

	@SuppressWarnings("unchecked")
	public int checkExits(String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Account> lstAccount = null;
		lstAccount = (List<Account>) session.createQuery(
				"from Account as a where a.userName=:username").setParameter(
				"username", username).list();
		session.getTransaction().commit();

		return lstAccount.size();

	}

	@SuppressWarnings("unchecked")
	public int checkExitsEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Account> lstAccount = null;
		lstAccount = (List<Account>) session.createQuery(
				"from Account as a where a.email=:email").setParameter("email",
				email).list();
		session.getTransaction().commit();

		return lstAccount.size();

	}

}
