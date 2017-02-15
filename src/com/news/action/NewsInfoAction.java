package com.news.action;

import java.util.List;
import java.util.Map;

import com.news.biz.NewsInfoBiz;
import com.news.biz.TopicBiz;
import com.news.entity.NewsInfo;
import com.news.entity.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class NewsInfoAction extends ActionSupport {
	
	Map<String, Object> request;
	NewsInfo newsInfo;
	TopicBiz topicBiz;
	NewsInfoBiz newsInfoBiz;
	Pager pager;
	
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public NewsInfo getNewsInfo() {
		return newsInfo;
	}
	
	public void setNewsInfo(NewsInfo newsInfo) {
		this.newsInfo = newsInfo;
	}
	
	public TopicBiz getTopicBiz() {
		return topicBiz;
	}

	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	
	public NewsInfoBiz getNewsInfoBiz() {
		return newsInfoBiz;
	}

	public void setNewsInfoBiz(NewsInfoBiz newsInfoBiz) {
		this.newsInfoBiz = newsInfoBiz;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	/**
	 * Get news list according to the query condition and page,
	 * And then dispatch to index page.
	 * @return struts action result name, get right response .jsp page according to this result.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String index() throws Exception {
		int curPage = 1;
		List<NewsInfo> newsInfos = null;
		
		if (pager != null) {
			curPage = pager.getCurPage();
		}
		
		if (newsInfo == null) {
			newsInfos = (List<NewsInfo>) newsInfoBiz.getAllNewsInfoByPage(curPage, 10);
			pager = newsInfoBiz.getPagerOfAllNewsInfo(10);
		} else {
			newsInfos = (List<NewsInfo>) newsInfoBiz.getNewsInfoByConditionAndPage(newsInfo, curPage, 10);
			pager = newsInfoBiz.getPagerOfNewsInfo(newsInfo, 10);
		}

		System.out.println("DEBUG --------- ");
		System.out.println(newsInfos.size());
		System.out.println(newsInfos);
		pager.setCurPage(curPage);
		request.put("newsInfoList", newsInfos);
		request.put("topicList", topicBiz.getAllTopics());
		
		return "index";
	}
	
}
