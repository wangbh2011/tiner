package com.tiner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.model.Model;

import com.tiner.base.TinerBaseService;
import com.tiner.dao.model.TblUsersModel;
import com.tiner.form.CartForm;
import com.tiner.logics.CalcLogic;

@Service("loginService")
public class LoginService extends TinerBaseService {

	@Autowired
	private CalcLogic clogic;

	@Override
	protected String _execute(Model model) {
		CartForm form = (CartForm) model;
		List<TblUsersModel> list = clogic.selectUserInfo(form);
		if (list.size() > 0) {
			return "ok";

		}
		return "ng";

	}

}
