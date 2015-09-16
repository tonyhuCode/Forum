package com.tony.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tony.bean.ForumType;
import com.tony.bean.Topic;
import com.tony.dao.ForumTypeDao;
import com.tony.dao.impl.PageDaoImpl;
import com.tony.util.Page;

public class IndexAction extends ActionSupport implements SessionAware,
		ParameterAware {

	private static final long serialVersionUID = 1L;

	private int currentPage;
	@Resource
	private PageDaoImpl<ForumType> pageDao;
	@Resource
	private ForumTypeDao forumTypeDao;

	public String execute() throws Exception {
		if (parameterMap.get("currentPage") != null) {
			currentPage = Integer.parseInt(parameterMap.get("currentPage")[0]);
		} else {
			currentPage = 1;
		}
		String hql = "from ForumType";
		Page<ForumType> page = pageDao.queryForPage(hql, 6, currentPage);
		List<ForumType> list = page.getList();

		Set<Topic> topics = null;
		for (ForumType forum : list) {
			topics = forumTypeDao.findTopics(forum.getTypeId());
			forum.setTopics(topics);
		}

		sessionMap.put("forumTypeList", list);
		sessionMap.put("page", page);

		if (sessionMap.get("user") == null) {
			sessionMap.put("user", null);
		}
		return "success";
	}

	private Map<String, String[]> parameterMap = null;

	public void setParameters(Map<String, String[]> arg0) {
		this.parameterMap = arg0;
	}

	private Map<String, Object> sessionMap = null;

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

}
