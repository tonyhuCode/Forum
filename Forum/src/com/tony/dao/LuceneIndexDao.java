package com.tony.dao;

import java.util.List;

import com.tony.bean.CommonTopicReply;

public interface LuceneIndexDao {
	/**
	 * ´´½¨Ë÷Òý
	 * 
	 * @param common
	 */
	public void createIndex(CommonTopicReply common);

	/**
	 * ËÑË÷
	 * 
	 * @param queryString
	 * @return
	 */
	public List<CommonTopicReply> search(String queryString);
}
