package com.thuocdo.ma.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thuocdo.ma.Bean.*;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.thuocdo.ma.DAO.FAQDAO;

public class FAQAction extends ActionSupport implements ModelDriven<FAQ>,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FAQ> lstFAQ;
	private List<FAQ> lstFAQForCustomer;
	private List<Category> lstCategory;
	private FAQ faq;
	private String faqidList;

	private FAQDAO linkFAQ;
	private CategoryDAO lnkCategory;

	private Map<String, Object> session;

	public FAQAction() {
		this.faq = new FAQ();
		this.linkFAQ = new FAQDAO();
		this.lstFAQ = this.linkFAQ.getFAQList();
		this.lnkCategory = new CategoryDAO();
		this.lstCategory = this.lnkCategory.getCategoryList();

	}

	public String execute() {
		try {
			
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				this.lstFAQ = linkFAQ.getFAQList();
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

	public String viewForCustomer() {
		try {
			this.lstFAQForCustomer = this.linkFAQ.getFAQList(true);
			System.out.println(this.lstFAQForCustomer);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveAndUpdate() {
		try {
			Account account = (Account) getSession().get("account");
			if (account.getRole().getRoleName().equals("Admin")) {
				if (null != getFaq()) {
					System.out.println(getFaq().getQuestionContent());
					System.out.println(getFaq().getIsActive());
					linkFAQ.saveAndUpdateFAQ(this.faq);
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
				faq = linkFAQ.getFAQ(Integer.parseInt(request
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

				linkFAQ.deleteFAQ(Integer.parseInt(request.getParameter("id")));
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
				String[] roleIDList = getFaqidList().split(",");
				for (int i = 0; i < roleIDList.length; i++) {
					linkFAQ.deleteFAQ((Integer.parseInt(roleIDList[i].trim())));
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

	public String viewFAQForCustomer() {
		this.lstFAQForCustomer = linkFAQ.getFAQList(true);
		return SUCCESS;
	}

	public List<FAQ> getLstFAQ() {
		return lstFAQ;
	}

	public void setLstFAQ(List<FAQ> lstFAQ) {
		this.lstFAQ = lstFAQ;
	}

	public String getFaqidList() {
		return faqidList;
	}

	public void setFaqidList(String faqidList) {
		this.faqidList = faqidList;
	}

	@Override
	public FAQ getModel() {
		// TODO Auto-generated method stub
		return this.faq;
	}

	public FAQ getFaq() {
		return faq;
	}

	public void setFaq(FAQ faq) {
		this.faq = faq;
	}

	public List<FAQ> getLstFAQForCustomer() {
		return lstFAQForCustomer;
	}

	public void setLstFAQForCustomer(List<FAQ> lstFAQForCustomer) {
		this.lstFAQForCustomer = lstFAQForCustomer;
	}

	public List<Category> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(List<Category> lstCategory) {
		this.lstCategory = lstCategory;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session= arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
