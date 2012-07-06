package com.nextmenu.cp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextmenu.cp.dao.MyDao;
import com.nextmenu.cp.service.Service;

public class MyService implements Service{
	@Autowired
	protected MyDao myDao;
}
