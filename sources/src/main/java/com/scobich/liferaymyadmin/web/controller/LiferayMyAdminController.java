package com.scobich.liferaymyadmin.web.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.scobich.liferaymyadmin.web.model.LoginModel;
import com.scobich.liferaymyadmin.web.validator.LoginModelValidator;

@Controller
@RequestMapping(value = "VIEW")
public class LiferayMyAdminController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new LoginModelValidator());
	}
	
	@ModelAttribute
	public LoginModel getLoginModel() {
		return new LoginModel();
	} 
	
	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, Model model) {
		return "view";
	}
	
	
	@ActionMapping("login")
	public void login(ActionRequest request, ActionResponse response, @ModelAttribute LoginModel loginModel, BindingResult bindingResult) {
	
	}
	
}
