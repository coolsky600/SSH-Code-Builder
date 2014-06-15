package cn.ibm.com.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanMapConvertor {
	
	/**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     */
    @SuppressWarnings({"unchecked", "finally" })
	public static Map convertBean(Object bean){
    	
    	Map returnMap = new HashMap();
    	try{
	        Class type = bean.getClass();
	        
	        BeanInfo beanInfo = Introspector.getBeanInfo(type);
	
	        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
	        for (int i = 0; i< propertyDescriptors.length; i++) {
	            PropertyDescriptor descriptor = propertyDescriptors[i];
	            String propertyName = descriptor.getName();
	            if (!propertyName.equals("class")) {
	                Method readMethod = descriptor.getReadMethod();
	                Object result = readMethod.invoke(bean, new Object[0]);
	                if (result != null) {
	                    returnMap.put(propertyName, result);
	                } else {
	                    returnMap.put(propertyName, "");
	                }
	            }
	        }
    	}catch(Exception e){
    		
    	}
    	finally{
        	return returnMap;
        }
    }
    
    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     */
    @SuppressWarnings({"unchecked" })
	public static Object convertMap(Class type, Map map){
    	
    	Object obj = null;
    	try{
	    	BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
	        obj = type.newInstance(); // 创建 JavaBean 对象
        
	        // 给 JavaBean 对象的属性赋值
	        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
	        for (int i = 0; i< propertyDescriptors.length; i++) {
	            PropertyDescriptor descriptor = propertyDescriptors[i];
	            String propertyName = descriptor.getName();
	
	            if (map.containsKey(propertyName)) {
	                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
	                Object value = map.get(propertyName);
	
	                Object[] args = new Object[1];
	                args[0] = value;
	
	                descriptor.getWriteMethod().invoke(obj, args);
	            }
	        }
        }
    	catch(Exception e){
        	e.printStackTrace();
        }
    	return obj;
    }
}
