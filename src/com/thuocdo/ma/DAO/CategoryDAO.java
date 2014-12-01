package com.thuocdo.ma.DAO;
import java.util.List;

import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.Utils.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class CategoryDAO extends HibernateUtil implements ICategoryDAO {

	@Override
	public Category saveAndUpdateCategory(Category category) {		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		return category;
	}
	
	@Override
	public Category deleteCategory(int categoryID) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Category contact = (Category) session.load(Category.class, categoryID);
		if (null != contact) {
			session.delete(contact);
		}
		session.getTransaction().commit();
		return contact;
	}

	@Override
	public Category getCategory(int categoryID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Category category = (Category) session.load(Category.class, categoryID);
		return category;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub		
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();		
		List<Category> category=null;
		try {
			category=(List<Category>)session.createSQLQuery("select * from  category")
			.addEntity(Category.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return category;
	}
	
 
	 public static Integer getCustomersCount(List<Category> list)
	  {
	    return Integer.valueOf(list.size());
	  }	

}

