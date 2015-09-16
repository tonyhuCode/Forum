package com.tony.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tony.bean.Topic;
import com.tony.dao.Dao;

@Transactional
public abstract class DaoImpl implements Dao {
	@Resource
	protected SessionFactory sessionFactory;

	public void save(Object entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void update(Object entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	public <T> void delete(Class<T> entityClass, Object entityid) {
		deletes(entityClass, new Object[] { entityid });
	}

	public <T> void deletes(Class<T> entityClass, Object[] entityid) {
		for (Object id : entityid) {
			sessionFactory.getCurrentSession().delete(find(entityClass, id));
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public <T> T find(Class<T> entityClass, Object entityId) {
		return (T) sessionFactory.getCurrentSession().get(entityClass,
				(Serializable) entityId);
	}

}
