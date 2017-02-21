package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
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
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Topic.class).list();
	}

	@Override
	public List<?> getTopicByCondition (Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Topic.class);
		if (topic != null) {
			if (topic.getName() != null && !"".equals(topic.getName())) {
				c.add(Restrictions.like("name", topic.getName(), MatchMode.ANYWHERE));
			}
		}
		return c.list();
	}

	@Override
	public Topic getTopicById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Topic) session.get(Topic.class, id);
	}

	@Override
	public void updateTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}

	@Override
	public void deleteTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(topic);
	}

}
