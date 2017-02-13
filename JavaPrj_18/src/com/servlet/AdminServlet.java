

package com.servlet;

import java.io.*;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet 
{
    
       public void init() throws ServletException
       {
           super.init();
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

        ServletConfig config=getServletConfig();
        //����ServletConfig����
        String value=config.getInitParameter("name");
        //���·��
        Properties properties=new Properties();
        //�����ı� �������Դ
        properties.load(config.getServletContext().getResourceAsStream(value));
        // ��������ļ��е�name��pass��ֵ
      
       
        String name=properties.getProperty("name");
        String pass=properties.getProperty("pass");
        // �ӽ����л�ȡ�û������ֵ
        String username=request.getParameter("Username");
        String password= request.getParameter("password");
        // ����õ�ֵ�������ļ���ֵ���бȽ�
        if(username.equals(name)&&password.equals(pass))
        {
             request.getRequestDispatcher("adminMain.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("adminfaild.jsp").forward(request,response);
        }
               
            
   
         
    }

}
