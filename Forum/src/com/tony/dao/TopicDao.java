package com.tony.dao;

import java.util.Set;

import com.tony.bean.Reply;
import com.tony.bean.Topic;

public interface TopicDao extends Dao{
	/**
	 * �������Ӻŵõ�����������Ϣ
	 * @param topicId
	 * @return
	 */
	public Topic find(int topicId);
	/**
	 * ����ָ�����ӵ����лظ�
	 * @param topicId
	 * @return
	 */
	public Set<Reply> findReplys(int topicId);
}
