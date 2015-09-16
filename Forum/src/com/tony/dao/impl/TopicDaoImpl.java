package com.tony.dao.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.dao.TopicDao;

@Repository("topicDao")
public class TopicDaoImpl extends DaoImpl implements TopicDao {

	public Topic find(int topicId) {
		Topic topic = (Topic) super.sessionFactory.getCurrentSession().get(
				Topic.class, topicId);
		return topic;
	}

	@Override
	public Set<Reply> findReplys(int topicId) {
		Topic topic = (Topic) super.sessionFactory.getCurrentSession().get(
				Topic.class, topicId);
		Hibernate.initialize(topic.getReplys());
		return topic.getReplys();
	}

}
