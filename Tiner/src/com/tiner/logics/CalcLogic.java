package com.tiner.logics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiner.dao.mapper.TblGoodsMapper;
import com.tiner.dao.mapper.TblUsersMapper;
import com.tiner.dao.model.TblGoodsModel;
import com.tiner.dao.model.TblUsersModel;
import com.tiner.form.CartForm;
import com.tiner.utils.CommonUtils;

import net.arnx.jsonic.JSON;

/**
 * 
 * @author wangbh
 */
@Component
public class CalcLogic {

	@Autowired
	private TblGoodsMapper tblGoodsMapper;
	@Autowired
	private TblUsersMapper tblUsersMapper;

	/**
	 * 去的订单信息
	 * 
	 * @return
	 */
	public List<TblGoodsModel> selectGoods() {
		return tblGoodsMapper.selectAll();
	}

	/**
	 * 查询用户
	 * 
	 * @param form
	 * @return
	 */
	public List<TblUsersModel> selectUserInfo(CartForm form) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userName", form.getUsername());
		paramMap.put("password", form.getPassword());

		return tblUsersMapper.selectUserInfo(paramMap);
	}

	/**
	 * 更新订单信息
	 * 
	 * @param goodsJsonStr
	 */
	public void updateGoods(String goodsJsonStr) {

		List<Map<String, Object>> list = JSON.decode(goodsJsonStr);

		for (Map<String, Object> item : list) {

			Map<String, String> paramMap = CommonUtils.castMapContentToStringType(item);
			int result = 0;
			// 更新处理
			if (paramMap.containsKey("id") && StringUtils.isNotEmpty(paramMap.get("id").toString())) {
				String status = "";
				if (paramMap.containsKey("status")) {
					status = paramMap.get("status").toString();
				}
				// 删除数据（理论删除）
				if ("-1".equals(status)) {
					Map<String, String> deleteMap = new HashMap<String, String>();
					deleteMap.put("id", paramMap.get("id"));
					deleteMap.put("deleted", "true");

					result = tblGoodsMapper.updateGoods(deleteMap);
				} else {
					// 更新数据
					result = tblGoodsMapper.updateGoods(paramMap);
				}
				if (result <= 0) {
					break;
				}
			} else {
				// 插入数据
				result = tblGoodsMapper.insertGoods(paramMap);
			}

		}
	}
}
