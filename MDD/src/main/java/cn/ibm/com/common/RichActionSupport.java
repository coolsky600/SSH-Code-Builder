package cn.ibm.com.common;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public abstract class RichActionSupport extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	protected final String ERRORMSG ="errorMsg"; 
	protected final String SUCCEED ="0"; 
	protected final String FAILED ="1"; 
	
	//请求时的页数和每页的记录条数
	protected String rows;  
	protected String page;
	protected String id;
	
	//返回json
	protected Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
