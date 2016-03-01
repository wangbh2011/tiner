package com.tiner.services;

import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.model.Model;

import com.tiner.base.TinerBaseService;
import com.tiner.form.CartForm;

@Service("loginService")
public class LoginService extends TinerBaseService {

	@Override
	protected String _execute(Model model) {
		CartForm form = (CartForm) model;
		if (form.getUsername().equals("a") && form.getPassword().equals("a")) {
			return "ok";
			
		}
		return "ng";

	}

}
