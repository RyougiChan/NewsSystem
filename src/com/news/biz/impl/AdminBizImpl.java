package com.news.biz.impl;

import java.util.List;

import com.news.biz.AdminBiz;
import com.news.dao.AdminDAO;
import com.news.entity.Admin;

public class AdminBizImpl implements AdminBiz {
	
	AdminDAO adminDAO;
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	@Override
	public List<?> login(Admin admin) {
		return adminDAO.search(admin);
	}

}
