package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.page.*;

public class servletListPage extends HttpServlet {
	private ServletConfig config = null;				//��ʼ������
	private TopicInfoDAO dao = new TopicInfoDAO();		//����DAO
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = config.getInitParameter("character");//��ó�ʼ������
		request.setCharacterEncoding(s);				//��ʾ��������ʽ
		response.setCharacterEncoding(s);				//������Ӧ�����ʽ
		response.setContentType("text/html");			//������Ӧ�ı�����
		Integer sid = Integer.parseInt(
						request.getParameter("sid"));	//��ð���Ų���
		List<ListPage> list = dao.getTopicInfoById(sid);//��ѯ�ð������������
		request.setAttribute("sid", sid);				//������ű��浽request��Χ
		request.setAttribute("listPage", list);			//�������б��浽request��Χ
		request.getRequestDispatcher("list.jsp").
							forward(request, response);	//ִ������ת��
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);					//����doGet����
	}
	public void init(ServletConfig config) throws ServletException {
		this.config = config;							//��ó�ʼ��������Ϣ
	}
}
