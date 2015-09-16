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
	 * 向user添加信息
	 */
	public void test1() {
		/*
		 * UserBiz userBiz=(UserBiz)context.getBean("userBiz"); for (TbUser user
		 * : userBiz.getUserAll()) {
		 * System.out.println("id-->"+user.getUserId()+
		 * ",name-->"+user.getUsername()+",pass-->"+user.getPassword()); }
		 */

		UserDao userDao = (UserDao) context.getBean("userDao");
		// User user = new User("zhangsan", "123456", "男", "1.gif",
		// "走自己的路让别人去说吧！", "zhangsan@sina.com");
		// User user = new User("activity", "123456", "男", "1.gif", "活动公告斑竹",
		// "activity@sina.com");
		// User user = new User("wangwu", "123456", "男", "1.gif", "...",
		// "wangwu@sina.com");
		User user = new User("maliu", "123456", "男", "1.gif", "...",
				"maliu@sina.com");
		userDao.save(user);
	}

	/**
	 * 向ForumType添加信息
	 */
	public void test2() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		// User user=userDao.findByName("activity");
		// User user=userDao.findByName("lisi");
		// User user=userDao.findByName("zhangsan");
		// User user=userDao.findByName("wangwu");

		ForumTypeDao forumDao = (ForumTypeDao) context.getBean("forumTypeDao");
		// ForumType forumType = new ForumType("校园公告", "activity");
		// ForumType forumType = new ForumType("互动交流", "lisi");
		// ForumType forumType = new ForumType("实习兼职", "zhangsan");
		ForumType forumType = new ForumType("学习交流", "wangwu");
		// ForumType forumType = new ForumType("体育健身", "maliu");

		forumDao.save(forumType);
	}

	/**
	 * 向Topic中添加内容
	 */
	public void test3() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = userDao.findByName("wangwu");

		ForumTypeDao forumDao = (ForumTypeDao) context.getBean("forumTypeDao");
		ForumType forumType = forumDao.find(ForumType.class, 4);

		TopicDao topicDao = (TopicDao) context.getBean("topicDao");
		/*
		 * Topic topic = new Topic("发帖须知", "发帖时需注意遵循论坛规则，不能发布违反规则的内容！！！",
		 * "2015-08-27 10:28:00", 0, 0, user, forumType);
		 */
		/*
		 * Topic topic = new Topic("放假通知", "即日起开始放暑假，时间截止到9月13号，望大家按时报到注册。",
		 * "2015-08-27 10:30:00", 0, 0, user, forumType);
		 */
		/*
		 * Topic topic = new Topic("互动交流版块需知", "互动交流版块可以展示各种吐槽、求助、通知等功能",
		 * "2015-08-27 20:30:00", 0, 0, user, forumType);
		 */
		/*
		 * Topic topic = new Topic("实习兼职版块需知", "实习兼职版块发布各种实习兼职信息，欢迎大家踊跃参加",
		 * "2015-08-27 20:35:03", 0, 0, user, forumType);
		 */
		Topic topic = new Topic("学习交流版块需知", "大家可以在本版块探讨学习问题，发布问题、回答问题，互帮互助。",
				"2015-08-27 20:37:25", 0, 0, user, forumType);
		topicDao.save(topic);

	}

	/**
	 * 获取集合
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
