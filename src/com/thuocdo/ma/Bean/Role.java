package com.thuocdo.ma.Bean;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the Role database table.
 * 
 */
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RoleID")
	private int roleID;

	@Column(name="Description")
	private String description;

	@Column(name="RoleName")
	private String roleName;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="role")
	private List<Account> accounts;

    public Role() {
    }

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}