package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Category;

public interface ICategoryDAO {
	/*
	 * Them mot danh muc khao sat
	 */
	public Category	saveAndUpdateCategory(Category category);	
	public Category deleteCategory(int categoryID);
	public List<Category> getCategoryList();
	public Category getCategory(int categoryID);
}
