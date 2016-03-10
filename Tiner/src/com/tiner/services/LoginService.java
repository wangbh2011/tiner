package com.tiner.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.engine.model.Model;
import org.springframework.webflow.execution.RequestContext;

import com.tiner.dao.model.TblUsersModel;
import com.tiner.form.CartForm;
import com.tiner.logics.CalcLogic;

@Service("loginService")
public class LoginService extends MultiAction {

	@Autowired
	private CalcLogic clogic;

	public String execute(RequestContext requestContext,Model model){
		CartForm form = (CartForm) model;
		HttpServletRequest request = (HttpServletRequest)requestContext.getExternalContext().getNativeRequest();

		List<TblUsersModel> list = clogic.selectUserInfo(form);

		if (list.size() > 0) {
			request.getSession().setAttribute("userName", list.get(0).getUserName());
			return "ok";
		}

		return "ng";
	}

}
