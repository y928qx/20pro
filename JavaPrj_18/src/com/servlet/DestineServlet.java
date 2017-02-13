

package com.servlet;

import com.dao.SchedDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class DestineServlet extends HttpServlet 
{
    private Connection connection;

    public void init() throws ServletException
    {
        super.init();
	connection = JDBconne.getConnetion();
    }
       public void destroy()
       {
        super.destroy();
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String param=request.getParameter("param");
       
        SchedDao schedDao=new SchedDao();

        if(param.equalsIgnoreCase("1"))
        {
            //descry �����Ч�������Ϣ ��������Ϣ����ArrayList��̬������
            // ArrayList��̬���������JSPҳ������c:forEach ѭ�����д�ӡ
            ArrayList sched=schedDao.descry(connection);
            request.getSession().setAttribute("sched",sched);
            request.getRequestDispatcher("destineflight.jsp").forward(request,response);
        }
        else if(param.equalsIgnoreCase("2"))
        {
            // quest ��������ƶ��������Ϣ
            ArrayList sched=schedDao.quest(connection);
            request.getSession().setAttribute("sched",sched);
            request.getRequestDispatcher("examFlight.jsp").forward(request,response);
        }
       
        
        
         
    }

}
