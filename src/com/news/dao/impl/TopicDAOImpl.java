package com.news.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicDAOImpl implements TopicDAO {

	SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public List<?> getAllTopics() {
		Session session = SessionFactory.openSession();
		return session.createCriteria(Topic.class).list();
	}

}
