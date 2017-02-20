package com.news.interceptor;

import java.util.Map;

import com.news.entity.Admin;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AdminLoginInterceptor extends MethodFilterInterceptor {
	

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		ActionContext actionContext = invocation.getInvocationContext();
		Map<String, Object> session = actionContext.getSession();
		
		Admin admin = (Admin) session.get("admin");
		if (admin != null) {
			return invocation.invoke();
		}
		actionContext.put("notice", "您还未登录，无法获得管理员权限");
		return Action.LOGIN;
		
	}


}
