package com.news.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.news.biz.TopicBiz;
import com.news.entity.NewsInfo;
import com.news.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport implements RequestAware, SessionAware {
	
	Topic topic;
	TopicBiz topicBiz;
	Map<String, Object> request;
	Map<String, Object> session;
	String newTopic;
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewTopic() {
		return newTopic;
	}

	public void setNewTopic(String newTopic) {
		this.newTopic = newTopic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public TopicBiz getTopicBiz() {
		return topicBiz;
	}

	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public String topicQuery() throws Exception {
		List<Topic> topics;
		if (topic == null) {
			topics = (List<Topic>) topicBiz.getAllTopics();
		} else {
			topics = (List<Topic>) topicBiz.getTopicByCondition(topic);
		}
		request.put("topicList", topics);
		return "topic_query";
	}
	
	public String topicUpdate() throws Exception {
		Topic topic = new Topic();
		topic.setId(id);
		topic.setName(newTopic);
		topicBiz.updateTopic(topic);
		return "topic_update";
	}
	
	public String topicDelete() throws Exception {
		Topic topic = topicBiz.getTopicByid(id);
		topicBiz.deleteTopic(topic);
		request.put("delete", "success");
		return "topic_delete";
	}
	
}
