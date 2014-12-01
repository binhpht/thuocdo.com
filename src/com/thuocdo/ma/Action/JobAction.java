package com.thuocdo.ma.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.thuocdo.ma.Bean.*;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.thuocdo.ma.DAO.JobDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JobAction extends ActionSupport implements ModelDriven<Job>,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Job> lstJob;
	private Job job;
	private JobDAO lnkJob;
	private String LstjobID;
	private List<Category> lstCategory;
	private CategoryDAO lnkCategory;
	private Map<String, Object> session;

	public JobAction() {
		this.lnkJob = new JobDAO();
		job = new Job();
		this.lnkCategory = new CategoryDAO();
		this.lstJob = lnkJob.getJobList();
		this.lstCategory = this.lnkCategory.getCategoryList();
	}

	public String execute() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				this.lstJob = lnkJob.getJobList();
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

				lnkJob.deleteJob(Integer.parseInt(request.getParameter("id")));
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
				if (null != this.job) {
					lnkJob.saveAndUpdateJob(job);
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
				job = lnkJob.getJob(Integer
						.parseInt(request.getParameter("id")));
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
				String[] roleIDList = getLstjobID().split(",");
				for (int i = 0; i < roleIDList.length; i++) {
					lnkJob.deleteJob((Integer.parseInt(roleIDList[i].trim())));
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

	public List<Job> getLstJob() {
		return lstJob;
	}

	public void setLstJob(List<Job> lstJob) {
		this.lstJob = lstJob;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public Job getModel() {
		// TODO Auto-generated method stub
		return this.job;
	}

	public String getLstjobID() {
		return LstjobID;
	}

	public void setLstjobID(String lstjobID) {
		LstjobID = lstjobID;
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
