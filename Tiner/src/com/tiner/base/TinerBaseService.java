package com.tiner.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.engine.model.Model;

public abstract class TinerBaseService extends MultiAction{

	protected HttpServletRequest request;
	
	public String execute(HttpServletRequest request,Model model){
		return _execute(model);
	}
	
	
	protected abstract String _execute(Model model);
}
