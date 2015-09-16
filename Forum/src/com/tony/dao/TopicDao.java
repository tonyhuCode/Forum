package com.tony.dao;

import java.util.Set;

import com.tony.bean.Reply;
import com.tony.bean.Topic;

public interface TopicDao extends Dao{
	/**
	 * 根据帖子号得到帖子所有信息
	 * @param topicId
	 * @return
	 */
	public Topic find(int topicId);
	/**
	 * 返回指定帖子的所有回复
	 * @param topicId
	 * @return
	 */
	public Set<Reply> findReplys(int topicId);
}
