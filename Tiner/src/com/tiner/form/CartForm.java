package com.tiner.form;

import java.util.List;

import com.tiner.base.TinerBaseForm;
import com.tiner.dao.model.TblGoodsModel;

public class CartForm extends TinerBaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<TblGoodsModel> goodsList;
	
	private String goodsJsonString;
	private String username;
	private String password;	

	/**
	 * @return the goodsList
	 */
	public List<TblGoodsModel> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList the goodsList to set
	 */
	public void setGoodsList(List<TblGoodsModel> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * @return the goodsJsonString
	 */
	public String getGoodsJsonString() {
		return goodsJsonString;
	}

	/**
	 * @param goodsJsonString the goodsJsonString to set
	 */
	public void setGoodsJsonString(String goodsJsonString) {
		this.goodsJsonString = goodsJsonString;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
