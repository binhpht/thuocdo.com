package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FAQs database table.
 * 
 */
@Entity
@Table(name="FAQs")
public class FAQ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FAQID")
	private int faqid;

	@Column(name="AnswerContent")
	private String answerContent;

	@Column(name="IsActive")
	private boolean isActive;

	@Column(name="QuestionContent")
	private String questionContent;

    public FAQ() {
    }

	public int getFaqid() {
		return this.faqid;
	}

	public void setFaqid(int faqid) {
		this.faqid = faqid;
	}

	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

}