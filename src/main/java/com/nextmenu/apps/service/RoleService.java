package com.nextmenu.apps.service;

import java.io.Serializable;
import java.util.List;

import com.nextmenu.apps.entity.Role;

public interface RoleService{
	
	public List<Role> getRoles();
	
	public Role getRole(Serializable id);
	
	public void save(Role role);
	
	public void delete(Serializable id);
}
