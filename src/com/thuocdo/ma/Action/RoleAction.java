package com.thuocdo.ma.Action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.Bean.Role;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.thuocdo.ma.DAO.RoleDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role role;
	private List<Role> roleList;
	private int roleID;
	private String roleIDList;
	private RoleDAO roleDao;
	private List<Category> lstCategory;
	private CategoryDAO lnkCategory;
	private Map<String, Object> session;

	public RoleAction() {
		roleDao = new RoleDAO();
		lnkCategory = new CategoryDAO();
		this.lstCategory = lnkCategory.getCategoryList();
	}

	public String execute() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				this.roleList = roleDao.getRoleList();
			} else {
				addActionError("Ban khong co quyen.");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("Ban chua dang nhap vao he thong");
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveRole() {

		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				if (null != role) {
					roleDao.addRole(getRole());
					role = null;
					this.roleList = roleDao.getRoleList();
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

	public String editRole() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				role = roleDao.updateRole(getRole());
				this.roleList = roleDao.getRoleList();
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

	public String deleteRole() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				roleDao.deleteRole(getRoleID());
				this.roleList = roleDao.getRoleList();
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

	public String deleteRoles() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				System.out.println(getRoleIDList());
				String[] roleIDList = getRoleIDList().split(",");
				for (int i = 0; i < roleIDList.length; i++) {
					roleDao.deleteRole(Integer.parseInt(roleIDList[i].trim()));
				}
				this.roleList = roleDao.getRoleList();
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

	public String getOneRole() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				System.out.println("edit ID:" + getRoleID());
				role = roleDao.getRole(getRoleID());
				this.roleList = roleDao.getRoleList();
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public RoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public String getRoleIDList() {
		return roleIDList;
	}

	public void setRoleIDList(String roleIDList) {
		this.roleIDList = roleIDList;
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

}