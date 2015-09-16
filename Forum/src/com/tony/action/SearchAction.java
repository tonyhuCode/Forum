package com.tony.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tony.bean.CommonTopicReply;
import com.tony.dao.LuceneIndexDao;

public class SearchAction extends ActionSupport implements SessionAware,ParameterAware{

	private static final long serialVersionUID = 1L;
	/**ËÑË÷×Ö·û´®*/
	private String queryString;
	
	@Resource private LuceneIndexDao luceneIndexDao;
	
	/**
	 * ËÑË÷º¯Êý
	 * @return
	 */
	public String query(){
		
		List<CommonTopicReply> resultList = luceneIndexDao.search(queryString);
		sessionMap.put("resultList", resultList);
		//resultList
		return "showResult";
	}
	
	
	private Map<String,String[]> parameterMap=null;
	public void setParameters(Map<String, String[]> arg0) {
		this.parameterMap = arg0;
	}

	private Map<String, Object> sessionMap = null;
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
}
