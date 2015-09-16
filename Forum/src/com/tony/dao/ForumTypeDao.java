package com.tony.dao;

import java.util.List;
import java.util.Set;

import com.tony.bean.ForumType;
import com.tony.bean.Topic;

public interface ForumTypeDao extends Dao{
	/**
	 * 获取本版块内的所有帖子
	 * @param typeId
	 * @return
	 */
	public Set<Topic> findTopics(int typeId);
	/**
	 * 获取所有的版块
	 * @return
	 */
	public List<ForumType> findForumTypes();
	/**
	 * 根据论坛版块名称获取类
	 * @param typeName
	 * @return
	 */
	public ForumType findByName(String typeName);
}
