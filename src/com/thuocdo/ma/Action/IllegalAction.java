package com.thuocdo.ma.Action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.thuocdo.ma.DAO.SurveyDAO;
import com.thuocdo.ma.Bean.Illegal;
import com.thuocdo.ma.Bean.Survey;
import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.DAO.IllegalDAO;
import com.opensymphony.xwork2.ActionSupport;

public class IllegalAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Bien session luu cac thong tin trong phien lam viec cua nguoi dung
	 */
	private Map<String, Object> session;
	
	private Illegal illegal;
	private IllegalDAO illegalDao;
	private List<Illegal> illegalList; 
	private SurveyDAO surveyDao;
	private Survey survey;
	private String illegalIDList;
	
	public IllegalAction(){
		illegalDao=new IllegalDAO();
		surveyDao=new SurveyDAO();
	}
	
	/**
	 * 
	 * @return
	 */
	public String reportIllegal(){
		try{
			Survey survey=(Survey)getSession().get("joinSurvey");
			Account account=(Account)getSession().get("account");
			survey.setIsIllegal(true);
			surveyDao.updateSurvey(survey);
			illegal.setAccount(account);
			illegal.setSurvey(survey);
			System.out.println(illegal.getReason());
			illegalDao.saveAndUpdateIllegal(illegal);
			return SUCCESS;
		}catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}
	}
	
	public String illegal_ConfirmIllegal(){
		try{
			survey = (Survey)getSession().get("IllegalSurvey");
			survey.setIsIllegal(true);
			surveyDao.updateSurvey(survey);
			illegalList= illegalDao.getIllegalWithSurveyID(survey.getSurveyID());
			for(int i=0;i<illegalList.size();i++){
				illegalList.get(i).setIsSolved(true);
				illegalDao.saveAndUpdateIllegal(illegalList.get(i));
			}
			getSession().remove("IllegalSurvey");
			return SUCCESS;
		}catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}
	}
	
	public String illegal_ConfirmLegal(){
		try{
			survey = (Survey)getSession().get("IllegalSurvey");
			survey.setIsIllegal(false);
			surveyDao.updateSurvey(survey);
			illegalList= illegalDao.getIllegalWithSurveyID(survey.getSurveyID());
			for(int i=0;i<illegalList.size();i++){
				illegalList.get(i).setIsSolved(true);
				illegalDao.saveAndUpdateIllegal(illegalList.get(i));
			}
			getSession().remove("IllegalSurvey");
			return SUCCESS;
		}catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}
	}
	
	public String deleteManyIllegal(){
		try{
			String[] illegalIDList = getIllegalIDList().split(",");			
			for (int i = 0; i < illegalIDList.length; i++) {
				illegalDao.deleteIllegal(Integer.parseInt(illegalIDList[i].trim()));
			}
			return SUCCESS;
		}catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}
	}

	public String getIllegalSurveys(){
		illegalList=illegalDao.getIllegalList();
		return SUCCESS;
	}
	
	public String viewIllegalSurve(){
		survey=surveyDao.getSurvey(survey.getSurveyID());
		getSession().put("IllegalSurvey", survey);
		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
		
	}

	public Illegal getIllegal() {
		return illegal;
	}

	public void setIllegal(Illegal illegal) {
		this.illegal = illegal;
	}

	public List<Illegal> getIllegalList() {
		return illegalList;
	}

	public void setIllegalList(List<Illegal> illegalList) {
		this.illegalList = illegalList;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public String getIllegalIDList() {
		return illegalIDList;
	}

	public void setIllegalIDList(String illegalIDList) {
		this.illegalIDList = illegalIDList;
	}
	
}
