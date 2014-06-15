package com.intelligentcore.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StringUtils {
	
	public static String getZoneInnerText(String originString, String zoneName){
		
		String[] sa = originString.split("#" + zoneName);
		return sa[1];
	}
	
	public static String getZoneOuterText(String originString, String zoneName){
				
		int start1 = originString.indexOf("#" + zoneName);
		int end1 = start1 + zoneName.length() + 1;
		//System.out.println(originString.substring(start1, end1));
		
		int start2 = originString.indexOf("#" + zoneName, start1 + 1);
		int end2 = start2 + zoneName.length() + 1;
		//System.out.println(originString.substring(start2, end2));
		
		return originString.substring(start1, end2);
	}
	
	public static String setZone(String originString,String zoneTag, String zoneContent){
		
		String zoneOuterText = getZoneOuterText(originString, zoneTag);
		String newString = originString.replace(zoneOuterText, zoneContent);
		return newString;
	}
	
	public static String deleteZone(String originString, String zoneName){
		

		return "";
	}
	
	public static String toUpper(String text){
		StringBuilder sb = new StringBuilder(text);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}
	
	
	
}
