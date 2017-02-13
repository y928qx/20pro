

package com.servlet;

import com.dao.DinDao;
import com.dao.Sched;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;


import javax.servlet.*;
import javax.servlet.http.*;

public class AffirmServlet extends HttpServlet 
{
       private Connection connection;
       public void init() throws ServletException
       {
           super.init();
           connection=JDBconne.getConnetion();
       }
       public void destroy()
       {
        super.destroy();
        JDBconne.closeConnection();
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    { 
             response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
            DinDao din=new DinDao();
            Sched sch=new Sched();
            //��JSPҳ���л�ȡ��ѡ��ĺ����
            String hao=request.getParameter("hao");
           // check ��ѯ��ѡ�񺽰����Ϣ
            sch=din.check(connection,hao);
            // ��ú����ƱƱ��
            int value=sch.getPiaosu();
            // ��JSPҳ�����������˵�����ѡ��Ʊ��
            String[] abc=new String[value];
            for(int i=0;i<value;i++)
            {
                abc[i]=String.valueOf(i+1);
            }
            request.getSession().setAttribute("abc",abc);
            request.getSession().setAttribute("sch",sch);
            // ��ø�ϵͳ�иú����Ʊ��,�������0 �򲻿���Ʊ
            if(sch.getPiaosu()==0)
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfailder.jsp");
	        dispatcher.forward(request, response);

            }
            if(sch.getPiaosu()>0)// �������0 �������Ʊ
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("affirmflight.jsp");
	    dispatcher.forward(request, response);

            }
            
    
      

    }

}
