package com.nextmenu.apps.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nextmenu.apps.entity.Role;
import com.nextmenu.apps.service.RoleService;
import com.nextmenu.cp.service.MyService;

@Service
public class RoleServiceImpl extends MyService implements RoleService {

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
