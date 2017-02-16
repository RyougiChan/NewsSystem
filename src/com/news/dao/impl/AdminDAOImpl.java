package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.news.dao.AdminDAO;
import com.news.entity.Admin;

public class AdminDAOImpl implements AdminDAO {
	
	// 依赖注入sessionfactory
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<?> search(Admin admin) {
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Admin.class);
		
		// 创建示例条件
		Example example = Example.create(admin);
		c.add(example);
		return c.list();
	}

}
