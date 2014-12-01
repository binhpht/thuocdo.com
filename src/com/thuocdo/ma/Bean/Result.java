package com.thuocdo.ma.Bean;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Result database table.
 * 
 */
@Entity
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResultID")
	private int resultID;

	@Column(name="ContentFreeText")
	private String contentFreeText;

	//bi-directional many-to-one association to Answer
    @ManyToOne
	@JoinColumn(name="AnswerID")
	private Answer answer;

	//bi-directional many-to-one association to JoinSurvey
    @ManyToOne
	@JoinColumn(name="JoinID")
	private JoinSurvey joinSurvey;

    public Result() {
    }

	public int getResultID() {
		return this.resultID;
	}

	public void setResultID(int resultID) {
		this.resultID = resultID;
	}

	public String getContentFreeText() {
		return this.contentFreeText;
	}

	public void setContentFreeText(String contentFreeText) {
		this.contentFreeText = contentFreeText;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	public JoinSurvey getJoinSurvey() {
		return this.joinSurvey;
	}

	public void setJoinSurvey(JoinSurvey joinSurvey) {
		this.joinSurvey = joinSurvey;
	}
	
}