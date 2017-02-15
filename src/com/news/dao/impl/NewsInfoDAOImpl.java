package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.news.dao.NewsInfoDAO;
import com.news.entity.NewsInfo;

public class NewsInfoDAOImpl implements NewsInfoDAO {
	
	SessionFactory SessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	@Override
	public List<?> getAllNewsInfoByPage(int page, int pageSize) {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(NewsInfo.class);
		criteria.setFirstResult(pageSize * (page - 1));
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("createDate"));
		return criteria.list();
	}

	@Override
	public Integer getCountOfAllNewsInfo() {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(NewsInfo.class);
		return criteria.list().size();
	}

	@Override
	public List<?> getNewsInfoByConditionAndPage(NewsInfo condition, int page, int pageSize) {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(NewsInfo.class);
		if (condition != null) {
			if (condition.getTopic() != null && condition.getTopic().getId() != null ) {
				criteria.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			if (condition.getTitle() != null && !"".equals(condition.getTitle())) {
				criteria.add(Restrictions.like("title", condition.getTitle(), MatchMode.ANYWHERE));
			}
		}
		criteria.setFirstResult(pageSize * (page - 1));
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("createDate"));
		return criteria.list();
	}

	@Override
	public Integer getCountOfNewsInfo(NewsInfo condition) {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(NewsInfo.class);
		if (condition != null) {
			if (condition.getTopic() != null && condition.getTopic().getId() != null ) {
				criteria.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			if (condition.getTitle() != null && !"".equals(condition.getTitle())) {
				criteria.add(Restrictions.like("title", condition.getTitle(), MatchMode.ANYWHERE));
			}
		}
		return criteria.list().size();
	}

}
