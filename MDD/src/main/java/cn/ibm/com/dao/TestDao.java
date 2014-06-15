package cn.ibm.com.dao;

import java.util.List;

import cn.ibm.com.po.Test;

public interface TestDao {

	public  void insertTest(Test test);

	public  void deleteById(long id);

	public  List<Test> findAll();

	public  void Update(Test test);
	
	public List<Test> findByName(String name);
	
	public Test findById(long id);
	
	public List<Test> findByPage(int start, int number);

	public int getTotalCount();
}