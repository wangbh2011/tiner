package com.tiner.services;

import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.model.Model;

import com.tiner.base.TinerBaseService;

@Service("startUpService")
public class StartUpService extends TinerBaseService{

	@Override
	protected String _execute(Model model) {
		// to index.html
		return RETURN_CODE_OK;
	}

}
