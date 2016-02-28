package com.tiner.logics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiner.dao.mapper.TblGoodsMapper;
import com.tiner.dao.model.TblGoodsModel;

@Component
public class CalcLogic {
	
	@Autowired
	private TblGoodsMapper tblGoodsMapper;
	
	
	public List<TblGoodsModel> selectGoods(){
		
		
		return tblGoodsMapper.selectAll();
	}
}
