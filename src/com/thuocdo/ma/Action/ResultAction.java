package com.thuocdo.ma.Action;
import org.hibernate.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import java.util.*;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.thuocdo.ma.Bean.Question;
import com.thuocdo.ma.DAO.QuestionDAO;
import com.thuocdo.ma.Bean.Answer;
import com.thuocdo.ma.DAO.AnswerDAO;
import com.thuocdo.ma.Bean.Account;
import com.thuocdo.ma.Bean.Category;
import com.thuocdo.ma.Bean.Job;
import com.thuocdo.ma.Bean.JoinSurvey;
import com.thuocdo.ma.Bean.Report;
import com.thuocdo.ma.Bean.Result;
import com.thuocdo.ma.Bean.Role;
import com.thuocdo.ma.Bean.Survey;
import com.thuocdo.ma.DAO.AccountDAO;
import com.thuocdo.ma.DAO.CategoryDAO;
import com.thuocdo.ma.DAO.JobDAO;
import com.thuocdo.ma.DAO.JoinSurveyDAO;
import com.thuocdo.ma.DAO.ResultDAO;
import com.thuocdo.ma.DAO.RoleDAO;
import com.thuocdo.ma.DAO.SurveyDAO;
import com.thuocdo.ma.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import com.opensymphony.xwork2.ModelDriven;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.*;
public class ResultAction extends ActionSupport implements ModelDriven<Result> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Result> lstResult;
	private Result result;
	private List<JoinSurvey> lstJoinSurvey;
	private JoinSurveyDAO lnkJoinSurvey;
	private String name;
	private double [][] percentResult;
	private long [] countNumber;
   

	public long[] getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(long[] countNumber) {
		this.countNumber = countNumber;
	}

	public double[][] getPercentResult() {
		return percentResult;
	}

	public void setPercentResult(double[][] percentResult) {
		this.percentResult = percentResult;
	}

	private List<String> lstNumber;
	public List<String> getLstNumber() {
		return lstNumber;
	}

	public void setLstNumber(List<String> lstNumber) {
		this.lstNumber = lstNumber;
	}

	public String getName() {
		return "Thanh Binh";
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<Answer> lstAnswer;

	public List<Answer> getLstAnswer() {
		return lstAnswer;
	}

	public void setLstAnswer(List<Answer> lstAnswer) {
		this.lstAnswer = lstAnswer;
	}
	
    private List<Report> lstReport;
	public List<Report> getLstReport() {
		return lstReport;
	}

	public void setLstReport(List<Report> lstReport) {
		this.lstReport = lstReport;
	}

	private QuestionDAO lnkQuestion;
	private Question question;
	private List<Question> lstQuestion;
	private ResultDAO lnkResult;
	private AnswerDAO lnkAnswer;
	private CategoryDAO lnkCategory;
	private List<Category> lstCategory;
	private RoleDAO lnkRole;
	private JobDAO lnkJob;
	private List<Role> lstRole;
	private String listAccountID;
	private SessionMap<String, Object> session;
	private Account sAccount;
	private Survey survey;
	private SurveyDAO lnkSurvey;
	private Integer  inumber;

	public Integer getInumber() {
		return inumber;
	}

	public void setInumber(Integer inumber) {
		this.inumber = inumber;
	}

	public SurveyDAO getLnkSurvey() {
		return lnkSurvey;
	}

	public void setLnkSurvey(SurveyDAO lnkSurvey) {
		this.lnkSurvey = lnkSurvey;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public Result getModel() {
		// TODO Auto-generated method stub
		return result;
	}

	public ResultAction() {
		result = new Result();
		this.lnkResult = new ResultDAO();
		this.lnkAnswer = new AnswerDAO();
		this.lnkQuestion = new QuestionDAO();
		this.lnkSurvey = new SurveyDAO();
		this.percentResult = new double[100][100];
		this.countNumber = new long[100];

	}

	public String getResultbyID()
	{ 
		HttpServletRequest request = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
	int surveyID=Integer.parseInt(request.getParameter("id"));
	this.survey = lnkSurvey.getSurvey(surveyID);
    this.lstReport=lnkResult.getReportList(surveyID); 
	try{

		Iterator iterator=lnkResult.getIterator(surveyID);
		int question = -1;
		long answer = -1;
		int numQ = 0;
		int numA = 0;
		int numI = 0;
		long sum = 0;
		while ( iterator.hasNext() ) {
				Object[] row = (Object[]) iterator.next();
				if ( question != (Integer) row[1]) {
					for (int i = 1; i <= numA; i++) {
						percentResult[numQ][i] /= sum;
					}
					System.out.println();
					question = (Integer) row[1];
					numA = 0;
					numQ++;
					sum = 0;
				}
				numI++;
				sum += (Long) row[3];
				numA++;
				countNumber[numI] = (Long)row[3];
				percentResult[numQ][numA] = (Long)row[3];
				System.out.print(countNumber[numI] + " ");
				
	}
		
		} catch(Exception e){
		System.out.println(e.toString());
		return ERROR;
	}
	
	return SUCCESS;
	}
	public String getResultbyReport()
	{  System.out.print("Bao cao bang Jasrel");
		HttpServletRequest request = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
	int surveyID=Integer.parseInt(request.getParameter("id"));
	this.survey = lnkSurvey.getSurvey(surveyID);
    this.lstReport=lnkResult.getReportList(surveyID); 
	try{

		Iterator iterator=lnkResult.getIterator(surveyID);
		int question = -1;
		long answer = -1;
		int numQ = 0;
		int numA = 0;
		int numI = 0;
		long sum = 0;
		while ( iterator.hasNext() ) {
				Object[] row = (Object[]) iterator.next();
				if ( question != (Integer) row[1]) {
					for (int i = 1; i <= numA; i++) {
						percentResult[numQ][i] /= sum;
					}
					System.out.println();
					question = (Integer) row[1];
					numA = 0;
					numQ++;
					sum = 0;
				}
				numI++;
				sum += (Long) row[3];
				numA++;
				countNumber[numI] = (Long)row[3];
				percentResult[numQ][numA] = (Long)row[3];
				System.out.print(countNumber[numI] + " ");
				
	}
		JasperCompileManager.compileReportToFile(
                "/report.jrxml",
                "/report.jasper");
		} catch(Exception e){
		System.out.println(e.toString());
		return ERROR;
	}
	
	return SUCCESS;
	}





	public List<Result> getLstResult() {
		return lstResult;
	}

	public void setLstResult(List<Result> lstResult) {
		this.lstResult = lstResult;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getLstQuestion() {
		return lstQuestion;
	}

	public void setLstQuestion(List<Question> lstQuestion) {
		this.lstQuestion = lstQuestion;
	}

}
