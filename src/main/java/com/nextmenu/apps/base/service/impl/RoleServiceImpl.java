package com.nextmenu.apps.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextmenu.apps.base.entity.Role;
import com.nextmenu.apps.base.service.RoleService;
import com.nextmenu.cp.dao.MyDao;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private MyDao myDao;
	
	public List<Role> getRoles(){
		return myDao.getList("roleMapper.selectByEntity");
	}
	
	public Role getRole(Serializable id){
		return myDao.get("roleMapper.selectByPrimaryKey",id);
	}
	
	public void save(Role role){
		if(role.getId() == null)
			myDao.insert("roleMapper.insert", role);
		else
			myDao.update("roleMapper.update", role);
	}
	
	public void delete(Serializable id){
		myDao.delete("roleMapper.delete", id);
	}
}
