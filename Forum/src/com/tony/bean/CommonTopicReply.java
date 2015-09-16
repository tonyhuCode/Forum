package com.tony.bean;

import java.io.Serializable;

public class CommonTopicReply implements Serializable {

	private static final long serialVersionUID = 1L;
	/** id号 */
	private int id;
	/** 帖子标题 */
	private String title;
	/** 帖子内容 */
	private String content;
	/** 帖子发布时间 */
	private String submitTime;

	public CommonTopicReply() {

	}

	/**
	 * 将Topic转换为通用模型
	 * 
	 * @param topic
	 */
	public CommonTopicReply(Topic topic) {
		this.id = topic.getTopicId();
		this.title = topic.getTitle();
		this.content = topic.getContent();
		this.submitTime = topic.getSubmitTime();
	}

	/**
	 * 将Reply转换为通用模型
	 * 
	 * @param reply
	 */
	public CommonTopicReply(Reply reply) {
		this.id = reply.getTopic().getTopicId();
		this.title = "回复：" + reply.getTopic().getTitle();
		this.content = reply.getContent();
		this.submitTime = reply.getSubmitTime();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
}
