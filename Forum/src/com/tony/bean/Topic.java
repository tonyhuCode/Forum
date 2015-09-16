package com.tony.bean;

import java.io.Serializable;
import java.util.Set;

public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	private int topicId;
	/** 帖子标题 */
	private String title;
	/** 帖子内容 */
	private String content;
	/** 帖子发布时间 */
	private String submitTime;
	/** 帖子查看数 */
	private int scanCount;
	/** 帖子回复数 */
	private int responseCount;
	/** 帖子所有回复集合 */
	private Set<Reply> replys;
	/** 帖子的作者 */
	private User user;
	/** 帖子所属类别 */
	private ForumType forumType;

	public Topic() {
		super();
	}

	public Topic(String title, String content, String submitTime,
			int scanCount, int responseCount, User user, ForumType forumType) {
		super();
		this.title = title;
		this.content = content;
		this.submitTime = submitTime;
		this.scanCount = scanCount;
		this.responseCount = responseCount;
		this.user = user;
		this.forumType = forumType;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ForumType getForumType() {
		return forumType;
	}

	public void setForumType(ForumType forumType) {
		this.forumType = forumType;
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

	public int getScanCount() {
		return scanCount;
	}

	public void setScanCount(int scanCount) {
		this.scanCount = scanCount;
	}

	public int getResponseCount() {
		return responseCount;
	}

	public void setResponseCount(int responseCount) {
		this.responseCount = responseCount;
	}

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", user=" + user + ", forumType="
				+ forumType + ", title=" + title + ", content=" + content
				+ ", submitTime=" + submitTime + ", scanCount=" + scanCount
				+ ", responseCount=" + responseCount + ", replys=" + replys
				+ "]";
	}

}
