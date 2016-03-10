package com.tiner.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.engine.model.Model;
import org.springframework.webflow.execution.RequestContext;

public abstract class TinerBaseService extends MultiAction{

	protected HttpServletRequest request;
	
	protected HttpSession session;
	
	protected final String RETURN_CODE_OK = "ok";
	
	public String execute(RequestContext requestContext,Model model){
		try{
			request = (HttpServletRequest)requestContext.getExternalContext().getNativeRequest();
			session = request.getSession();
			
			if(session.getAttribute("userName") == null){
				return "login";
			}
			
			return _execute(model);
		}catch(Exception e){
			e.printStackTrace();
			return "ng";
		}
	}
	
	
	protected abstract String _execute(Model model);
}
