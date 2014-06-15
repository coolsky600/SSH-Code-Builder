package com.intelligentcore.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
	
	public static String inputStream2String(InputStream  is){ 
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        int i= -1; 
        try {
			while((i=is.read())!=-1){ 
			baos.write(i); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       return baos.toString(); 
	}
	
    public static File saveFile(String content,String path) {
    	
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = new File(path);
            if(!file.exists())  
                file.createNewFile();    
  
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            byte[] b=content.getBytes("UTF-8");
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }
    

	
}
