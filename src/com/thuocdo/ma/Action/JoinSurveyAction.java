package com.thuocdo.ma.Action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.thuocdo.ma.Bean.Answer;
import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Job;
import com.thuocdo.ma.Bean.JoinSurvey;
import com.thuocdo.ma.Bean.Result;
import com.thuocdo.ma.Bean.Survey;

import com.thuocdo.ma.DAO.AccountDAO;
import com.thuocdo.ma.DAO.JobDAO;
import com.thuocdo.ma.DAO.SurveyDAO;
import com.thuocdo.ma.DAO.JoinSurveyDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thuocdo.ma.Utils.MS_Services;
public class JoinSurveyAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Survey survey;

	/**
	 * Lay ve cac answers duoi dang mot string duoc
	 */
	private String answres;

	/**
	 * Bien surveyDao dung de luu survey vao database
	 */
	private SurveyDAO surveyDao;
	
	/**
	 * Bien accuntDao dung de lam viec voi du lieu cua account trong database
	 */
	private AccountDAO accountDao;
	
	/**
	 * Bien answerDao them sua xoa answer vao database
	 */
	private JobDAO jobDao;

	private JoinSurveyDAO joinSurveyDao;
	/**
	 * Bien session luu cac thong tin trong phien lam viec cua nguoi dung
	 */
	private Map<String, Object> session;

	/**
	 * Bien questionIDList luu danh sach cac questionID ma nguoi dung chon xoa
	 */
	private String questionIDList;
	
	/**
	 * Bien message chua thong diep tra ve
	 */
	private String message;
	/**
	 * Bien jobList luu danh sach cac nghe nghiep
	 */
	private List<Job> jobList;
	
	
	public JoinSurveyAction() {
		surveyDao = new SurveyDAO();
		joinSurveyDao=new JoinSurveyDAO();
		jobDao=new JobDAO();
		accountDao=new AccountDAO();
	}
	
	/**
	 * Ham lay thong tin ve cuoc khao sat ma nguoi dung chon thuc hien
	 * @return
	 */

	public String getOneSurvey() {
		try {
			getSession().remove("joinSurver");
			int id = survey.getSurveyID();
			this.survey = surveyDao.getSurvey(id);
			if(survey!=null){
				getSession().put("joinSurvey", survey);
				return SUCCESS;
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
	}
	
	/**
	 * Ham nay co chuc nang kiem tra nguoi  tham gia khao sat da dang nhap chua neu chua 
	 * dang nhap thi hien trang cho phep nguoi dung chon dang nhap, dang ky hoac cung cap thong
	 * tin de tiep tuc tham gia khao sat.
	 * Neu nguoi dung da dang nhap hoac da cung cap thong tin thi kiem tra xem cac thong tin 
	 * nguoi dung co phu hop voi yeu cau cua cuoc khao sat khong.
	 * Ngoai ra ham nay con kiem tra xem mot nguoi dung co tai khoan da tham gia cuoc khao
	 * sat nay chua, neu da tham gi thi khong the tiep tuc tham gia nua.
	 * @return
	 */
	public String checkRole() {
		try {
			this.survey = (Survey)getSession().get("joinSurvey");
			Account account=(Account)getSession().get("account");
			if(survey!=null){
				if(account!=null){
					return checkTheRequestOfSurvey(account, survey);
				}else { 
					jobList=jobDao.getJobList();
					return "GUEST";//Nguoi dung la khach
				}
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return ERROR;
		}
	}
	
	/**
	 * Duoc goi boi ham checkRole nham kiem tra cac dieu kien tham gia khao sat 
	 * cua nguoi dung
	 * @param account
	 * @param survey
	 * @return
	 */
	private String checkTheRequestOfSurvey(Account account,Survey survey){
		if(survey.getAgeRank().getDescription().equals("Tẩt Cả")&& survey.getJob().getJobID()==account.getJob().getJobID()
				||survey.getJob().getJobName().equals("Không bắt buộc")&& MS_Services.checkAge(account.getBirthday(), survey.getAgeRank())
				||survey.getJob().getJobID()==account.getJob().getJobID() && MS_Services.checkAge(account.getBirthday(), survey.getAgeRank())
				||survey.getJob().getJobName().equals("Không bắt buộc")&& survey.getAgeRank().getDescription().equals("Tẩt Cả")){
			if(joinSurveyDao.isSurveyed(account, survey)){
				message="You have made this survey!";
				return "ISSURVEYED";
			}else{
				return SUCCESS;
			}
		}else{
			message="Cám ơn bạn đã kham gia cuộc khảo sát, tuy nhiên khảo sát này không dành cho bạn!";
			return "INAPPROPRIATE";
		}	
	}
	
	/**
	 * 
	 * @return
	 */
	public String reGetSurvey(){
		try{
			this.survey = (Survey)getSession().get("joinSurvey");
			this.survey = surveyDao.getSurvey(survey.getSurveyID());
			return SUCCESS;
		} catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}
	}
	
	/**
	 * Phuong thuc addNewJoinSurvey co chuc nang xu ly ket qua cuoc khao
	 * sat ma nguoi dung da thuc hien, tao ra mot doi tuong join survey hoan chinh
	 * va luu vao database.
	 * Phuong thuc nay con co chuc nang kiem tra va cong diem tich luy cho nguoi
	 * dung neu nguoi tham khao sat co tai khoan. 
	 * @return
	 */
	public String addNewJoinSurvey() {
		try{
			List<Result> results=new ArrayList<Result>();//Bien results luu ket qua cac cau tra loi
			JoinSurvey joinSurvey=new JoinSurvey();//Luu cuo khao sat
			Account account=(Account)getSession().get("account");
			survey=(Survey)getSession().get("joinSurvey");
			joinSurvey.setAccount(account);
			joinSurvey.setSurvey(survey);
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			String[] paramValues;
			String[] paramValues2;
			//Lay tat ca cac parameter o trang JoinSurvey_survey.jsp
			Enumeration paramNames = request.getParameterNames();
			//Duyet tat ca cac parameter de lay cac paramValue ve
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				//Neu la cau hoi dang nguoi dung tu go cau tra loi
				if(paramName.contains("typeText.answer")){
					String answerID=paramName.substring(15);
					paramValues2 = request.getParameterValues(paramName);
					if (paramValues2!=null) {
						for (int i = 0; i < paramValues2.length; i++) {
							Answer answer = new Answer();		
							answer.setAnswerID(Integer.parseInt(answerID));							
							Result result = new Result();
							result.setAnswer(answer);
							result.setContentFreeText(paramValues2[i]);
							results.add(result);	
						}
					}
				}else{//Cau hoi o dang chon mot hoac nhieu cau tra loi co san
					paramValues = request.getParameterValues(paramName);
					if (paramValues!=null) {
						for (int i = 0; i < paramValues.length; i++) {
							Answer answer = new Answer();		
							answer.setAnswerID(Integer.parseInt(paramValues[i]));
							Result result = new Result();
							result.setAnswer(answer);
							results.add(result);
						}
					}
				}	
			}
			joinSurvey.setResults(results);
			joinSurveyDao.addJoinSurvey(joinSurvey);
			getSession().remove("joinSurver");
			//Neu nguoi dung co tai khoan thi cong them diem tich luy
			if(!account.getIsAccountTemp()){
				account.setMark(account.getMark()+1);
				accountDao.saveAndUpdateAccount(account);
			}
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public String getAnswres() {
		return answres;
	}

	public void setAnswres(String answres) {
		this.answres = answres;
	}

	public SurveyDAO getSurveyDao() {
		return surveyDao;
	}

	public void setSurveyDao(SurveyDAO surveyDao) {
		this.surveyDao = surveyDao;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getQuestionIDList() {
		return questionIDList;
	}

	public void setQuestionIDList(String questionIDList) {
		this.questionIDList = questionIDList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

}
