package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TypeOfQuestion database table.
 * 
 */
@Entity
public class TypeOfQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TypeOfQuestionID")
	private int typeOfQuestionID;

	@Column(name="Description")
	private String description;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="typeOfQuestion")
	private List<Question> questions;

    public TypeOfQuestion() {
    }

	public int getTypeOfQuestionID() {
		return this.typeOfQuestionID;
	}

	public void setTypeOfQuestionID(int typeOfQuestionID) {
		this.typeOfQuestionID = typeOfQuestionID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}