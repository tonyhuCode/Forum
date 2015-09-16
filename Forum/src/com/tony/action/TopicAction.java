package com.tony.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tony.bean.ForumType;
import com.tony.bean.Reply;
import com.tony.bean.Topic;
import com.tony.bean.User;
import com.tony.bean.CommonTopicReply;
import com.tony.dao.ForumTypeDao;
import com.tony.dao.LuceneIndexDao;
import com.tony.dao.ReplyDao;
import com.tony.dao.TopicDao;
import com.tony.dao.UserDao;

public class TopicAction extends ActionSupport implements SessionAware,
		ParameterAware {

	private static final long serialVersionUID = 1L;
	/** 帖子号 */
	private int topicId;
	/** 回复内容 */
	private String replyContent;
	/** 新建帖子标题 */
	private String title;
	/** 新建帖子内容 */
	private String content;
	/** 新建帖子类型 */
	private String forumTypeName;

	@Resource
	private TopicDao topicDao;
	@Resource
	private ReplyDao replyDao;
	@Resource
	private ForumTypeDao forumTypeDao;
	@Resource
	private LuceneIndexDao luceneIndexDao;

	/**
	 * 发布新帖
	 * 
	 * @return
	 */
	public String addTopic() {
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);

		Date date = new Date();
		String submitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		topic.setSubmitTime(submitTime);

		topic.setScanCount(0);
		topic.setResponseCount(0);

		topic.setUser((User) sessionMap.get("user"));
		topic.setForumType(forumTypeDao.findByName(forumTypeName));
		// 保存在数据库
		topicDao.save(topic);
		// 保存在索引中
		CommonTopicReply common = new CommonTopicReply(topic);
		luceneIndexDao.createIndex(common);
		return "addTopicSuccess";
	}

	public String addTopicRedirect() {
		List<ForumType> forumTypeList = forumTypeDao.findForumTypes();
		sessionMap.put("forumTypeList", forumTypeList);
		return "addTopicRedirect";
	}

	/**
	 * 为某个帖子添加评论
	 * 
	 * @return
	 */
	public String addReply() {
		User user = (User) sessionMap.get("user");

		Topic topic = topicDao.find(topicId);
		int responseCount = topic.getResponseCount();
		responseCount++;
		topic.setResponseCount(responseCount);
		topicDao.update(topic); // 回复数加一并更新帖子

		Date date = new Date();
		String submitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		Reply reply = new Reply(replyContent, submitTime, user, topic);
		// 保存新回复在数据库中
		replyDao.save(reply);

		// 保存在索引中
		CommonTopicReply common = new CommonTopicReply(reply);
		luceneIndexDao.createIndex(common);

		Set<Reply> replys = topicDao.findReplys(topicId);
		topic.setReplys(replys);
		sessionMap.put("showTopic", topic);

		return "showTopic"; // 添加回复成功之后返回显示帖子页面
	}

	/**
	 * 查看某个帖子
	 * 
	 * @return
	 */
	public String showTopic() {

		Topic showTopic = topicDao.find(topicId);
		int scanCount = showTopic.getScanCount();
		scanCount++; // 查看次数加一
		showTopic.setScanCount(scanCount);
		topicDao.update(showTopic); // 更新

		Set<Reply> replys = topicDao.findReplys(topicId);
		showTopic.setReplys(replys);
		sessionMap.put("showTopic", showTopic);
		return "showTopic";
	}

	private Map<String, String[]> parameterMap = null;

	public void setParameters(Map<String, String[]> arg0) {
		this.parameterMap = arg0;
	}

	private Map<String, Object> sessionMap = null;

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getForumTypeName() {
		return forumTypeName;
	}

	public void setForumTypeName(String forumTypeName) {
		this.forumTypeName = forumTypeName;
	}

}
