package com.news.biz.impl;

import java.util.List;

import com.news.biz.NewsInfoBiz;
import com.news.dao.NewsInfoDAO;
import com.news.entity.NewsInfo;
import com.news.entity.Pager;

public class NewsInfoBizImpl implements NewsInfoBiz {
	
	NewsInfoDAO newsInfoDAO;
	public void setNewsInfoDAO(NewsInfoDAO newsInfoDAO) {
		this.newsInfoDAO = newsInfoDAO;
	}
	
	@Override
	public List<?> getAllNewsInfoByPage(int page, int pageSize) {
		return newsInfoDAO.getAllNewsInfoByPage(page, pageSize);
	}

	@Override
	public Pager getPagerOfAllNewsInfo(int pageSize) {
		int count = newsInfoDAO.getCountOfAllNewsInfo();
		Pager pager = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public List<?> getNewsInfoByConditionAndPage(NewsInfo condition, int page, int pageSize) {
		return newsInfoDAO.getNewsInfoByConditionAndPage(condition, page, pageSize);
	}

	@Override
	public Pager getPagerOfNewsInfo(NewsInfo condition, int pageSize) {
		int count = newsInfoDAO.getCountOfNewsInfo(condition);
		Pager pager = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public NewsInfo getNewsInfoById(int id) {
		return newsInfoDAO.getNewsInfoById(id);
	}

	@Override
	public void addNews(NewsInfo newsInfo) {
		newsInfoDAO.addNews(newsInfo);
	}

}
