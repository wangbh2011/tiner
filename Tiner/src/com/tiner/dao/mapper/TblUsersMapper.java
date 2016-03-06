package com.tiner.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.tiner.dao.client.TblUsersProver;
import com.tiner.dao.model.TblUsersModel;

public interface TblUsersMapper {
	
	@SelectProvider(type=TblUsersProver.class,method="selectUserInfo")
	@Results({
		@Result(property = "id", column = "id", jdbcType=JdbcType.NUMERIC),
		@Result(property = "userName", column = "user_name", jdbcType=JdbcType.VARCHAR),
		@Result(property = "password", column = "password", jdbcType=JdbcType.VARCHAR),
	})
	public List<TblUsersModel> selectUserInfo(Map<String, String> paramMap);
}
