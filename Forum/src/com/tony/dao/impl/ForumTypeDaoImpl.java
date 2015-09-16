package com.tony.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tony.bean.ForumType;
import com.tony.bean.Topic;
import com.tony.bean.User;
import com.tony.dao.ForumTypeDao;

@Repository("forumTypeDao")
public class ForumTypeDaoImpl extends DaoImpl implements ForumTypeDao {

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Set<Topic> findTopics(int typeId) {
		ForumType forumType = (ForumType) super.sessionFactory.getCurrentSession().get(ForumType.class, typeId);
		Hibernate.initialize(forumType.getTopics());
		return forumType.getTopics();
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<ForumType> findForumTypes(){
		
		@SuppressWarnings("unchecked")
		List<ForumType> list = super.sessionFactory.getCurrentSession().find("from ForumType");
		return list;
	}
	public ForumType findByName(String typeName) {		
		String hql = "from ForumType as f where f.typeName='"+typeName+"'";
		ForumType forumType = (ForumType)super.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		return forumType;
	}


}
