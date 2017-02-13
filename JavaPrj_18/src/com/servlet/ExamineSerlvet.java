

package com.servlet;

import com.dao.DinDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class ExamineSerlvet extends HttpServlet 
{
    
        private Connection connection;
       public void init() throws ServletException
       {
           super.init();
           //������ݿ�����
           connection=JDBconne.getConnetion();
       }
       public void destroy()
       {
        super.destroy();
        //�ر����ݿ����� 
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
          DinDao dinDao=new DinDao();
          String id=(String)request.getSession().getAttribute("username");
          // ��ÿͻ��û��� ��ѯ�û����������к���
          ArrayList ary=dinDao.quest(connection,id);
          request.getSession().setAttribute("ary",ary);
          request.getRequestDispatcher("examineshopping.jsp").forward(request,response);

    }

}
