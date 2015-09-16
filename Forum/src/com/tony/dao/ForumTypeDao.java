package com.tony.dao;

import java.util.List;
import java.util.Set;

import com.tony.bean.ForumType;
import com.tony.bean.Topic;

public interface ForumTypeDao extends Dao{
	/**
	 * ��ȡ������ڵ���������
	 * @param typeId
	 * @return
	 */
	public Set<Topic> findTopics(int typeId);
	/**
	 * ��ȡ���еİ��
	 * @return
	 */
	public List<ForumType> findForumTypes();
	/**
	 * ������̳������ƻ�ȡ��
	 * @param typeName
	 * @return
	 */
	public ForumType findByName(String typeName);
}
