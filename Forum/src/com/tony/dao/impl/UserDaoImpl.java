package com.tony.dao.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.bean.User;
import com.tony.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends DaoImpl implements UserDao {

	@Override
	public User findByName(String username) {
		String hql = "from User as u where u.username='" + username + "'";
		User user = (User) super.sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return user;
	}

	@Override
	public User findByNameAndPass(String username, String password) {
		String hql = "from User as u where u.username='" + username + "'"
				+ " and u.password='" + password + "'";
		User user = (User) super.sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return user;
	}

	@Override
	public Set<Topic> findTopics(int userId) {
		User user = (User) super.sessionFactory.getCurrentSession().get(
				User.class, userId);
		Hibernate.initialize(user.getTopics());
		return user.getTopics();
	}

	@Override
	public Set<Reply> findReplys(int userId) {
		User user = (User) super.sessionFactory.getCurrentSession().get(
				User.class, userId);
		Hibernate.initialize(user.getReplys());
		return user.getReplys();
	}

}
