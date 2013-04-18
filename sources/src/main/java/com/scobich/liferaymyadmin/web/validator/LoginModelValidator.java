package com.scobich.liferaymyadmin.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.scobich.liferaymyadmin.web.model.LoginModel;

public class LoginModelValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		if (arg0.equals(LoginModel.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		LoginModel loginModel = (LoginModel)arg0;
		
	}

}
