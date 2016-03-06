package com.tiner.dao.client;

public class TblUsersProver {

	public String selectUserInfo(){
		
		StringBuffer sbSql = new StringBuffer();
        sbSql.append(" SELECT id, user_name, password")
        	 .append(" FROM tiner.tbl_users ")
        	 .append(" where user_name = #{userName} and password = #{password} ");
		return sbSql.toString();
	}
}
