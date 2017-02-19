package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicDAOImpl implements TopicDAO {

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<?> getAllTopics() {
		Session session = sessionFactory.openSession();
		return session.createCriteria(Topic.class).list();
	}

	@Override
	public Topic getTopicByCondition (Topic topic) {
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Topic.class);
		c.add(Restrictions.eq("topic.name", topic.getName()));
		return (Topic) c.list().get(0);
	}

	@Override
	public void updateTopic(Topic topic) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(topic);
	}

	@Override
	public void deleteTopic(Topic topic) {
		Session session = sessionFactory.openSession();
		session.delete(topic);
	}

}
