package com.news.biz.impl;

import java.util.List;

import com.news.biz.TopicBiz;
import com.news.dao.TopicDAO;

public class TopicBizImpl implements TopicBiz {
	
	TopicDAO TopicDAO;
	public void setTopicDAO(TopicDAO topicDAO) {
		TopicDAO = topicDAO;
	}
	
	@Override
	public List<?> getAllTopics() {
		return TopicDAO.getAllTopics();
	}

}
