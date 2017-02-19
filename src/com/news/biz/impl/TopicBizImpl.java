package com.news.biz.impl;

import java.util.List;

import com.news.biz.TopicBiz;
import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicBizImpl implements TopicBiz {
	
	TopicDAO topicDAO;
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	
	@Override
	public List<?> getAllTopics() {
		return topicDAO.getAllTopics();
	}

	@Override
	public Topic getTopicByCondition(Topic topic) {
		return topicDAO.getTopicByCondition(topic);
	}

	@Override
	public void updateTopic(Topic topic) {
		topicDAO.updateTopic(topic);
	}

	@Override
	public void deleteTopic(Topic topic) {
		topicDAO.deleteTopic(topic);
	}

}
