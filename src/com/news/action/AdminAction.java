package com.news.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.news.biz.AdminBiz;
import com.news.biz.NewsInfoBiz;
import com.news.biz.TopicBiz;
import com.news.entity.Admin;
import com.news.entity.NewsInfo;
import com.news.entity.Pager;
import com.news.util.AdminUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware,SessionAware {

	Map<String, Object> request;
	Map<String, Object> session;
	AdminBiz adminBiz;
	NewsInfo newsInfo;
	TopicBiz topicBiz;
	NewsInfoBiz newsInfoBiz;
	Pager pager;
	
	private String loginName;
	private String loginPwd;
	
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public AdminBiz getAdminBiz() {
		return adminBiz;
	}

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	@SuppressWarnings("unchecked")
	public String validateLogin() throws Exception {
		
		int curPage = 1;
		Pager pager8 = null;
		List<NewsInfo> newsInfos8 = null;
		
		Admin admin = new Admin(loginName, loginPwd);
		List<Admin> list = (List<Admin>) adminBiz.login(admin);
		HttpServletRequest req = ServletActionContext.getRequest();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		if (list.size() > 0) {
			if (pager != null) {
				curPage = pager.getCurPage();
			}
			
			if (newsInfo == null) {
				pager = newsInfoBiz.getPagerOfAllNewsInfo(8);
				newsInfos8 = (List<NewsInfo>) newsInfoBiz.getAllNewsInfoByPage(curPage, 8);
			} else {
				pager = newsInfoBiz.getPagerOfNewsInfo(newsInfo, 8);
				newsInfos8 = (List<NewsInfo>) newsInfoBiz.getNewsInfoByConditionAndPage(newsInfo, curPage, 8);
			}
			pager8 = pager;
			pager8.setCurPage(curPage);
			session.put("topicList", topicBiz.getAllTopics());
			session.put("newsInfoList8", newsInfos8);
			session.put("pager8", pager8);
			session.put("loaded", "success");
			session.put("admin", list.get(0));
			session.put("ip", AdminUtil.getIpAddr(req));
			session.put("time", df.format(new Date()));
			return "index";
		} else {
			request.put("notice", "Account/Password is mismatched");
			return "login";
		}
	}
	
}
