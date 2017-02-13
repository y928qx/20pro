package com.sanqing.course.web;

/**
 * 
 */

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


/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserLoginFilter implements Filter {


    /**   
     * ��������Ľ�ɫ   
     */   
    //private String allowRole = null;    
   
    /**   
     * �ض����URL   
     */   
    private String redirectURl = null;    
   
    public void init(FilterConfig filterConfig) throws ServletException {    
       
    	//�õ�����Ľ�ɫ,�����������web.xml���allowRole��ָ��    
        //allowRole = filterConfig.getInitParameter("allowRole");    
        
        //ָ��Ҫ�ض����ҳ��    
        redirectURl = "logon.jsp";    
    }    
   
    /**   
     * �ڹ�������ʵ��Ȩ�޿���   
     */   
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,    
            FilterChain filterChain) throws IOException, ServletException {    
        
    	HttpServletRequest request = (HttpServletRequest) sRequest;    
        HttpServletResponse response = (HttpServletResponse) sResponse;    
        HttpSession session = request.getSession();    
        
        String p = request.getParameter("p");
   
        // ����ػ��е��û�Ϊ��,ҳ�����¶��򵽵�¼ҳ��    
        if(session.getAttribute("logon") == null) {
        	if(p.equals("logon")) {
        		filterChain.doFilter(sRequest, sResponse);
        	} else {
            	response.sendRedirect(redirectURl);   
        	}
        } else {
        	filterChain.doFilter(sRequest, sResponse);
        }
    }    
   
    public void destroy() {    
    }  
}
