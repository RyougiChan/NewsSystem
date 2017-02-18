package com.news.dao;

import java.util.List;

import com.news.entity.NewsInfo;

public interface NewsInfoDAO {
	
	/** 根据页码获得列表 */
	List<?> getAllNewsInfoByPage (int page, int pageSize);
	/** 获得所有新闻数量 */
	Integer getCountOfAllNewsInfo ();
	/** 根据条件和指定页吗获取新闻列表 */
	List<?> getNewsInfoByConditionAndPage (NewsInfo condition, int page, int pageSize);
	/** 根据条件和指定页吗获取新闻数目 */
	Integer getCountOfNewsInfo (NewsInfo condition);
	
	/** 根据新闻编号id获取新闻 */
	NewsInfo getNewsInfoById (int id);
	/** 添加新闻 */
	void addNews(NewsInfo newsInfo);
	
	void updateNews(NewsInfo newsInfo);
}
