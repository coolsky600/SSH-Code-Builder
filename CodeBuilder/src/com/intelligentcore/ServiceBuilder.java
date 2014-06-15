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
		
		//��һ�� �Ѻ����ݿ���ص�##TableName �滻��table name
		pot = pot.replace("##TableName", tableName);
		
		//�ڶ���  �滻����
		pot = pot.replace("##ClassName", StringUtils.toUpper(tableName));
		
		return pot;
		//System.out.println(pot);
	}
	

}
