package com.news.biz;

import java.util.List;

import com.news.entity.NewsInfo;
import com.news.entity.Pager;

public interface NewsInfoBiz {
	
	List<?> getAllNewsInfoByPage (int page, int pageSize);
	
	Pager getPagerOfAllNewsInfo (int pageSize);
	
	List<?> getNewsInfoByConditionAndPage (NewsInfo condition, int page, int pageSize);
	
	Pager getPagerOfNewsInfo (NewsInfo condition, int pageSize);
}
