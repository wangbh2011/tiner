package com.tiner.services;

import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.model.Model;

import com.tiner.base.TinerBaseService;

@Service("mainService")
public class MainService extends TinerBaseService {

	@Override
	protected String _execute(Model model) {
		return "ok";
	}

}
