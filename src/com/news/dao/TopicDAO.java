package com.news.dao;

import java.util.List;

import com.news.entity.Topic;

public interface TopicDAO {
	/** 获取所有的新闻主题 */
	List<?> getAllTopics();
	/** 获取对应主题 */
	List<?> getTopicByCondition (Topic topic);
	/** 获取对应主题根据id */
	Topic getTopicById (int id);
	/** 修改主题 */
	void updateTopic (Topic topic);
	/** 删除主题 */
	void deleteTopic (Topic topic);
	
}
