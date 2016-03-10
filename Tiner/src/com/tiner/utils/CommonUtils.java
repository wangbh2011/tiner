package com.tiner.utils;

import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

	
	/**
	 * Map类型转换<br/>
	 *   Map<String,Object> -> Map<String,String>
	 * 
	 * @param param
	 * @return
	 */
	public static Map<String,String> castMapContentToStringType(Map<String,Object> param){
		Map<String,String> map = new HashMap<String,String>();
		for(String key : param.keySet()){
			if(param.get(key) != null){
				map.put(key, String.valueOf(param.get(key)));
			}
		}
		return map;
	}
}
