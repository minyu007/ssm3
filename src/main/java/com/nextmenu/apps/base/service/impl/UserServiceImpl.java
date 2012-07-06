package com.nextmenu.apps.base.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nextmenu.apps.base.entity.User;
import com.nextmenu.apps.base.service.UserService;
import com.nextmenu.cp.service.MyService;

@Service
public class UserServiceImpl extends MyService implements UserService{

	public List<?> queryResult(User user){
		return myDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myDao.get("userMapper.selectByPrimaryKey",id);
	}
}
