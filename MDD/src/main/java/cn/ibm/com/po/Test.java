package cn.ibm.com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("test")
@Entity
@Table(name="test")
public class Test{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id ;
	
	@Column(name="cl1")
	private String cl1 ;
	
	@Column(name="cl2")
	private String cl2 ;
	
	@Column(name="cl3")
	private String cl3 ;
	
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCl1() {
		return cl1;
	}
	
	public void setCl1(String cl1) {
		this.cl1 = cl1;
	}
	
	public String getCl2() {
		return cl2;
	}
	
	public void setCl2(String cl2) {
		this.cl2 = cl2;
	}
	
	public String getCl3() {
		return cl3;
	}
	
	public void setCl3(String cl3) {
		this.cl3 = cl3;
	}
	
}
