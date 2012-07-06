package com.nextmenu.apps.base.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nextmenu.apps.base.entity.User;
import com.nextmenu.apps.base.service.UserService;
import com.nextmenu.cp.Controller.MyController;


@Controller
@RequestMapping("/user")
public class UserController extends MyController{

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, User user) {
		UserService us = (UserService)service;
		model.addAttribute("list", us.queryResult(user));
		model.addAttribute("entity", user);
		return "base/user_list";
	}

	@ResponseBody
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public String validateName(@RequestParam String name) {

		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

}