package com.tony.bean;

import java.io.Serializable;

public class Reply implements Serializable {

	private static final long serialVersionUID = 1L;

	private int replyId;
	/** 回复内容 */
	private String content;
	/** 回复时间 */
	private String submitTime;
	/** 回复的用户 */
	private User user;
	/** 回复主题 */
	private Topic topic;

	public Reply() {
		super();
	}

	public Reply(String content, String submitTime, User user, Topic topic) {
		super();
		this.content = content;
		this.submitTime = submitTime;
		this.user = user;
		this.topic = topic;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
