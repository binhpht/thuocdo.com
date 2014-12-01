package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Role;
import com.thuocdo.ma.Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class RoleDAO extends HibernateUtil implements IRoleDAO{

	@Override
	public Role addRole(Role role) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(role);
		session.getTransaction().commit();
		return role;
	}

	@Override
	public boolean deleteRole(int roleID) {
		boolean result = false;
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Role role = (Role) session.load(Role.class, roleID);
			if (null != role) {
				session.delete(role);
			}
			session.getTransaction().commit();
			result = true;
		}catch(Exception e){}
		return result;
	}

	@Override
	public Role getRole(int roleID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Role role = (Role) session.load(Role.class, roleID);
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleList() {	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();		
		List<Role> roles = null;
		try {
			
			roles = (List<Role>) session.createQuery("from Role")
			.list();		
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return roles;
	}

	@Override
	public Role updateRole(Role role) {		
		return null;
	}

}
