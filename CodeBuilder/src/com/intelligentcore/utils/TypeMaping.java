package com.intelligentcore.utils;

public class TypeMaping {
	
	public static String toJavaType(String sqlType){
		
		if ("BIGINT".equals(sqlType))
			return "long";
		if ("VARCHAR".equals(sqlType))
			return "String";
		return "String";
	}

}
