package com.intelligentcore;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.intelligentcore.utils.IOUtils;
import com.intelligentcore.utils.StringUtils;
import com.intelligentcore.utils.TypeMaping;

public class POBuilder {
	
	public static String getPoCode(String tableName, List<Map<String, String>> cil){
		InputStream is= CodeBuilder.class.getClassLoader().getResourceAsStream("Po.Template");
		String pot = IOUtils.inputStream2String(is);
		
		//第一步 把和数据库相关的##TableName 替换成table name
		pot = pot.replace("##TableName", tableName);
		
		//第二步  替换类名
		pot = pot.replace("##ClassName", StringUtils.toUpper(tableName));
		
		//第三步 添加属性
		String propertyTemplate = StringUtils.getZoneInnerText(pot, "PropertyTemplate");
		String propertyString = "";
		
		for (int i = 0 ;i < cil.size(); i++){
			
			String columnName = cil.get(i).get("COLUMN_NAME");
			//id列 在模板中已有 不再生成
			
			
			String columnType = TypeMaping.toJavaType(cil.get(i).get("TYPE_NAME"));
			String newProperty = propertyTemplate;
			
			newProperty = newProperty.replace("##DBColumnName", columnName);
			newProperty = newProperty.replace("##Tpye", columnType);
			newProperty = newProperty.replace("##NameLower", columnName);
			propertyString += newProperty;
			if (true == "id".equals(columnName))
				propertyString = "@Id\n\t@GeneratedValue(strategy=GenerationType.IDENTITY)" + propertyString;
			//System.out.println(newProperty);
			
		}
		pot = StringUtils.setZone(pot, "PropertyTemplate", propertyString);
		//System.out.println(pot);
		
		//第四步 生成getter 和setter
		String GSTemplate = StringUtils.getZoneInnerText(pot, "GSTemplate");
		String GSString = "";
		
		for (int i = 0 ;i < cil.size(); i++){
			
			String columnName = cil.get(i).get("COLUMN_NAME");
			String columnType = TypeMaping.toJavaType(cil.get(i).get("TYPE_NAME"));
			
			String newGS = GSTemplate;
			newGS = newGS.replace("##NameUpper", StringUtils.toUpper(columnName));
			newGS = newGS.replace("##Tpye", columnType);
			newGS = newGS.replace("##NameLower", columnName);
			GSString += newGS;
			//System.out.println(newProperty);
			
		}
		pot = StringUtils.setZone(pot, "GSTemplate", GSString);
		return pot;
		//System.out.println(pot);
	}
	

}
