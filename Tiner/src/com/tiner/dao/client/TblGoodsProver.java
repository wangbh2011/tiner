package com.tiner.dao.client;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class TblGoodsProver {

	/**
	 * 查询所有订单信息
	 * 
	 * @return
	 */
	public String selectAll() {

		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT id, customer_name, product_category, quantity, jpy_price, cny_price, ");
		sbSql.append(" rate, cny_deal_price, product_profit, status, send_date, remark, ");
		sbSql.append(" updated, created ");
		sbSql.append(" FROM tiner.tbl_goods where deleted = false");
		return sbSql.toString();
	}

	/**
	 * 插入订单订单信息
	 * 
	 * @param item
	 * @return  insert sql
	 */
	public String insertGoods(Map<String, String> item) {
		StringBuffer sbSql = new StringBuffer();

		sbSql.append(" INSERT INTO tbl_goods( ");

		sbSql.append(" id,");
		if (item.containsKey("customerName") && StringUtils.isNotEmpty(item.get("customerName"))) {
			sbSql.append(" customer_name, ");
		}
		if (item.containsKey("productCategory") && StringUtils.isNotEmpty(item.get("productCategory"))) {
			sbSql.append(" product_category, ");
		}
		if (item.containsKey("quantity") && StringUtils.isNotEmpty(item.get("quantity"))) {
			sbSql.append(" quantity, ");
		}
		if (item.containsKey("jpyPrice") && StringUtils.isNotEmpty(item.get("jpyPrice"))) {
			sbSql.append(" jpy_price, ");
		}
		if (item.containsKey("cnyPrice") && StringUtils.isNotEmpty(item.get("cnyPrice"))) {
			sbSql.append(" cny_price, ");
		}
		if (item.containsKey("rate") && StringUtils.isNotEmpty(item.get("rate"))) {
			sbSql.append(" rate, ");
		}
		if (item.containsKey("cnyDealPrice") && StringUtils.isNotEmpty(item.get("cnyDealPrice"))) {
			sbSql.append(" cny_deal_price, ");
		}
		if (item.containsKey("productProfit") && StringUtils.isNotEmpty(item.get("productProfit"))) {
			sbSql.append(" product_profit, ");
		}
		if (item.containsKey("status") && StringUtils.isNotEmpty(item.get("status"))) {
			sbSql.append(" status, ");
		}
		if (item.containsKey("sendDate") && StringUtils.isNotEmpty(item.get("sendDate"))) {
			sbSql.append(" send_date, ");
		}
		if (item.containsKey("remark") && StringUtils.isNotEmpty(item.get("remark"))) {
			sbSql.append(" remark, ");
		}
		if (item.containsKey("created") && StringUtils.isNotEmpty(item.get("created"))) {
			sbSql.append(" created,");
		}
		sbSql.append(" deleted,");
		sbSql.append(" updated )");

		sbSql.append(" VALUES (DEFAULT, ");

		if (item.containsKey("customerName") && StringUtils.isNotEmpty(item.get("customerName"))) {
			sbSql.append(" #{customerName}, ");
		}
		if (item.containsKey("productCategory") && StringUtils.isNotEmpty(item.get("productCategory"))) {
			sbSql.append(" #{productCategory}, ");
		}
		if (item.containsKey("quantity") && StringUtils.isNotEmpty(item.get("quantity"))) {
			sbSql.append(" cast(#{quantity} as numeric), ");
		}
		if (item.containsKey("jpyPrice") && StringUtils.isNotEmpty(item.get("jpyPrice"))) {
			sbSql.append(" cast(#{jpyPrice} as numeric), ");
		}
		if (item.containsKey("cnyPrice") && StringUtils.isNotEmpty(item.get("cnyPrice"))) {
			sbSql.append(" cast(#{cnyPrice} as numeric), ");
		}
		if (item.containsKey("rate") && StringUtils.isNotEmpty(item.get("rate"))) {
			sbSql.append(" cast(#{rate} as numeric), ");
		}
		if (item.containsKey("cnyDealPrice") && StringUtils.isNotEmpty(item.get("cnyDealPrice"))) {
			sbSql.append(" cast(#{cnyDealPrice} as numeric), ");
		}
		if (item.containsKey("productProfit") && StringUtils.isNotEmpty(item.get("productProfit"))) {
			sbSql.append(" cast(#{productProfit} as numeric), ");
		}
		if (item.containsKey("goodsStatus") && StringUtils.isNotEmpty(item.get("goodsStatus"))) {
			sbSql.append(" #{goodsStatus}, ");
		}
		if (item.containsKey("sendDate") && StringUtils.isNotEmpty(item.get("sendDate"))) {
			sbSql.append(" cast(#{sendDate} as date), ");
		}
		if (item.containsKey("remark") && StringUtils.isNotEmpty(item.get("remark"))) {
			sbSql.append(" #{remark}, ");
		}
		if (item.containsKey("created") && StringUtils.isNotEmpty(item.get("created"))) {
			sbSql.append(" cast(#{created} as timestamp),");
		}
		sbSql.append(" false,");
		sbSql.append(" now())");

		return sbSql.toString();
	}
	
	/**
	 * 更新商品信息
	 * 
	 * @param item
	 * @return
	 */
	public String updateGoods(Map<String, String> item){
		StringBuffer sbSql = new StringBuffer();
		
		sbSql.append(" UPDATE tbl_goods");
		sbSql.append(" SET id=id, ");
		if (item.containsKey("customerName") && StringUtils.isNotEmpty(item.get("customerName"))) {
			sbSql.append(" customer_name = #{customerName}, ");
		}
		if (item.containsKey("productCategory") && StringUtils.isNotEmpty(item.get("productCategory"))) {
			sbSql.append(" product_category = #{productCategory}, ");
		}
		if (item.containsKey("quantity") && StringUtils.isNotEmpty(item.get("quantity"))) {
			sbSql.append(" quantity = cast(#{quantity} as numeric), ");
		}
		if (item.containsKey("jpyPrice") && StringUtils.isNotEmpty(item.get("jpyPrice"))) {
			sbSql.append(" jpy_price = cast(#{jpyPrice} as numeric), ");
		}
		if (item.containsKey("cnyPrice") && StringUtils.isNotEmpty(item.get("cnyPrice"))) {
			sbSql.append(" cny_price = cast(#{cnyPrice} as numeric), ");
		}
		if (item.containsKey("rate") && StringUtils.isNotEmpty(item.get("rate"))) {
			sbSql.append(" rate = cast(#{rate} as numeric), ");
		}
		if (item.containsKey("cnyDealPrice") && StringUtils.isNotEmpty(item.get("cnyDealPrice"))) {
			sbSql.append(" cny_deal_price = cast(#{cnyDealPrice} as numeric), ");
		}
		if (item.containsKey("productProfit") && StringUtils.isNotEmpty(item.get("productProfit"))) {
			sbSql.append(" product_profit = cast(#{productProfit} as numeric), ");
		}
		if (item.containsKey("goodsStatus") && StringUtils.isNotEmpty(item.get("goodsStatus"))) {
			sbSql.append(" status = #{goodsStatus}, ");
		}
		if (item.containsKey("sendDate") && StringUtils.isNotEmpty(item.get("sendDate"))) {
			sbSql.append(" send_date = cast(#{sendDate} as date), ");
		}
		if (item.containsKey("remark") && StringUtils.isNotEmpty(item.get("remark"))) {
			sbSql.append(" remark = #{remark}, ");
		}
		if (item.containsKey("deleted") && StringUtils.isNotEmpty(item.get("deleted"))) {
			sbSql.append(" deleted = cast(#{deleted} as boolean), ");
		}
		sbSql.append(" updated = now() ");
		sbSql.append(" WHERE id = cast(#{id} as numeric) ");
		 
		return sbSql.toString();
	}
	
}
