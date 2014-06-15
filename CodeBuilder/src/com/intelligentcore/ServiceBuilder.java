package com.intelligentcore;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.intelligentcore.utils.IOUtils;
import com.intelligentcore.utils.StringUtils;
import com.intelligentcore.utils.TypeMaping;

public class ServiceBuilder {
	
	public static String getServiceCode(String tableName, List<Map<String, String>> cil){
		InputStream is= CodeBuilder.class.getClassLoader().getResourceAsStream("Service.Template");
		String pot = IOUtils.inputStream2String(is);
		
		//第一步 把和数据库相关的##TableName 替换成table name
		pot = pot.replace("##TableName", tableName);
		
		//第二步  替换类名
		pot = pot.replace("##ClassName", StringUtils.toUpper(tableName));
		
		return pot;
		//System.out.println(pot);
	}
	

}
