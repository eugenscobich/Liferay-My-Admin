package com.scobich.liferaymyadmin.web.controller;

import java.sql.Connection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.scobich.liferaymyadmin.service.ServerService;
import com.scobich.liferaymyadmin.web.model.LoginModel;
import com.scobich.liferaymyadmin.web.util.WebUtil;
import com.scobich.liferaymyadmin.web.validator.LoginModelValidator;

@Controller
@RequestMapping(value = "VIEW")
public class LiferayMyAdminController {

	public static final Logger LOG = Logger.getLogger(LiferayMyAdminController.class);
	
	@Autowired
	private ServerService serverService;
	
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
	
	@RenderMapping(params="view=welcome")
	public String welcome(RenderRequest request, RenderResponse response, Model model) {
		return "welcome";
	}
	
	@ActionMapping("connect")
	public void connect(ActionRequest request, ActionResponse response, @ModelAttribute LoginModel loginModel, BindingResult bindingResult) {
		
		LOG.info("Connect Action");

		WebUtil.addMessage(request, "Attempt to connect to host: " + loginModel.getHost());

		Connection connection = null;
		try {
			connection = serverService.getConnection(loginModel.getDriver(), loginModel.getUsername(), loginModel.getPassword(), loginModel.getHost(), loginModel.getPort(), loginModel.getDatabase());
		} catch (Exception e) {
			LOG.error(e, e);
			WebUtil.addMessage(request, e.getMessage());
			bindingResult.addError( new ObjectError("driver", e.getClass().getSimpleName() + ": " + e.getMessage()));
		}

		if (connection == null) {
			LOG.warn("Cannot get connection");
			WebUtil.addMessage(request, "Cannot get connection");
			return;
		}
		LOG.info("Successful connection");
		WebUtil.setConnection(request, connection);
		
		response.setRenderParameter("view", "welcome");
	}
	
	
	
}
