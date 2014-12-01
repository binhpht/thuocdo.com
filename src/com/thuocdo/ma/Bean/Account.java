package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Account database table.
 * 
 */
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AccountID")
	private int accountID;

	@Column(name="Address")
	private String address;

	@Column(name="Birthday")
	private Timestamp birthday;

	@Column(name="Email")
	private String email;

	@Column(name="FullName")
	private String fullName;

	@Column(name="Gender")
	private boolean gender;

	@Column(name="IsAccountTemp")
	private boolean isAccountTemp;

	@Column(name="IsActive")
	private boolean isActive;

	@Column(name="Mark")
	private int mark;

	@Column(name="Password")
	private String password;

	@Column(name="Phone")
	private String phone;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to Job
    @ManyToOne
	@JoinColumn(name="JobID")
	private Job job;

	//bi-directional many-to-one association to Role
    @ManyToOne
	@JoinColumn(name="RoleID")
	private Role role;

	//bi-directional many-to-one association to Illegal
	@OneToMany(mappedBy="account")
	private List<Illegal> illegals;

	//bi-directional many-to-one association to JoinSurvey
	@OneToMany(mappedBy="account")
	private List<JoinSurvey> joinSurveys;

	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="account")
	private List<Survey> surveys;

    public Account() {
    }

	public int getAccountID() {
		return this.accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean getIsAccountTemp() {
		return this.isAccountTemp;
	}

	public void setIsAccountTemp(boolean isAccountTemp) {
		this.isAccountTemp = isAccountTemp;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getMark() {
		return this.mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Illegal> getIllegals() {
		return this.illegals;
	}

	public void setIllegals(List<Illegal> illegals) {
		this.illegals = illegals;
	}
	
	public List<JoinSurvey> getJoinSurveys() {
		return this.joinSurveys;
	}

	public void setJoinSurveys(List<JoinSurvey> joinSurveys) {
		this.joinSurveys = joinSurveys;
	}
	
	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}
	
}