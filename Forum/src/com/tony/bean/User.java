package com.tony.bean;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userId;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 性别 */
	private String sex;
	/** 头像 */
	private String headImage;
	/** 签名 */
	private String signature;
	/** 邮箱 */
	private String email;
	/** 用户所有帖子 */
	private Set<Topic> topics;
	/** 用户所有回复 */
	private Set<Reply> replys;

	public User() {
		super();
	}

	public User(String username, String password, String sex, String headImage,
			String signature, String email) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.headImage = headImage;
		this.signature = signature;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

}
