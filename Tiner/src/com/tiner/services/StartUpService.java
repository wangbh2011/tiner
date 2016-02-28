package com.tiner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.model.Model;

import com.tiner.base.TinerBaseService;
import com.tiner.form.CartForm;
import com.tiner.logics.CalcLogic;

@Service("startUpService")
public class StartUpService extends TinerBaseService{

	@Autowired
	private CalcLogic clogic;
	@Override
	protected String _execute(Model model) {

		
		
		CartForm form = (CartForm)model;
		
		form.setGoodsList(clogic.selectGoods());
		// to index.html
		return RETURN_CODE_OK;
	}

}
