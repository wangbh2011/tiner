package com.tiner.dao.client;

public class TblGoodsProver {

	public String selectAll(){
		
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT id, customer_name, product_category, quantity, jpy_price, cny_price, ");
        sbSql.append(" rate, cny_deal_price, product_profit, status, send_date, remark, ");
        sbSql.append(" updated, created ");
        
        sbSql.append(" FROM tiner.tbl_goods");
		
		return sbSql.toString();
	}
}
