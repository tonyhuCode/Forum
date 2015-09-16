package com.tony.dao;

import java.util.List;

import com.tony.bean.CommonTopicReply;

public interface LuceneIndexDao {
	/**
	 * ��������
	 * 
	 * @param common
	 */
	public void createIndex(CommonTopicReply common);

	/**
	 * ����
	 * 
	 * @param queryString
	 * @return
	 */
	public List<CommonTopicReply> search(String queryString);
}
