package com.tony.dao;

import java.util.Set;

import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.bean.User;

public interface UserDao extends Dao {
	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByName(String username);

	/**
	 * 根据用户名和密码验证用户是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User findByNameAndPass(String username, String password);

	/**
	 * 根据用户ID查找其所有帖子
	 * 
	 * @param userId
	 * @return
	 */
	public Set<Topic> findTopics(int userId);

	/**
	 * 根据用户ID查找其所有回复
	 * 
	 * @param userId
	 * @return
	 */
	public Set<Reply> findReplys(int userId);

}
