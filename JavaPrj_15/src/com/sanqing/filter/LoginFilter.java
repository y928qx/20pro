package com.sanqing.filter;

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

public class LoginFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		HttpServletResponse response = (HttpServletResponse) res;
		String uri = request.getRequestURI();
		//����û�������index.html����ʱ�ͱ�������¼�жϣ��ж��û��Ƿ��¼��
		if("/Pfms/index.html".equals(uri)) {
			if(username == null || "".equals(username)) {
				response.sendRedirect("login.html");
			} else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
