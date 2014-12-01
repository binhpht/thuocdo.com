package com.thuocdo.ma.Action;

import java.util.List;

import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.Bean.Survey;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.thuocdo.ma.DAO.SurveyDAO;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {
	private List<Survey> lstSurvey;
	private List<Category> lstCategory;
	private List<Survey> lstNewOfSurvey;
	private List<Survey> lstMostOfSurvey;

	private SurveyDAO lnkSurvey;
	private CategoryDAO lnkCategory;

	public IndexAction() {
		lnkCategory = new CategoryDAO();
		lnkSurvey = new SurveyDAO();
		this.lstCategory = lnkCategory.getCategoryList();
		//this.lstSurvey = lnkSurvey.getSurveyList();
		this.lstNewOfSurvey = lnkSurvey.getNewSurveyList();
		this.lstMostOfSurvey = lnkSurvey.getMostOfSurveyList();
	}

	public List<Survey> getLstSurvey() {
		return lstSurvey;
	}

	public String execute() {
	//	this.lstCategory = lnkCategory.getCategoryList();
	//	this.lstSurvey = lnkSurvey.getSurveyList();

		return SUCCESS;
	}

	public void setLstSurvey(List<Survey> lstSurvey) {
		this.lstSurvey = lstSurvey;
	}

	public List<Category> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(List<Category> lstCategory) {
		this.lstCategory = lstCategory;
	}

	public List<Survey> getLstNewOfSurvey() {
		return lstNewOfSurvey;
	}

	public void setLstNewOfSurvey(List<Survey> lstNewOfSurvey) {
		this.lstNewOfSurvey = lstNewOfSurvey;
	}

	public List<Survey> getLstMostOfSurvey() {
		return lstMostOfSurvey;
	}

	public void setLstMostOfSurvey(List<Survey> lstMostOfSurvey) {
		this.lstMostOfSurvey = lstMostOfSurvey;
	}
}
