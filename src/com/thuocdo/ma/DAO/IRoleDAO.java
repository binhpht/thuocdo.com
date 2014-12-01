package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Role;

public interface IRoleDAO {
	public Role addRole(Role role);
	public Role updateRole(Role role);
	public boolean deleteRole(int roleID);
	public Role getRole(int roleID);
	public List<Role> getRoleList();
}
