package com.nextmenu.apps.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextmenu.apps.base.entity.User;
import com.nextmenu.orm.mybatis.MyBatisDao;


@Service
public class UserService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	/**
	 * 根据条件查询
	 */
	public List queryResult(User user){
		return myBatisDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myBatisDao.get("userMapper.selectByPrimaryKey",id);
	}
}
