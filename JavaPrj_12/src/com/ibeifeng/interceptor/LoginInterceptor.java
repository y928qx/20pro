package com.ibeifeng.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		String result = null;
		System.out.println(username);
		
		if(username != null && !"".equals(username)) {
			 result = invocation.invoke();//����������һ��������������Action
		} else {
			return Action.LOGIN;
		}
		return result;
	}
}
