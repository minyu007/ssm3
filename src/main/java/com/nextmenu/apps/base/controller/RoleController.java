package com.nextmenu.apps.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextmenu.apps.base.entity.Role;
import com.nextmenu.apps.base.service.RoleService;

/**
 * 角色管理
 * @author 菠萝大象
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("list", roleService.getRoles());
		return "base/role_list";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String create(Model model, Role role){
		model.addAttribute("entity",role);
		return "base/role_edit";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id){
		model.addAttribute("entity", roleService.getRole(id));
		return "base/role_edit";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Model model, Role role){
		roleService.save(role);
		return "redirect:/role";
	}
	
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable Integer id){
		model.addAttribute("entity", roleService.getRole(id));
		return "base/role_view";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable Integer id){
		roleService.delete(id);
		return "redirect:/role";
	}
	
	/**
	 * 转到UserController
	 */
	@RequestMapping(value="/redirect_user", method = RequestMethod.GET)
	public String redirectUser(){
		return "redirect:/user";
	}
}
