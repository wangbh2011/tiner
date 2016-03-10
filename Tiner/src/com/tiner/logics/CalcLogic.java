package com.tiner.logics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiner.dao.mapper.TblGoodsMapper;
import com.tiner.dao.model.TblGoodsModel;
import com.tiner.utils.CommonUtils;

import net.arnx.jsonic.JSON;


@Component
public class CalcLogic {
	
	@Autowired
	private TblGoodsMapper tblGoodsMapper;
	
	
	public List<TblGoodsModel> selectGoods(){
		
		
		return tblGoodsMapper.selectAll();
	}
	
	public void updateGoods(String goodsJsonStr){
		
		
		List<Map<String,Object>> list  = JSON.decode(goodsJsonStr);
		
		System.out.println(list.size());
		
		for(Map<String,Object> item : list){
			
			Map<String,String> paramMap = CommonUtils.castMapContentToStringType(item);
			int result = 0;
			// 更新处理
			if(paramMap.containsKey("id") && StringUtils.isNotEmpty(paramMap.get("id").toString())){
				String status = "";
				if(paramMap.containsKey("status")){
					status = paramMap.get("status").toString();
				}
				
				if("-1".equals(status)){
					Map<String,String> deleteMap = new HashMap<String,String>();
					deleteMap.put("id", paramMap.get("id"));
					deleteMap.put("deleted", "true");

					result = tblGoodsMapper.updateGoods(deleteMap);
				}else{
					result = tblGoodsMapper.updateGoods(paramMap);
				}
				if(result <= 0){
					break;
				}
			}else{
				result = tblGoodsMapper.insertGoods(paramMap);
			}
			
		}
	}
}
