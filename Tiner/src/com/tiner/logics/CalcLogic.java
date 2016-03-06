package com.tiner.logics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiner.dao.mapper.TblGoodsMapper;
import com.tiner.dao.mapper.TblUsersMapper;
import com.tiner.dao.model.TblGoodsModel;
import com.tiner.dao.model.TblUsersModel;
import com.tiner.form.CartForm;

@Component
public class CalcLogic {

	@Autowired
	private TblGoodsMapper tblGoodsMapper;
	@Autowired
	private TblUsersMapper tblUsersMapper;

	public List<TblGoodsModel> selectGoods() {

		return tblGoodsMapper.selectAll();
	}

	public List<TblUsersModel> selectUserInfo(CartForm form) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userName", form.getUsername());
		paramMap.put("password", form.getPassword());

		return tblUsersMapper.selectUserInfo(paramMap);
	}

}
