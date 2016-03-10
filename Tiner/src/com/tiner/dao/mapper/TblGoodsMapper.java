package com.tiner.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.tiner.dao.client.TblGoodsProver;
import com.tiner.dao.model.TblGoodsModel;

public interface TblGoodsMapper {
	
	@SelectProvider(type=TblGoodsProver.class,method="selectAll")
	@Results({
		@Result(property = "id", column = "id", jdbcType=JdbcType.NUMERIC),
		@Result(property = "customerName", column = "customer_name", jdbcType=JdbcType.VARCHAR),
		@Result(property = "productCategory", column = "product_category", jdbcType=JdbcType.VARCHAR),
		@Result(property = "quantity", column = "quantity", jdbcType=JdbcType.NUMERIC),
		@Result(property = "jpyPrice", column = "jpy_price", jdbcType=JdbcType.NUMERIC),
		@Result(property = "cnyPrice", column = "cny_price", jdbcType=JdbcType.NUMERIC),
		@Result(property = "rate", column = "rate", jdbcType=JdbcType.NUMERIC),
		@Result(property = "cnyDealPrice", column = "cny_deal_price", jdbcType=JdbcType.NUMERIC),
		@Result(property = "productProfit", column = "product_profit", jdbcType=JdbcType.NUMERIC),
		@Result(property = "status", column = "status", jdbcType=JdbcType.VARCHAR),
		@Result(property = "sendDate", column = "send_date", jdbcType=JdbcType.DATE),
		@Result(property = "remark", column = "remark", jdbcType=JdbcType.VARCHAR),
		@Result(property = "updated", column = "updated"),
		@Result(property = "created", column = "created"),
	})
	public List<TblGoodsModel> selectAll();
	
	@InsertProvider(type=TblGoodsProver.class,method="insertGoods")
	public int insertGoods(Map<String,String> item);
	
	@UpdateProvider(type=TblGoodsProver.class,method="updateGoods")
	public int updateGoods(Map<String,String> item);
}
