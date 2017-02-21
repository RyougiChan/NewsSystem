package com.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {

	HttpServletRequest req = null;
	HttpServletResponse resp = null;
	HttpSession session;
	String reqHeader = "";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		this.req = (HttpServletRequest) request;
		this.resp = (HttpServletResponse) response;
		this.session = req.getSession();
		// 获取父级url，如不存在则为直接输入url
		reqHeader = req.getHeader("REFERER");
		if ("".equals(reqHeader) || null == reqHeader) {
			if (session.getAttribute("admin") == null) {
				session.setAttribute("notice", "You have no enough permissions to visit this page. Please login.");
				resp.sendRedirect("/NewsSystem/login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
		
	}

}
