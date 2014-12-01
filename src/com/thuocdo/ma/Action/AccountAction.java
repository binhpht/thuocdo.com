/**
 * 
 */
package com.thuocdo.ma.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thuocdo.ma.Bean.*;
import com.thuocdo.ma.DAO.AccountDAO;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.thuocdo.ma.DAO.JobDAO;
import com.thuocdo.ma.DAO.RoleDAO;

/**
 * @author minhbv
 * 
 */
public class AccountAction extends ActionSupport implements
		ModelDriven<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Account> lstAccount;
	private Account account;
	private List<Job> lstJob;
	private AccountDAO lnkAccount;
	private CategoryDAO lnkCategory;
	private List<Category> lstCategory;
	private RoleDAO lnkRole;
	private JobDAO lnkJob;
	private List<Role> lstRole;
	private String listAccountID;
	private SessionMap<String, Object> session;
	private Account sAccount;

	public AccountAction() {

		account = new Account();
		this.lnkAccount = new AccountDAO();
		this.lnkJob = new JobDAO();
		this.lnkCategory = new CategoryDAO();
		this.lnkRole = new RoleDAO();
		this.lstAccount = lnkAccount.getListAccount();
		this.lstJob = lnkJob.getJobList();
		this.lstRole = lnkRole.getRoleList();
		this.lstCategory = lnkCategory.getCategoryList();

	}

	@Override
	public Account getModel() {
		// TODO Auto-generated method stub
		return account;
	}

	public List<Account> getLstAccount() {
		return lstAccount;
	}

	public void setLstAccount(List<Account> lstAccount) {
		this.lstAccount = lstAccount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Job> getLstJob() {
		return lstJob;
	}

	public void setLstJob(List<Job> lstJob) {
		this.lstJob = lstJob;
	}

	public String saveAndUpdate() {
		try {
			if (null != getAccount()) {
				lnkAccount.saveAndUpdateAccount(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String execute() {
		try {
			session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			sAccount = (Account) session.get("account");
			if (sAccount != null
					&& sAccount.getRole().getRoleName().equals("Admin")) {
				this.lstAccount = lnkAccount.getListAccount();
			} else {
				addActionError("Please login by admin role.");
				addActionMessage("Hay dang nhap");
				System.out.println("loi lp damg mja[");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("Please login into system.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String edit() {
		try {
			session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			sAccount = (Account) session.get("account");
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			if (sAccount != null
					&& sAccount.getRole().getRoleName().equals("Admin")) {
				account = lnkAccount.getAccountByAccountID(Integer
						.parseInt(request.getParameter("id")));
			} else {
				addActionError("Please login into system.");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("Please login by admin role.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			sAccount = (Account) session.get("account");
			if (sAccount != null
					&& sAccount.getRole().getRoleName().equals("Admin")) {
				lnkAccount.deleteAccount(Integer.parseInt(request
						.getParameter("id")));
			} else {
				addActionError("Please login into system.");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("Please login by admin role");
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteMany() {
		try {
			session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			sAccount = (Account) session.get("account");
			if (sAccount.getRole().getRoleName().equals("Admin")) {
				String[] roleIDList = getListAccountID().split(",");
				for (int i = 0; i < roleIDList.length; i++) {
					lnkAccount.deleteAccount(Integer.parseInt(roleIDList[i]
							.trim()));
				}
			} else {
				addActionError("Please login into system.");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("Please login by admin role");
			return ERROR;
		}
		return SUCCESS;
	}

	public String login() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		System.out.println("username" + username);
		System.out.println("pass" + password);
		Account account = lnkAccount.login(username, password);
		if (account != null) {
			ServletActionContext.getContext().getSession().put("account",
					account);
			return SUCCESS;
		} else {
			addActionMessage("Please check username and password.");
			addActionMessage("Or your account is non-active.");
			return ERROR;
		}
	}

	public String changePassword() {
		SessionMap<String, Object> session = (SessionMap<String, Object>) ServletActionContext
				.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		// Account sAccount = (Account) session.get("account");
		// account = lnkAccount.getAccountByUserName(sAccount.getUserName());
		String oldPass = request.getParameter("oldPassword");
		account = (Account) session.get("account");
		if (account.getPassword().equals(oldPass)) {
			String npassword = request.getParameter("password");
			account.setPassword(npassword);
			account = lnkAccount.changePassword(account);

			if (account != null) {
				ServletActionContext.getContext().getSession().put("account",
						account);
			}
		} else {
			addActionMessage("Old password is wrong!");
			return INPUT;
		}
		return SUCCESS;
	}

	public String saveRegister() {
		try {
			System.out.println("ACcount" + account.getUserName());
			System.out.println("Count ACcount"
					+ lnkAccount.checkExits(account.getUserName()));
			System.out.println("Email" + account.getEmail());
			System.out.println("Count Email"
					+ lnkAccount.checkExitsEmail(account.getEmail()));
			if (lnkAccount.checkExits(account.getUserName()) >= 1) {
				addActionError("User Name is existed");
				System.out.println("ACcount" + account.getUserName());
				System.out.println("Count ACcount"
						+ lnkAccount.checkExits(account.getUserName()));
				return ERROR;
			}

			else

			if (lnkAccount.checkExitsEmail(account.getEmail()) >= 1)

			{
				addActionError("Email is existed");
				return ERROR;
			}

			else if (null != getAccount()) {
				account.setIsActive(true);
				account.setRole(lstRole.get(1));
				account = lnkAccount.saveAndUpdateAccount(account);
				ServletActionContext.getContext().getSession().put("account",
						account);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String getListAccountID() {
		return listAccountID;
	}

	public void setListAccountID(String listAccountID) {
		this.listAccountID = listAccountID;
	}

	public String logout() {
		try {
			SessionMap<String, Object> session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			session.remove("account");
			session.clear();
			session.invalidate();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String view() {
		try {
			SessionMap<String, Object> session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			Account sAccount = (Account) session.get("account");
			account = lnkAccount.getAccountByUserName(sAccount.getUserName());
		} catch (Exception e) {
			addActionError("Please login into system.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewRegister() {
		this.lstJob = lnkJob.getJobList();
		return SUCCESS;
	}

	public String addGuestInfor() {
		try {
			account.setIsAccountTemp(true);
			lnkAccount.saveAndUpdateAccount(account);
			session = (SessionMap<String, Object>) ServletActionContext
					.getContext().getSession();
			session.put("account", account);
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
	}

	public List<Role> getLstRole() {
		return lstRole;
	}

	public void setLstRole(List<Role> lstRole) {
		this.lstRole = lstRole;
	}

	public List<Category> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(List<Category> lstCategory) {
		this.lstCategory = lstCategory;
	}
}
