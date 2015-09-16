package com.tony.action;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.bean.User;
import com.tony.dao.UserDao;

public class UserAction extends ActionSupport implements SessionAware,ParameterAware{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private User user;
	
	@Resource private UserDao userDao;
	/**��¼��ת*/
	public String loginRedirect(){
		return "loginRedirect";
	}
	/**ע����ת*/
	public String registerRedirect(){	
		return "registerRedirect";
	}
	/**
	 * �û������������
	 * @return
	 */
	public String personalCenter(){
		user = (User) sessionMap.get("user");
		if(user == null){
			return "loginRedirect";
		}
		
		Set<Topic> topics = userDao.findTopics(user.getUserId());
		user.setTopics(topics);
		Set<Reply> replys = userDao.findReplys(user.getUserId());
		user.setReplys(replys);
		
		sessionMap.put("user", user);
	
		return "personalCenter";
	}
	/**
	 * �û�ע��
	 * @return
	 */
	public String logout(){
		sessionMap.remove("user");
		return "success";
	}
	/**
	 * �û���¼
	 * @return
	 */
	public String login(){
		if(username != null && password != null){
			System.out.println(username);
			user = userDao.findByNameAndPass(username, password);
			if(user != null){
				sessionMap.put("user", user);
				return "loginSuccess";
			}else{
				sessionMap.put("message", "�û������ڻ������벻��ȷ");
				return "loginFail";
			}
			
		}
		return "loginFail";
	}
	/**
	 * �û�ע�ᣬȱ��һЩ�߼���������ȫ*********
	 * @return
	 */
	public String register(){
		if(user != null){
			System.out.println(user.getUsername());
			userDao.save(user);
			sessionMap.put("user", user);
		}
		return "registerSuccess";
	}
	
	private Map<String,String[]> parameterMap=null;
	public void setParameters(Map<String, String[]> arg0) {
		this.parameterMap = arg0;
	}

	private Map<String, Object> sessionMap = null;
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
