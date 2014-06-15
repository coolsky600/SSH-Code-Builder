package cn.ibm.com.dao.impl;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import cn.ibm.com.dao.TestDao;
import cn.ibm.com.po.Test;

@Component("testDao")
public class TestDaoImpl implements TestDao {
	@Resource(name="hibernateTemplate")
	private HibernateTemplate template;
	
	@Override
	public void insertTest(Test test){
		 long x=(Long) template.save(test);
		 System.out.println(x);
	}
 
	@Override
	public void deleteById(long id){
		Test test=(Test) template.get(Test.class, id);
		template.delete(test);
	}
	
	@Override
	public List<Test> findAll(){
		@SuppressWarnings("unchecked")
		List<Test> list=template.find ( "from Test" );
		return list;
	}
	
	@Override
	public void Update(Test test){
		template.update(test);
	}

	@Override
	public List<Test> findByName(String name) {
		List<Test> list=template.find("from Test u where u.name=?", name);  
		return list;
	}

	@Override
	public Test findById(long id) {
		return template.get(Test.class, id);
	}
	
	@Override
	public List<Test> findByPage(final int start, final int number) {
		List<Test> list=template.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
            	
            	String sql = "select * from test order by id desc limit " + start + "," + (start + number);
            	List list = session.createSQLQuery(sql).addEntity(Test.class).list();
                return list;
         }
		});
		return list;
	}

	@Override
	public int getTotalCount() {
		final String hql = "select count(*) from Test u";
		Long resultTotal= null;
		try{
			resultTotal= (Long) template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				return query.uniqueResult();
			}
		});
		}catch(Exception e)
		{
			System.out.print("error");
		}
		return resultTotal.intValue();
	}

}
