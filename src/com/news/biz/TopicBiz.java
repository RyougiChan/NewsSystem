package com.news.biz;

import java.util.List;

import com.news.entity.Topic;

public interface TopicBiz {
	/** 获取所有的新闻主题 */
	List<?> getAllTopics();
	/** 获取对应主题 */
	List<?> getTopicByCondition (Topic topic);
	/** 获取对应主题 根据id*/
	Topic getTopicByid (int id);
	/** 修改主题 */
	void updateTopic (Topic topic);
	/** 删除主题 */
	void deleteTopic (Topic topic);
}	
