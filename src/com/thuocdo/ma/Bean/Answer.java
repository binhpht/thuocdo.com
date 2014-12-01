package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Answers database table.
 * 
 */
@Entity
@Table(name="Answers")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AnswerID")
	private int answerID;

	@Column(name="AnswerContent")
	private String answerContent;

	//bi-directional many-to-one association to Question
    @ManyToOne
	@JoinColumn(name="QuestionID")
	private Question question;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="answer")
	private List<Result> results;

    public Answer() {
    }

	public int getAnswerID() {
		return this.answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}