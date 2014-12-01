package com.thuocdo.ma.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.DAO.CategoryDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends ActionSupport implements
		ModelDriven<Category>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> lstCategory;
	private List<Category> categoryList;
	private CategoryDAO linkController;
	private String categoryIDList;
	private Category category = new Category();

	private Map<String, Object> session;

	public CategoryAction() {
		linkController = new CategoryDAO();
		this.categoryList = this.linkController.getCategoryList();
		this.lstCategory = this.categoryList;
	}

	public String execute() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				this.categoryList = linkController.getCategoryList();

			} else {
				addActionError("Ban khong co quyen thuc hien");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ban chua dang nhap vao he thong");
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				HttpServletRequest request = (HttpServletRequest) ActionContext
						.getContext().get(ServletActionContext.HTTP_REQUEST);
				linkController.deleteCategory(Integer.parseInt(request
						.getParameter("id")));
			} else {
				addActionError("Ban khong co quyen thuc hien");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ban chua dang nhap vao he thong");
			return ERROR;
		}
		return SUCCESS;
	}

	public String edit() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				HttpServletRequest request = (HttpServletRequest) ActionContext
						.getContext().get(ServletActionContext.HTTP_REQUEST);

				category = linkController.getCategory(Integer.parseInt(request
						.getParameter("id")));
				this.categoryList = linkController.getCategoryList();
			} else {
				addActionError("Ban khong co quyen thuc hien");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ban chua dang nhap vao he thong");
			return ERROR;
		}
		return SUCCESS;
	}

	public String save() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				if (null != category) {
					linkController.saveAndUpdateCategory(category);
				}
			} else {
				addActionError("Ban khong co quyen thuc hien");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ban chua dang nhap vao he thong");
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteMany() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				String[] roleIDList = getCategoryIDList().split(",");
				for (int i = 0; i < roleIDList.length; i++) {
					linkController.deleteCategory(Integer
							.parseInt(roleIDList[i].trim()));
				}
				this.categoryList = linkController.getCategoryList();
			} else {
				addActionError("Ban khong co quyen thuc hien");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ban chua dang nhap vao he thong");
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return this.category;
	}

	public List<Category> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(List<Category> lstCategory) {
		this.lstCategory = lstCategory;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getCategoryIDList() {
		return categoryIDList;
	}

	public void setCategoryIDList(String categoryIDList) {
		this.categoryIDList = categoryIDList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
