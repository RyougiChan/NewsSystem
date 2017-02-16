package com.news.action;

import java.util.List;
import java.util.Map;

import com.news.biz.AdminBiz;
import com.news.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	
	Map<String, Object> session;
	AdminBiz adminBiz;
	private String loginName;
	private String loginPwd;
	
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

	public String validateLogin() throws Exception {
		Admin admin = new Admin(loginName, loginPwd);
		List<Admin> list = (List<Admin>) adminBiz.login(admin);
		if (list.size() > 0) {
			session.put("admin", list.get(0));
		}
		return "index";
	}
	
}
