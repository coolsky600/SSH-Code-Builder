package com.intelligentcore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intelligentcore.utils.IOUtils;
import com.intelligentcore.utils.StringUtils;
import com.intelligentcore.utils.TypeMaping;

public class CodeBuilder {

	private String url = "jdbc:mysql://localhost:3306/wechat";
	private String user = "root";
	private String pass = "19900624";
	private String tableName = "test";
	private String path = "d:/"+tableName;
	
	public Connection getConnection(String url, String user, String pass) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<Map<String, String>> getColumnInfoList(Connection conn, String table){
	
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		DatabaseMetaData dbmd = null;
		
		try {
			dbmd = conn.getMetaData();
			ResultSet colRet = dbmd.getColumns(null,"%", table,"%");
	
			while(colRet.next()) {
				Map<String, String> infoMap = new HashMap<String, String>();
			    String columnName = colRet.getString("COLUMN_NAME");
			    String columnType = colRet.getString("TYPE_NAME");
			    infoMap.put("COLUMN_NAME", columnName);
			    infoMap.put("TYPE_NAME", columnType);
			    //System.out.println(columnName+" "+columnType);
			    list.add(infoMap);
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return list;
		}
		return list;
	}
	
	

	public static void main(String[] args) {
		
		CodeBuilder dbu = new CodeBuilder();
		
		File file = new File(dbu.path);
        if(file.exists())
        	file.delete();
	
        file = new File(dbu.path);
        file.mkdir(); 
		
		
		Connection conn = dbu.getConnection(dbu.url, dbu.user, dbu.pass);
		List<Map<String, String>> cil = dbu.getColumnInfoList(conn, dbu.tableName);
		
		String poContent = POBuilder.getPoCode(dbu.tableName, cil);
		String poPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+".java";
		IOUtils.saveFile( poContent, poPath);
		
		String voContent = VOBuilder.getVoCode(dbu.tableName, cil);
		String voPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+"VO.java";
		IOUtils.saveFile( voContent, voPath);
		
		String daoContent = DAOBuilder.getDaoCode(dbu.tableName, cil);
		String daoPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+"Dao.java";
		IOUtils.saveFile( daoContent, daoPath);
		
		String daoImplContent = DAOImplBuilder.getDaoImplCode(dbu.tableName, cil);
		String daoImplPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+"DaoImpl.java";
		IOUtils.saveFile( daoImplContent, daoImplPath);
		
		String serviceContent = ServiceBuilder.getServiceCode(dbu.tableName, cil);
		String servicePath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+"Service.java";
		IOUtils.saveFile( serviceContent, servicePath);
		
		String actionContent = ActionBuilder.getActionCode(dbu.tableName, cil);
		String actionPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+"Action.java";
		IOUtils.saveFile( actionContent, actionPath);
		
		String jspContent = JspBuilder.getJspCode(dbu.tableName, cil);
		String jspPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+".jsp";
		IOUtils.saveFile( jspContent, jspPath);
		
		String jsContent = JsBuilder.getJsCode(dbu.tableName, cil);
		String jsPath = dbu.path + "/" +StringUtils.toUpper(dbu.tableName)+".js";
		IOUtils.saveFile( jsContent, jsPath);
		
		System.out.println(actionContent);
	}
	

	
	
	
}