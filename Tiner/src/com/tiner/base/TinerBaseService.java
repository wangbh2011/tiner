package com.tiner.base;

import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.ParameterMap;
import org.springframework.webflow.engine.model.Model;
import org.springframework.webflow.execution.RequestContext;

public abstract class TinerBaseService extends MultiAction{

	protected RequestContext request;
	public ParameterMap paramMap;
	
	protected final String RETURN_CODE_OK = "ok";
	
	
	
	
	public String execute(RequestContext requestContext,Model model){
		paramMap = requestContext.getRequestParameters();
		request = requestContext;
		return _execute(model);
	}
	
	
	protected abstract String _execute(Model model);
}
