package com.tony.util;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumberTools;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

import com.tony.bean.CommonTopicReply;
import com.tony.bean.Reply;
import com.tony.bean.Topic;

public class DocumentUtils {
	/**
	 * ��ͨ��ģ��ת��ΪDocument
	 * 
	 * @param common
	 * @return
	 */
	public static Document common2Document(CommonTopicReply common) {
		Document doc = new Document();

		Field titleField = new Field("title", common.getTitle(), Store.YES,
				Index.ANALYZED);
		titleField.setBoost(2.0f);

		doc.add(new Field("id", NumberTools.longToString(common.getId()),
				Store.YES, Index.NOT_ANALYZED));
		doc.add(titleField);
		doc.add(new Field("content", common.getContent(), Store.YES,
				Index.ANALYZED));
		doc.add(new Field("submitTime", common.getSubmitTime(), Store.YES,
				Index.NO));

		return doc;
	}

	public static CommonTopicReply document2common(Document doc) {
		try {
			CommonTopicReply common = new CommonTopicReply();

			common.setId(Integer.parseInt(doc.get("id")));
			common.setTitle(doc.get("title"));
			common.setContent(doc.get("content"));
			common.setSubmitTime(doc.get("submitTime"));

			return common;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��Topicת��ΪDocument
	 * 
	 * @param topic
	 * @return
	 */
	public static Document topic2Document(Topic topic) {

		Document doc = new Document();

		Field titleField = new Field("title", topic.getTitle(), Store.YES,
				Index.ANALYZED);
		titleField.setBoost(2.0f);

		doc.add(new Field("id", NumberTools.longToString(topic.getTopicId()),
				Store.YES, Index.NOT_ANALYZED));
		doc.add(titleField);
		doc.add(new Field("content", topic.getContent(), Store.YES,
				Index.ANALYZED));
		doc.add(new Field("submitTime", topic.getSubmitTime(), Store.YES,
				Index.NO));

		return doc;
	}

	/**
	 * ��Documentת��ΪTopic
	 * 
	 * @param doc
	 * @return
	 */
	public static Topic document2Topic(Document doc) {
		try {
			Topic topic = new Topic();

			topic.setTopicId(Integer.parseInt(doc.get("id")));
			topic.setTitle(doc.get("title"));
			topic.setContent(doc.get("content"));
			topic.setSubmitTime(doc.get("submitTime"));

			return topic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��Replyת��ΪDocument id��Ϊ����ӦTopic��id,title��Ϊ���ظ���+��ӦTopic��title
	 * 
	 * @param reply
	 * @return
	 */
	public static Document reply2Document(Reply reply) {

		Document doc = new Document();

		Field titleField = new Field("title", reply.getTopic().getTitle(),
				Store.YES, Index.ANALYZED);
		titleField.setBoost(2.0f);

		doc.add(new Field("id", NumberTools.longToString(reply.getTopic()
				.getTopicId()), Store.YES, Index.NOT_ANALYZED));
		doc.add(titleField);
		doc.add(new Field("content", reply.getContent(), Store.YES,
				Index.ANALYZED));
		doc.add(new Field("submitTime", reply.getSubmitTime(), Store.YES,
				Index.NO));

		return null;
	}
}
