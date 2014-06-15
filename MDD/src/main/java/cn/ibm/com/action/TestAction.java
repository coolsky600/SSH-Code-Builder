package cn.ibm.com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import cn.ibm.com.common.RichActionSupport;
import cn.ibm.com.po.Test;
import cn.ibm.com.service.TestService;
import cn.ibm.com.utils.BeanMapConvertor;
import com.opensymphony.xwork2.ModelDriven;

public class TestAction extends RichActionSupport implements ModelDriven<Test>{

	private static final long serialVersionUID = 1L;
	
	private Test test = new Test(); 

	@Resource(name="testService")
	TestService service;
	
	public String insert(){

		if (true == service.insertTest(test))
			dataMap.put(ERRORMSG, SUCCEED);
		else
			dataMap.put(ERRORMSG, FAILED);
		
		return "success";
	}
	
	public String update(){

		if (true == service.updateTest(test))
			dataMap.put(ERRORMSG, SUCCEED);
		else
			dataMap.put(ERRORMSG, FAILED);
		
		return "success";
	}

	public String delete(){
		
		if (true == service.deleteById(test.getId()))
			dataMap.put(ERRORMSG, SUCCEED);
		else
			dataMap.put(ERRORMSG, FAILED);
		
		return "success";
	}
	
	public String findByID(){
		 
		Test result = service.findById(test.getId());
        Map<String,String> m = BeanMapConvertor.convertBean(result);
        dataMap.put("test", m);  
        return SUCCESS;  
	} 
	
	public String findByPage(){
		 
	        List<Test> testList = service.findByPage(page,rows);
	        ArrayList<Map<String,String>> al = new ArrayList<Map<String,String>>();
	        
	        for(Test test : testList){
	        	Map<String,String> m = BeanMapConvertor.convertBean(test);
	            al.add(m);  
	        }   
   
	        dataMap.put("total", service.getTotalCount());  
	        dataMap.put("rows", al);  
	        return SUCCESS;  
	} 

	@Override
	public Test getModel() {
		return test;
	}

}
