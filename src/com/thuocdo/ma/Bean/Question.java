package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Question database table.
 * 
 */
@Entity
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QuestionID")
	private int questionID;

	@Column(name="QuestionContent")
	private String questionContent;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question",fetch=FetchType.EAGER)
	private List<Answer> answers;

	//bi-directional many-to-one association to Survey
    @ManyToOne
	@JoinColumn(name="SurveyID")
	private Survey survey;

	//bi-directional many-to-one association to TypeOfQuestion
    @ManyToOne
	@JoinColumn(name="TypeOfQuestionID")
	private TypeOfQuestion typeOfQuestion;

    public Question() {
    }

	public int getQuestionID() {
		return this.questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	public TypeOfQuestion getTypeOfQuestion() {
		return this.typeOfQuestion;
	}

	public void setTypeOfQuestion(TypeOfQuestion typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}
	
}