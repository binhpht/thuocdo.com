package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AgeRank database table.
 * 
 */
@Entity
public class AgeRank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AgeRankID")
	private int ageRankID;

	@Column(name="Description")
	private String description;

	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="ageRank")
	private List<Survey> surveys;

    public AgeRank() {
    }

	public int getAgeRankID() {
		return this.ageRankID;
	}

	public void setAgeRankID(int ageRankID) {
		this.ageRankID = ageRankID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}
	
}