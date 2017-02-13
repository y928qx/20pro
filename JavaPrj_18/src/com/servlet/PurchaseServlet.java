

package com.servlet;

import com.dao.DinDao;
import com.dao.Sched;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class PurchaseServlet extends HttpServlet 
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
             response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
            DinDao din=new DinDao();  
            // ��ú�����Ϣ
            Sched sch=(Sched)request.getSession().getAttribute("sch");
            // ����û�����Ʊ��
            int bal=Integer.parseInt(request.getParameter("piao"));
            // ����û���
            String id=(String) request.getSession().getAttribute("username");
            // inset �����û������򺽰�Ʊ����Ϣ
           int value=din.inset(connection,sch,bal,id);
           if(value>0) //�жϲ����Ƿ�ɹ�
           {
               // ����ɹ�  update�޸ĸú����Ʊ��
                 int wat=din.update(connection,sch,bal);
                 if(wat > 0)
		 {	
			RequestDispatcher dispatcher = request.getRequestDispatcher("ExamineSerlvet");
			dispatcher.forward(request, response);
		 }
		 else
		 {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfaild.jsp");
			dispatcher.forward(request, response);
		 }
         }
         else
         {
               // ����ʧ��
             RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfaild.jsp");
			dispatcher.forward(request, response);
         }
         

    }

}
