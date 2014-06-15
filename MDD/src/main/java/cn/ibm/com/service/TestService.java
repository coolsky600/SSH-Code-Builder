package cn.ibm.com.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.ibm.com.dao.TestDao;
import cn.ibm.com.po.Test;
import cn.ibm.com.vo.TestVO;

@Component("testService")
public class TestService {
	@Resource(name="testDao")
	private TestDao testdao;
	
	@Transactional
	public boolean insertTest(Test test){
		testdao.insertTest(test);
		return true;
	}
	
	@Transactional
	public boolean deleteById(long id){
		testdao.deleteById(id);
		return true;
	}
	
	@Transactional
	public boolean  updateTest(Test test){
		testdao.Update(test);
		return true;
	}
	
	@Transactional
	public List<Test> findAll(){
		return testdao.findAll();
	}
	
	@Transactional
	public List<Test> findByName(String name){
		return testdao.findByName(name);
	}
	
	@Transactional
	public Test findById(long id){
		return testdao.findById(id);
	}
	
	@Transactional
	public List<Test> findByPage(int start, int number){
		return testdao.findByPage(start, number);
	}
	
	@Transactional
	public List<Test> findByPage(String page, String rows){
		
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);    
	    int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows);  
	    int start = (intPage-1)*number;
	    
		return testdao.findByPage(start, number);
	}
	
	@Transactional
	public int getTotalCount(){
		return testdao.getTotalCount();
	}
}
