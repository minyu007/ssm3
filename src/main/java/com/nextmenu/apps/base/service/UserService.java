package com.nextmenu.apps.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextmenu.apps.base.entity.User;
import com.nextmenu.cp.dao.MyDao;


@Service
public class UserService {

	@Autowired
	private MyDao myDao;
	
	/**
	 * 根据条件查询
	 */
	public List queryResult(User user){
		return myDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myDao.get("userMapper.selectByPrimaryKey",id);
	}
}
