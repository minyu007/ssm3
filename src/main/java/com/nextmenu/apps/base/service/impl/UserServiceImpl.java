package com.nextmenu.apps.base.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nextmenu.apps.base.entity.User;
import com.nextmenu.apps.base.service.UserService;
import com.nextmenu.cp.dao.MyDao;

import org.springframework.context.annotation.Scope; 
@Scope("prototype")
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private MyDao myDao;
	
	public List<?> queryResult(User user){
		return myDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myDao.get("userMapper.selectByPrimaryKey",id);
	}
}
