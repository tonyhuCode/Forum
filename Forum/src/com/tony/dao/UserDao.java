package com.tony.dao;

import java.util.Set;

import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.bean.User;

public interface UserDao extends Dao {
	/**
	 * �����û��������û�
	 * 
	 * @param username
	 * @return
	 */
	public User findByName(String username);

	/**
	 * �����û�����������֤�û��Ƿ����
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User findByNameAndPass(String username, String password);

	/**
	 * �����û�ID��������������
	 * 
	 * @param userId
	 * @return
	 */
	public Set<Topic> findTopics(int userId);

	/**
	 * �����û�ID���������лظ�
	 * 
	 * @param userId
	 * @return
	 */
	public Set<Reply> findReplys(int userId);

}
