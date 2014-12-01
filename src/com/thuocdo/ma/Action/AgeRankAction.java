/**
 * 
 */
package com.thuocdo.ma.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.AgeRank;
import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.DAO.AgeRankDAO;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AgeRankAction extends ActionSupport implements
		ModelDriven<AgeRank>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AgeRank> lstAgeRank;
	private List<Category> lstCategory;
	private CategoryDAO lnkCategory;
	private String ageRankidList;
	private AgeRankDAO linkAgeRank;

	private Map<String, Object> session;

	private AgeRank ageRank;

	public AgeRank getAgeRank() {
		return ageRank;
	}

	public void setAgeRank(AgeRank ageRank) {
		this.ageRank = ageRank;
	}

	public AgeRankAction() {
		this.ageRank = new AgeRank();
		this.linkAgeRank = new AgeRankDAO();
		this.lnkCategory = new CategoryDAO();
		this.lstAgeRank = this.linkAgeRank.getAgeRankList();
		this.lstCategory = this.lnkCategory.getCategoryList();
	}

	public String execute() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				this.lstAgeRank = linkAgeRank.getAgeRankList();
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

	public String saveAndUpdate() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				if (null != getAgeRank()) {
					linkAgeRank.saveAndUpdateAgeRank(this.ageRank);
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

	public String edit() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				HttpServletRequest request = (HttpServletRequest) ActionContext
						.getContext().get(ServletActionContext.HTTP_REQUEST);
				ageRank = linkAgeRank.getAgeRank(Integer.parseInt(request
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

	public String delete() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				HttpServletRequest request = (HttpServletRequest) ActionContext
						.getContext().get(ServletActionContext.HTTP_REQUEST);

				linkAgeRank.deleteAgeRank(Integer.parseInt(request
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

	public String deleteMany() {

		String[] roleIDList = getAgeRankidList().split(",");
		for (int i = 0; i < roleIDList.length; i++) {
			linkAgeRank.deleteAgeRank((Integer.parseInt(roleIDList[i].trim())));
		}
		return SUCCESS;
	}

	@Override
	public AgeRank getModel() {
		// TODO Auto-generated method stub
		return this.ageRank;
	}

	public List<AgeRank> getLstAgeRank() {
		return lstAgeRank;
	}

	public void setLstAgeRank(List<AgeRank> lstAgeRank) {
		this.lstAgeRank = lstAgeRank;
	}

	public String getAgeRankidList() {
		return ageRankidList;
	}

	public void setAgeRankidList(String ageRankidList) {
		this.ageRankidList = ageRankidList;
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
