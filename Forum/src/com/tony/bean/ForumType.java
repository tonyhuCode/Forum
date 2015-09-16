package com.tony.bean;

import java.io.Serializable;
import java.util.Set;

public class ForumType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int typeId;
	/** ��̳������� */
	private String typeName;
	/** ��̳������Ա */
	private String typeManager;
	/** ��������������� */
	private Set<Topic> topics;

	public ForumType() {
		super();
	}

	public ForumType(String typeName, String typeManager) {
		super();
		this.typeName = typeName;
		this.typeManager = typeManager;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeManager() {
		return typeManager;
	}

	public void setTypeManager(String typeManager) {
		this.typeManager = typeManager;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
}
