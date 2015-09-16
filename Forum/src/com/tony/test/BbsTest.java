package com.tony.test;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tony.bean.ForumType;
import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.bean.User;
import com.tony.dao.ForumTypeDao;
import com.tony.dao.TopicDao;
import com.tony.dao.UserDao;

public class BbsTest {
	private ApplicationContext context;

	public BbsTest(String xmlPath) {
		context = new ClassPathXmlApplicationContext(xmlPath);
	}

	/**
	 * ��user�����Ϣ
	 */
	public void test1() {
		/*
		 * UserBiz userBiz=(UserBiz)context.getBean("userBiz"); for (TbUser user
		 * : userBiz.getUserAll()) {
		 * System.out.println("id-->"+user.getUserId()+
		 * ",name-->"+user.getUsername()+",pass-->"+user.getPassword()); }
		 */

		UserDao userDao = (UserDao) context.getBean("userDao");
		// User user = new User("zhangsan", "123456", "��", "1.gif",
		// "���Լ���·�ñ���ȥ˵�ɣ�", "zhangsan@sina.com");
		// User user = new User("activity", "123456", "��", "1.gif", "��������",
		// "activity@sina.com");
		// User user = new User("wangwu", "123456", "��", "1.gif", "...",
		// "wangwu@sina.com");
		User user = new User("maliu", "123456", "��", "1.gif", "...",
				"maliu@sina.com");
		userDao.save(user);
	}

	/**
	 * ��ForumType�����Ϣ
	 */
	public void test2() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		// User user=userDao.findByName("activity");
		// User user=userDao.findByName("lisi");
		// User user=userDao.findByName("zhangsan");
		// User user=userDao.findByName("wangwu");

		ForumTypeDao forumDao = (ForumTypeDao) context.getBean("forumTypeDao");
		// ForumType forumType = new ForumType("У԰����", "activity");
		// ForumType forumType = new ForumType("��������", "lisi");
		// ForumType forumType = new ForumType("ʵϰ��ְ", "zhangsan");
		ForumType forumType = new ForumType("ѧϰ����", "wangwu");
		// ForumType forumType = new ForumType("��������", "maliu");

		forumDao.save(forumType);
	}

	/**
	 * ��Topic���������
	 */
	public void test3() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = userDao.findByName("wangwu");

		ForumTypeDao forumDao = (ForumTypeDao) context.getBean("forumTypeDao");
		ForumType forumType = forumDao.find(ForumType.class, 4);

		TopicDao topicDao = (TopicDao) context.getBean("topicDao");
		/*
		 * Topic topic = new Topic("������֪", "����ʱ��ע����ѭ��̳���򣬲��ܷ���Υ����������ݣ�����",
		 * "2015-08-27 10:28:00", 0, 0, user, forumType);
		 */
		/*
		 * Topic topic = new Topic("�ż�֪ͨ", "������ʼ����٣�ʱ���ֹ��9��13�ţ�����Ұ�ʱ����ע�ᡣ",
		 * "2015-08-27 10:30:00", 0, 0, user, forumType);
		 */
		/*
		 * Topic topic = new Topic("�������������֪", "��������������չʾ�����²ۡ�������֪ͨ�ȹ���",
		 * "2015-08-27 20:30:00", 0, 0, user, forumType);
		 */
		/*
		 * Topic topic = new Topic("ʵϰ��ְ�����֪", "ʵϰ��ְ��鷢������ʵϰ��ְ��Ϣ����ӭ���ӻԾ�μ�",
		 * "2015-08-27 20:35:03", 0, 0, user, forumType);
		 */
		Topic topic = new Topic("ѧϰ���������֪", "��ҿ����ڱ����̽��ѧϰ���⣬�������⡢�ش����⣬���ﻥ����",
				"2015-08-27 20:37:25", 0, 0, user, forumType);
		topicDao.save(topic);

	}

	/**
	 * ��ȡ����
	 */
	public void test4() {
		ForumTypeDao forumDao = (ForumTypeDao) context.getBean("forumTypeDao");
		Set<Topic> res = forumDao.findTopics(1);
		/*
		 * TopicDao topicDao = (TopicDao) context.getBean("topicDao");
		 * Set<Reply> res = topicDao.findReplys(2);
		 */

		/*
		 * UserDao userDao = (UserDao) context.getBean("userDao"); Set<Topic>
		 * res = userDao.findTopics(2);
		 */
		for (Topic r : res) {
			System.out.println(r.getTitle() + "  " + r.getContent());
		}
		// System.out.println(res);
	}

	public void test5() {
		TopicDao topicDao = (TopicDao) context.getBean("topicDao");
		Set<Reply> res = topicDao.findReplys(2);

		for (Reply r : res) {
			System.out.println(r.getContent());
		}

		Topic topic = topicDao.find(1);
		User user = topic.getUser();
		System.out.println(user.getUsername());
	}

	public void test6() {
		ForumTypeDao forumDao = (ForumTypeDao) context.getBean("forumTypeDao");
		List<ForumType> list = forumDao.findForumTypes();

		for (ForumType l : list) {
			System.out.println(l.getTypeName());
		}

	}

	public void test7() {
		TopicDao topicDao = (TopicDao) context.getBean("topicDao");
		topicDao.delete(Topic.class, 9);
	}
}
