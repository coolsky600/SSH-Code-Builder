package com.intelligentcore;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.intelligentcore.utils.IOUtils;
import com.intelligentcore.utils.StringUtils;
import com.intelligentcore.utils.TypeMaping;

public class JspBuilder {
	
	public static String getJspCode(String tableName, List<Map<String, String>> cil){
		InputStream is= CodeBuilder.class.getClassLoader().getResourceAsStream("Jsp.Template");
		String pot = IOUtils.inputStream2String(is);
		
		//第一步 把和数据库相关的##TableName 替换成table name
		pot = pot.replace("##TableName", tableName);
		
		//第二步  替换类名
		pot = pot.replace("##ClassName", StringUtils.toUpper(tableName));
		
		//第三步 添加列Tr
		String trTemplate = StringUtils.getZoneInnerText(pot, "ColumnTemplate");
		String trString = "";
		
		for (int i = 0 ;i < cil.size(); i++){
			
			String columnName = cil.get(i).get("COLUMN_NAME");
			//id列 在模板中已有 不再生成
			
			
			String columnType = TypeMaping.toJavaType(cil.get(i).get("TYPE_NAME"));
			String newTr = trTemplate;
			
			newTr = newTr.replace("##ColumnName", columnName);
			trString += newTr;
			//System.out.println(newProperty);
			
		}
		pot = StringUtils.setZone(pot, "ColumnTemplate", trString);
		
		//第四步 添加 edit 值得input
		String editTemplate = StringUtils.getZoneInnerText(pot, "EditTemplate");
		String editString = "";
		
		for (int i = 0 ;i < cil.size(); i++){
			
			String columnName = cil.get(i).get("COLUMN_NAME");
			//id列 在模板中已有 不再生成
			if (false == "id".equals(columnName)){
			
				String columnType = TypeMaping.toJavaType(cil.get(i).get("TYPE_NAME"));
				String newEdit = editTemplate;
				
				newEdit = newEdit.replace("##ColumnName", columnName);
				editString += newEdit;
				//System.out.println(newProperty);
			}
			
		}
		pot = StringUtils.setZone(pot, "EditTemplate", editString);
		
		
		return pot;
		//System.out.println(pot);
	}
	

}
