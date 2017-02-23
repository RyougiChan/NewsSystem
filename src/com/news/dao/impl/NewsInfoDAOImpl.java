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
	/**
	 * 获得指定页码page的列表，列表记录为pageSize
	 */
	@Override
	public List<?> getAllNewsInfoByPage(int page, int pageSize) {
		Session session = SessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NewsInfo.class);
		criteria.setFirstResult(pageSize * (page - 1));
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("createDate"));
		return criteria.list();
	}
	/**
	 * 获得记录总数
	 */
	@Override
	public Integer getCountOfAllNewsInfo() {
		Session session = SessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NewsInfo.class);
		return criteria.list().size();
	}
	/**
	 * 根据条件查询指定新闻
	 */
	@Override
	public List<?> getNewsInfoByConditionAndPage(NewsInfo condition, int page, int pageSize) {
		Session session = SessionFactory.getCurrentSession();
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
	/**
	 * 获得指定条件查询得到的记录总数
	 */
	@Override
	public Integer getCountOfNewsInfo(NewsInfo condition) {
		Session session = SessionFactory.getCurrentSession();
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
	/**
	 * 根据id取得记录
	 */
	@Override
	public NewsInfo getNewsInfoById(int id) {
		Session session = SessionFactory.getCurrentSession();
		NewsInfo newsInfo = (NewsInfo) session.get(NewsInfo.class, id);
		return newsInfo;
	}
	/**
	 * 增加一条记录
	 */
	@Override
	public void addNews(NewsInfo newsInfo) {
		Session session = SessionFactory.getCurrentSession();
		session.saveOrUpdate(newsInfo);
	}
	/**
	 * 更新一条记录
	 */
	@Override
	public void updateNews(NewsInfo newsInfo) {
		Session session = SessionFactory.getCurrentSession();
		session.saveOrUpdate(newsInfo);
	}
	/**
	 * 删除一条记录
	 */
	@Override
	public void deleteNews(NewsInfo newsInfo) {
		Session session = SessionFactory.getCurrentSession();
		session.delete(newsInfo);
	}

}
