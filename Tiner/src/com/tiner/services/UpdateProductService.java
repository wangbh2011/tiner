package com.tiner.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.model.Model;

import com.tiner.base.TinerBaseService;
import com.tiner.form.CartForm;
import com.tiner.logics.CalcLogic;

@Service("updateProduct")
public class UpdateProductService extends TinerBaseService {

	
	@Override
	protected String _execute(Model model) {

		
		CartForm form = (CartForm)model;
		
		
		return "ok";
	}

}
