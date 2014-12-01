package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Account;

public interface IAccountDAO {
	/*
	 * Kiem tra dang nhap tai khoan
	 * 
	 */
	public Account login(String username, String password);
	public Account changePassword(Account acc);
	/*
	 * Them moi mot tai khoan
	 */
	public Account saveAndUpdateAccount(Account account);
	/*
	 * Xoa mot tai khoan
	 */
	public Account deleteAccount(int accountID);
	/*
	 * Cap nhat mot tai khoan cua nguoi dung
	 */
	
	public List<Account> getListAccount();
	/*
	 * Tra ve thong tin tai khoan cua nguoi dung ung voi accountID
	 */
	public Account getAccountByAccountID(int accountID);
	/*
	 * Tra ve thong tin tai khoan ung voi username
	 */
	public Account getAccountByUserName(String username);
	/*
	 * Tra ve danh sach cac tai khoan nguoi dung ung voi rolename, jobName, active
	 * active: active, nonactive, all
	 */
	public List<Account> getListAccount(String roleName, String jobName, String active );
	
}
