package com.thuocdo.ma.Action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.thuocdo.ma.Bean.Answer;
import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.AgeRank;
import com.thuocdo.ma.Bean.Question;
import com.thuocdo.ma.Bean.Survey;
import com.thuocdo.ma.Bean.Job;
import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.Bean.TypeOfQuestion;
import com.thuocdo.ma.DAO.AnswerDAO;
import com.thuocdo.ma.DAO.QuestionDAO;
import com.thuocdo.ma.DAO.SurveyDAO;
import com.thuocdo.ma.DAO.TypeOfQuestionDAO;
import com.thuocdo.ma.DAO.JobDAO;
import com.thuocdo.ma.DAO.AgeRankDAO;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SurveyAction extends ActionSupport implements SessionAware {// ModelDriven<Survey>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Survey> lstSurvey;
	private List<Survey> lstSurveyByCategory;
	private List<Survey> lstSurveyOfCustomer;
	private List<Category> lstCategory;
	private String keyword;
	private Timestamp beginTime;
	private Timestamp endTime;
	private boolean active;
	private int categoryID;
	/**
	 * Luu thong tin survey can tao
	 */
	private Survey survey;

	/**
	 * Luu noi dung cau hoi can them
	 */
	private Question question;

	/**
	 * Lay ve cac answers duoi dang mot string duoc
	 */
	private String answres;

	/**
	 * Luu danh sach cac job de dua ra select tag
	 */
	private List<Job> jobList;

	/**
	 * Luu danh sach cac ageRank de dua ra select tag
	 */
	private List<AgeRank> ageRankList;

	/**
	 * Luu danh sach cac category de dua ra select tag
	 */
	private List<Category> categoryList;

	/**
	 * Luu danh sach cac typeOfQuestion de dua ra select tag
	 */
	private List<TypeOfQuestion> typeOfQuestionList;

	/**
	 * Bien jobDao dung de lay gia tri cho bien jobList trong database
	 */
	private JobDAO jobDao;

	/**
	 * Bien categoryDao dung de lay gia tri cho bien categoryList trong database
	 */
	private CategoryDAO categoryDao;

	/**
	 * Bien ageRankDao dung de lay gia tri cho bien ageRankList trong database
	 */
	private AgeRankDAO ageRankDao;

	/**
	 * Bien typeOfQuestionDao dung de lay gia tri cho bien typeOfQuestionList
	 * trong database
	 */
	private TypeOfQuestionDAO typeOfQuestionDao;

	/**
	 * Bien surveyDao dung de luu survey vao database
	 */
	private SurveyDAO surveyDao;

	/**
	 * Bien questionDao dung de luu survey vao database
	 */
	private QuestionDAO questionDao;

	/**
	 * Bien answerDao them sua xoa answer vao database
	 */
	private AnswerDAO answerDao;

	/**
	 * Bien session luu cac thong tin trong phien lam viec cua nguoi dung
	 */
	private Map<String, Object> session;

	private String surveyIDList;

	/**
	 * Bien questionIDList luu danh sach cac questionID ma nguoi dung chon xoa
	 */
	private String questionIDList;

	public SurveyAction() {
		jobDao = new JobDAO();
		categoryDao = new CategoryDAO();
		ageRankDao = new AgeRankDAO();
		typeOfQuestionDao = new TypeOfQuestionDAO();
		surveyDao = new SurveyDAO();
		questionDao = new QuestionDAO();
		answerDao = new AnswerDAO();
		lstCategory = categoryDao.getCategoryList();
	}

	/*
	 * public Survey getModel() { // TODO Auto-generated method stub return
	 * survey; }
	 */
	public void setLstSurvey(List<Survey> lstSurvey) {
		this.lstSurvey = lstSurvey;
	}

	public List<Survey> getLstSurvey() {
		return lstSurvey;
	}

	public String viewSurvey() {
		System.out.print("view ListSurvey");
		this.lstSurvey = surveyDao.getSurveyList();

		return SUCCESS;
	}

	public String viewSurveyDetail() {
		System.out.print("View Detail \n");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		this.survey = surveyDao.getSurvey(Integer.parseInt(request
				.getParameter("id")));
		System.out.println(Integer.parseInt(request.getParameter("id")));
		System.out.println(survey.getTitle());

		return SUCCESS;

	}

	public String execute() {
		try {
			getSession().remove("newSurvey");
			this.jobList = jobDao.getJobList();
			this.categoryList = categoryDao.getCategoryList();
			this.ageRankList = ageRankDao.getAgeRankList();
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		if (jobList == null || categoryList == null || ageRankList == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Method nay nhan mot survey cac thong tin duoc nhap vao trong
	 * AddSurveyStep1 Sau do khoi tao mot attribute moi trong session voi name
	 * la "newSurvey" va set value cho attribute nay bang survey vua nhan duoc
	 * Cuoi cung no lay ve danh sach cac TypeOfQuestion de phuc vu cho viec them
	 * moi cac question o step 2.
	 * 
	 * @return
	 */
	public String addSurveyStep1() {

		if (survey != null) {
			Survey newSurvey = (Survey) getSession().get("newSurvey");
			if (newSurvey != null) {
				newSurvey.setTitle(survey.getTitle());
				newSurvey.setCategory(survey.getCategory());
				newSurvey.setDescription(survey.getDescription());
				newSurvey.setAgeRank(survey.getAgeRank());
				newSurvey.setJob(survey.getJob());
				getSession().put("newSurvey", newSurvey);
				survey = newSurvey;
				this.typeOfQuestionList = typeOfQuestionDao.getTypeOfQuestion();
				return "EDIT";
			} else {
				getSession().put("newSurvey", survey);
			}
			this.typeOfQuestionList = typeOfQuestionDao.getTypeOfQuestion();
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * Method nay nhan ve mot question ma nguoi dung vua nhap Tiep theo no lay
	 * ve survey tu attribute "newSurvey" cua session Tiep theo no kiem tra xem
	 * thuoc tinh questions cua survey da khoi tao chua, neu chua khoi tao thi
	 * no se khoi tao Sau khi kiem tra khoi tao, no add question moi nhan duoc
	 * vao question list cua suvey cuoi cung la put lai cai survey vao session
	 * 
	 * @return
	 */
	public String addSurveyStep2() {
		if (question != null) {
			survey = (Survey) getSession().get("newSurvey");
			int questionID = 0;
			if (survey.getQuestions() != null) {
				questionID = survey.getQuestions().size() + 1;
			} else {
				survey.setQuestions(new ArrayList<Question>());
				questionID = 1;
			}
			question.setQuestionID(questionID);
			question.setTypeOfQuestion(typeOfQuestionDao
					.getTypeOfQuestion(question.getTypeOfQuestion()
							.getTypeOfQuestionID()));
			if (question.getAnswers() == null) {
				List<Answer> answerList = new ArrayList<Answer>();
				Answer answer = new Answer();
				answer.setAnswerContent("type answer");
				answerList.add(answer);
				question.setAnswers(answerList);
			}
			survey.getQuestions().add(question);
			getSession().put("newSurvey", survey);
		} else {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Method nay nhan ve mot survey voi cac thong tin ma nguoi dung nhap vao tu
	 * trang addSurveyStep3 Lay doi tuong survey tu session va bo sung them cac
	 * gia tri moi nhan duoc cho doi tuong survey nay Cuoi cung tien hanh luu
	 * doi tuong survey vao database
	 * 
	 * @return
	 */
	public String addSurveyStep3() {
		try {
			if (getSurvey() != null) {
				Survey newSurvey = (Survey) getSession().get("newSurvey");
				newSurvey.setBeginTime(getSurvey().getBeginTime());
				newSurvey.setEndTime(getSurvey().getEndTime());
				newSurvey.setIsActive(getSurvey().getIsActive());
				// Tam thoi khoi tao doi tuong nguoi dung thay dang nhap
				Account ac = (Account) getSession().get("account");
				newSurvey.setAccount(ac);
				surveyDao.saveAndUpdateSurvey(newSurvey);
				getSession().remove("newSurvey");
				
				if(ac.getRole().getRoleName().equals("Admin")){
					this.lstSurvey = surveyDao.getSurveyList();
					return SUCCESS;
				}
				else{
					this.lstSurveyOfCustomer= surveyDao.getSurveyOfCustomer(ac);
					return "customersuccess";
				}
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}		
	}

	/**
	 * Method nay dung de khoi tao cac gia tri cung nhu lay lai thong tin tu
	 * session nham phuc vu cho thao tac back lai cac buoc da lam truoc do cua
	 * nguoi dung
	 * 
	 * @return
	 */
	public String backStep() {
		try {
			this.jobList = jobDao.getJobList();
			this.categoryList = categoryDao.getCategoryList();
			this.ageRankList = ageRankDao.getAgeRankList();
			survey = (Survey) getSession().get("newSurvey");
		} catch (Exception e) {
			return ERROR;
		}
		if (jobList == null || categoryList == null || ageRankList == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Method nay nhan questionID ma nguoi dung da chon tu
	 * QuestionManagement.jsp page sau do lay ve question tuong ung tu question
	 * list cua survey object question lay ve se duoc gui toi EditQuestion.jsp
	 * page de nguoi dung thuc hien edit.
	 * 
	 * @return
	 */
	public String choiseQuestion() {
		survey = (Survey) getSession().get("newSurvey");
		if (getQuestion() != null || survey != null) {
			question = survey.getQuestions().get(
					getQuestion().getQuestionID() - 1);
			this.typeOfQuestionList = typeOfQuestionDao.getTypeOfQuestion();
		} else {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Method nay nhan question vua duoc nguoi dung edit tu EditQuestion.jsp
	 * page sau do gan question vua nhan duoc cho question tuong ung trong
	 * question list cua survey object
	 * 
	 * @return
	 */
	public String editQuestion() {
		try {
			survey = (Survey) getSession().get("newSurvey");
			if (survey != null || getQuestion() != null) {
				getQuestion().setTypeOfQuestion(
						typeOfQuestionDao.getTypeOfQuestion(question
								.getTypeOfQuestion().getTypeOfQuestionID()));
				survey.getQuestions().set(getQuestion().getQuestionID() - 1,
						getQuestion());
				getSession().put("newSurvey", survey);
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Method nay lay danh sach cac TypeOfQuestion de phuc vu cho viec them moi
	 * mot question
	 * 
	 * @return
	 */
	public String addNewQuestion() {
		try {
			this.typeOfQuestionList = typeOfQuestionDao.getTypeOfQuestion();
			if (typeOfQuestionList == null) {
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Method nay nhan danh sach cac questionID vua duoc nguoi dung chon xoa tu
	 * QuestionManagement.jsp page sau do tien hanh remove cac question tuong
	 * ung trong question list cua survey object cuoi cung set lai questionID
	 * cho cac question de phu hop voi id tuong ung cua chung trong list
	 * 
	 * @return
	 */
	public String deleteManyQuestion() {
		try {
			String[] questionIDList = getQuestionIDList().split(",");
			survey = (Survey) getSession().get("newSurvey");
			if (survey != null || questionIDList != null) {
				int k = 0;
				for (int i = 0; i < questionIDList.length; i++) {
					k++;
					survey.getQuestions().remove(
							Integer.parseInt(questionIDList[i].trim()) - k);
				}
				for (int i = 0; i < survey.getQuestions().size(); i++) {
					survey.getQuestions().get(i).setQuestionID(i + 1);
				}
				getSession().put("newSurvey", survey);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	// ===========Cac method xu ly phan edit survey ==================

	public String getOneSurvey() {
		try {
			int id = survey.getSurveyID();
			// this.survey=surveyDao.getSurvey(getSurvey().getSurveyID());
			this.jobList = jobDao.getJobList();
			this.categoryList = categoryDao.getCategoryList();
			this.ageRankList = ageRankDao.getAgeRankList();
			this.survey = surveyDao.getSurvey(id);
			this.survey.getQuestions().get(0).getQuestionContent();
			;
			// for(int i=0;i<this.survey.getQuestions().size();i++){
			// this.survey.getQuestions().get(i).getAnswers();
			// }
			getSession().put("editSurvey", survey);
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		if (jobList == null || categoryList == null || ageRankList == null
				|| survey == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String editSurveyStep1() {
		try {
			Survey editSurvey = (Survey) getSession().get("editSurvey");
			editSurvey.setTitle(survey.getTitle());
			editSurvey.setCategory(survey.getCategory());
			editSurvey.setDescription(survey.getDescription());
			editSurvey.setAgeRank(survey.getAgeRank());
			editSurvey.setJob(survey.getJob());
			getSession().put("editSurvey", editSurvey);
			survey = editSurvey;
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		if (survey == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String editSurvey_choiseQuestion() {
		survey = (Survey) getSession().get("editSurvey");
		if (getQuestion() != null || survey != null) {
			for (int i = 0; i < survey.getQuestions().size(); i++) {
				if (question.getQuestionID() == survey.getQuestions().get(i)
						.getQuestionID()) {
					question = survey.getQuestions().get(i);
					break;
				}
			}
			question.getAnswers();
			System.out.println(question.getAnswers().get(0).getAnswerContent());
			this.typeOfQuestionList = typeOfQuestionDao.getTypeOfQuestion();
		} else {
			return ERROR;
		}
		return SUCCESS;
	}

	public String editSurvey_editQuestion() {
		try {
			survey = (Survey) getSession().get("editSurvey");
			if (getQuestion() != null || survey != null) {
				if (question.getAnswers() != null) {
					for (int i = 0; i < question.getAnswers().size() / 2; i++) {
						question.getAnswers().get(i).setAnswerID(
								question.getAnswers().get(
										i + (question.getAnswers().size() / 2))
										.getAnswerID());
					}
					for (int i = question.getAnswers().size() / 2; i < question
							.getAnswers().size();) {
						question.getAnswers().remove(i);
					}
				} else {
					List<Answer> answerList = new ArrayList<Answer>();
					Answer answer = new Answer();
					answer.setAnswerContent("type answer");
					answerList.add(answer);
					question.setAnswers(answerList);
				}
				for (int i = 0; i < question.getAnswers().size(); i++) {
					System.out.println(question.getAnswers().get(i)
							.getAnswerID()
							+ question.getAnswers().get(i).getAnswerContent());
				}
				int listIndex = 0;
				Question tempQuestion = null;
				for (int i = 0; i < survey.getQuestions().size(); i++) {
					if (question.getQuestionID() == survey.getQuestions()
							.get(i).getQuestionID()) {
						tempQuestion = survey.getQuestions().get(i);
						listIndex = i;
						break;
					}
				}
				boolean flag = false;
				for (int i = 0; i < tempQuestion.getAnswers().size(); i++) {
					flag = false;
					for (int j = 0; j < question.getAnswers().size(); j++) {
						if (tempQuestion.getAnswers().get(i).getAnswerID() == question
								.getAnswers().get(j).getAnswerID()) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						answerDao.deleteAnswer(tempQuestion.getAnswers().get(i)
								.getAnswerID());
					}
				}
				question.setTypeOfQuestion(typeOfQuestionDao
						.getTypeOfQuestion(question.getTypeOfQuestion()
								.getTypeOfQuestionID()));
				// /System.out.println(question.getTypeOfQuestion().getDescription());
				survey.getQuestions().set(listIndex, question);
				question.setSurvey(survey);
				questionDao.updateQuestion(getQuestion());
				this.typeOfQuestionList = typeOfQuestionDao.getTypeOfQuestion();
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editSurvey_addNewQuesion() {
		try {
			survey = (Survey) getSession().get("editSurvey");
			if (question != null && survey != null) {
				question.setTypeOfQuestion(typeOfQuestionDao
						.getTypeOfQuestion(question.getTypeOfQuestion()
								.getTypeOfQuestionID()));

				if (question.getAnswers() == null) {
					List<Answer> answerList = new ArrayList<Answer>();
					Answer answer = new Answer();
					answer.setAnswerContent("type answer");
					answerList.add(answer);
					question.setAnswers(answerList);
				}
				question.setTypeOfQuestion(typeOfQuestionDao
						.getTypeOfQuestion(question.getTypeOfQuestion()
								.getTypeOfQuestionID()));
				question.setSurvey(survey);
				questionDao.addQuestion(question);
				survey.getQuestions().add(question);
				getSession().put("editSurvey", survey);
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editSurvey_getSurveyFromSession() {
		survey = (Survey) getSession().get("editSurvey");
		return SUCCESS;
	}

	public String editSurvey_backStep1() {
		survey = (Survey) getSession().get("editSurvey");
		this.jobList = jobDao.getJobList();
		this.categoryList = categoryDao.getCategoryList();
		this.ageRankList = ageRankDao.getAgeRankList();
		return SUCCESS;
	}

	public String editSurvey_deleteManyQuestion() {
		try {
			String[] questionIDList = getQuestionIDList().split(",");
			survey = (Survey) getSession().get("editSurvey");
			if (survey != null || questionIDList != null) {
				for (int i = 0; i < questionIDList.length; i++) {
					int questionID = Integer.parseInt(questionIDList[i].trim());
					questionDao.deleteQuestion(questionID);
					for (int j = 0; j < survey.getQuestions().size(); j++) {
						if (questionID == survey.getQuestions().get(j)
								.getQuestionID()) {
							survey.getQuestions().remove(j);
							break;
						}
					}
				}
				getSession().put("newSurvey", survey);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editSurvey_editSurveyStep3() {
		try {System.out.println("Buoc 3 roi");
			if (getSurvey() != null) {
				Survey editSurvey = (Survey) getSession().get("editSurvey");
				editSurvey.setBeginTime(getSurvey().getBeginTime());
				editSurvey.setEndTime(getSurvey().getEndTime());
				editSurvey.setIsActive(getSurvey().getIsActive());
				// Tam thoi khoi tao doi tuong nguoi dung thay dang nhap
				Account ac = new Account();
				ac.setAccountID(5);
				editSurvey.setAccount(ac);
				surveyDao.updateSurvey(editSurvey);
				getSession().remove("editSurvey");
				this.lstSurvey = surveyDao.getSurveyList();
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteSurvey() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		try {
			surveyDao
					.deleteSurvey(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteManySurvey() {
		String[] roleIDList = getSurveyIDList().split(",");
		for (int i = 0; i < roleIDList.length; i++) {
			surveyDao.deleteSurvey((Integer.parseInt(roleIDList[i].trim())));
		}
		return SUCCESS;
	}

	public String search() {
		try {
			this.lstSurvey = this.surveyDao.searchSurvey(keyword, beginTime,
					endTime, categoryID, active);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String displaySurveyByCategory() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		try {
			int categoryID = Integer.parseInt(request.getParameter("id"));
			this.lstSurveyByCategory = this.surveyDao.getSurveyList(categoryID);

			System.out.println(this.lstSurveyByCategory);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;

	}
	public String surveyManagementForCustomer(){
		try{
			Account account = (Account) getSession().get("account");
			this.lstSurveyOfCustomer = this.surveyDao.getSurveyOfCustomer(account);
		}catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	// ================================================================
	/**
	 * Getters and setters
	 */

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public List<AgeRank> getAgeRankList() {
		return ageRankList;
	}

	public void setAgeRankList(List<AgeRank> ageRankList) {
		this.ageRankList = ageRankList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<TypeOfQuestion> getTypeOfQuestionList() {
		return typeOfQuestionList;
	}

	public void setTypeOfQuestionList(List<TypeOfQuestion> typeOfQuestionList) {
		this.typeOfQuestionList = typeOfQuestionList;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswres() {
		return answres;
	}

	public void setAnswres(String answres) {
		this.answres = answres;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getQuestionIDList() {
		return questionIDList;
	}

	public void setQuestionIDList(String questionIDList) {
		this.questionIDList = questionIDList;
	}

	public String getSurveyIDList() {
		return surveyIDList;
	}

	public void setSurveyIDList(String surveyIDList) {
		this.surveyIDList = surveyIDList;
	}

	public List<Category> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(List<Category> lstCategory) {
		this.lstCategory = lstCategory;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public List<Survey> getLstSurveyByCategory() {
		return lstSurveyByCategory;
	}

	public void setLstSurveyByCategory(List<Survey> lstSurveyByCategory) {
		this.lstSurveyByCategory = lstSurveyByCategory;
	}

	public List<Survey> getLstSurveyOfCustomer() {
		return lstSurveyOfCustomer;
	}

	public void setLstSurveyOfCustomer(List<Survey> lstSurveyOfCustomer) {
		this.lstSurveyOfCustomer = lstSurveyOfCustomer;
	}
}
