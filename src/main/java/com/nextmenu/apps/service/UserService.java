package com.nextmenu.apps.service;

import java.io.Serializable;
import java.util.List;

import com.nextmenu.apps.entity.User;


public interface UserService{
	
	public List<?> queryResult(User user);
	
	public User getUser(Serializable id);
}
