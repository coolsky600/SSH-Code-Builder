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
		
		//��һ�� �Ѻ����ݿ���ص�##TableName �滻��table name
		pot = pot.replace("##TableName", tableName);
		
		//�ڶ���  �滻����
		pot = pot.replace("##ClassName", StringUtils.toUpper(tableName));
		
		//������ �����Tr
		String trTemplate = StringUtils.getZoneInnerText(pot, "ColumnTemplate");
		String trString = "";
		
		for (int i = 0 ;i < cil.size(); i++){
			
			String columnName = cil.get(i).get("COLUMN_NAME");
			//id�� ��ģ�������� ��������
			
			
			String columnType = TypeMaping.toJavaType(cil.get(i).get("TYPE_NAME"));
			String newTr = trTemplate;
			
			newTr = newTr.replace("##ColumnName", columnName);
			trString += newTr;
			//System.out.println(newProperty);
			
		}
		pot = StringUtils.setZone(pot, "ColumnTemplate", trString);
		
		//���Ĳ� ��� edit ֵ��input
		String editTemplate = StringUtils.getZoneInnerText(pot, "EditTemplate");
		String editString = "";
		
		for (int i = 0 ;i < cil.size(); i++){
			
			String columnName = cil.get(i).get("COLUMN_NAME");
			//id�� ��ģ�������� ��������
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
