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
import com.entity.*;
import com.match.CheckDAO;
import com.page.*;

public class servletDetailPage extends HttpServlet {
	private ServletConfig config = null;					//���ò���
	private ReplyInfoDAO replyinfo_dao = new ReplyInfoDAO();//�ظ�DAO
	private TopicInfoDAO topicinfo_dao = new TopicInfoDAO();//����DAO
	private CheckDAO check_dao = new CheckDAO();			//У�鴦����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = config.getInitParameter("character");//��ó�ʼ������
		request.setCharacterEncoding(s);				//��ʾ��������ʽ
		response.setCharacterEncoding(s);				//������Ӧ�����ʽ
		response.setContentType("text/html");			//������Ӧ�ı�����
		PrintWriter out = response.getWriter();			//����������
		String action = (String) request.
								getParameter("action");	//���action����
		Integer tid = -1;								//��ʼ��������
		Integer sid = -1;								//��ʼ�������
		Integer rid = -1;								//��ʼ���ظ����
		Integer uid = -1;								//��ʼ���û����
		if ("showdetail".equals(action.toLowerCase())
				|| "showpage".equals(action.toLowerCase())) {
			tid = Integer.parseInt(
							request.getParameter("tid"));//���������
			sid = Integer.parseInt(
							request.getParameter("sid"));//��ð����
			List<DetailPage> replyList = replyinfo_dao
					.getReplyInfoAndUserInfoById(tid);	//��ûظ��б�
			DetailPage topicObj = topicinfo_dao
					.getTopicInfoAndUserInfoById(tid);	//���������Ϣ
			request.setAttribute("sid", sid);			//��������
			request.setAttribute("tid", tid);			//����������
			request.setAttribute(
					"replyListDetailPage", replyList);	//����ظ��б�
			request.setAttribute(
					"topicListDetailPage", topicObj);	//����������Ϣ
			request.getRequestDispatcher("detail.jsp").
							forward(request,response);//����ת����detail.jsp
		} else if ("edittopic".equals(action.toLowerCase())) {// ������޸����������ݡ�
			// ��ò���
			tid = Integer.parseInt(request.getParameter("tid"));
			sid = Integer.parseInt(request.getParameter("sid"));
			TopicInfo edittopic = topicinfo_dao.getEditTopicInfoById(tid);
			// ����request���������
			request.setAttribute("tid", tid);
			request.setAttribute("sid", sid);
			request.setAttribute("action", action);
			request.setAttribute("edittopic", edittopic);
			// ת��
			request.getRequestDispatcher("update.jsp").forward(request,
					response);

		} else if ("updatetopic".equals(action.toLowerCase())) {// ���޸����������ݡ�
			// ��ò���
			tid = Integer.parseInt(request.getParameter("tid"));
			sid = Integer.parseInt(request.getParameter("sid"));
			String title = (String) request.getParameter("title");
			String content = (String) request.getParameter("content");
			if (!check_dao.checkTopic(title)) {
				out.print("<script>" + "alert('���ⲻ��Ϊ��,������4-20');"
						+ "window.history.back();" + "</script>");
			} else if (!check_dao.checContents(content)) {
				out.print("<script>" + "alert('���ݲ���Ϊ�գ����ҳ��Ȳ�����100');"
						+ "window.history.back();" + "</script>");
			} else {
				Boolean result = topicinfo_dao.updateTopicInfoById(title,
						content, tid);
				// �ж��޸ĳɹ����
				if (result) {
					// ����request���������
					request.setAttribute("tid", tid);
					request.setAttribute("sid", sid);
					// ת��
					request.getRequestDispatcher(
							"servletDetailPage?tid=" + tid + "&sid=" + sid
									+ "&action=showDetail").forward(request,
							response);
				} else {
					out.print("<script>" + "alert('������æ��');"
							+ "window.history.back();" + "</script>");
				}
			}

		} else if ("editreply".equals(action.toLowerCase())) {// ������޸ĸ��������ݡ�
			// ��ò���
			tid = Integer.parseInt(request.getParameter("tid"));
			sid = Integer.parseInt(request.getParameter("sid"));
			rid = Integer.parseInt(request.getParameter("rid"));
			ReplyInfo editreply = replyinfo_dao.getEditReplyInfoById(rid);
			// ����request���������
			request.setAttribute("tid", tid);
			request.setAttribute("sid", sid);
			request.setAttribute("rid", rid);
			request.setAttribute("action", action);
			request.setAttribute("editreply", editreply);
			// ת��
			request.getRequestDispatcher("update.jsp").forward(request,
					response);

		} else if ("updatereply".equals(action.toLowerCase())) {// ���޸ĸ��������ݡ�
			// ��ò���
			tid = Integer.parseInt(request.getParameter("tid"));
			sid = Integer.parseInt(request.getParameter("sid"));
			rid = Integer.parseInt(request.getParameter("rid"));
			String title = (String) request.getParameter("title");
			String content = (String) request.getParameter("content");
			if (!check_dao.checContents(content)) {
				out.print("<script>" + "alert('���ݲ���Ϊ�գ����ҳ��Ȳ�����100');"
						+ "window.history.back();" + "</script>");
			} else {
				Boolean result = replyinfo_dao.updateReplyInfoById(title,
						content, rid);
				// �ж��޸ĳɹ����
				if (result) {
					// ����request���������
					request.setAttribute("tid", tid);
					request.setAttribute("sid", sid);
					// ת��
					request.getRequestDispatcher(
							"servletDetailPage?tid=" + tid + "&sid=" + sid
									+ "&action=showDetail").forward(request,
							response);
				} else {
					out.print("<script>" + "alert('������æ��');"
							+ "window.history.back();" + "</script>");
				}
			}

		} else if ("deltopic".equals(action.toLowerCase())) {// ������������ɾ��������������
			// ��ò���
			sid = Integer.parseInt(request.getParameter("sid"));
			tid = Integer.parseInt(request.getParameter("tid"));
			Boolean result = topicinfo_dao.delTopicInfoById(tid);
			// �ж�ɾ���ɹ����
			if (result) {
				// ����request���������
				request.setAttribute("tid", tid);
				request.setAttribute("sid", sid);
				// ת��
				request.getRequestDispatcher(
						"servletListPage?sid=" + sid + "&action=showDetail")
						.forward(request, response);
			} else {
				out.print("<script>" + "alert('������æ��');"
						+ "window.history.back();" + "</script>");
			}

		} else if ("delreply".equals(action.toLowerCase())) {// ��ɾ������������
			// ��ò���
			sid = Integer.parseInt(request.getParameter("sid"));
			tid = Integer.parseInt(request.getParameter("tid"));
			rid = Integer.parseInt(request.getParameter("rid"));
			Boolean result = replyinfo_dao.delReplyInfoById(rid);
			// �ж�ɾ���ɹ����
			if (result) {
				// ����request���������
				request.setAttribute("tid", tid);
				request.setAttribute("sid", sid);
				replyinfo_dao.getReplyCountById(tid, sid);
				// ת��
				request.getRequestDispatcher(
						"servletDetailPage?tid=" + tid + "&sid=" + sid
								+ "&action=showDetail").forward(request,
						response);
			} else {
				out.print("<script>" + "alert('������æ��');"
						+ "window.history.back();" + "</script>");
			}

		} else if ("reply".equals(action.toLowerCase())) {//��������
			sid = Integer.parseInt(request.getParameter("sid"));//�����
			tid = Integer.parseInt(request.getParameter("tid"));//������
			uid = Integer.parseInt(request.getParameter("uid"));//�û����
			String title = (String) request.getParameter("title");//�ظ�����
			String content = (String) request.getParameter("content");//�ظ�����
			if (!check_dao.checContents(content)) {//У��ظ������Ƿ�Ϸ�
				out.print("<script>" + "alert('���ݲ���Ϊ�գ����ҳ��Ȳ�����100');"
						+ "window.history.back();" + "</script>");
			} else {
				Boolean result = replyinfo_dao.insertReplyInfo(
						title, content,tid, sid, uid);//ִ�в������
				if (result) {	//����ɹ�
					request.setAttribute("tid", tid);	//����������
					request.setAttribute("sid", sid);	//��������
					replyinfo_dao.getReplyCountById(tid, sid);//��ûظ���Ŀ
					request.getRequestDispatcher(		//��ת��������ϸ����ҳ
					"servletDetailPage?tid=" + tid + "&sid=" + sid
					+ "&action=showDetail").forward(request,response);
				} else {
					out.print("<script>" + "alert('������æ��');"
							+ "window.history.back();" + "</script>");
				}
			}
		} else if ("post".equals(action.toLowerCase())) {//��������
			sid = Integer.parseInt(request.getParameter("sid"));//�����
			uid = Integer.parseInt(request.getParameter("uid"));//�û����
			String title = (String) request.getParameter("title");//�������
			String content = (String) request.getParameter("content");//��������
			if (!check_dao.checkTopic(title)) {//У����������Ƿ�Ϸ�
				out.print("<script>" + "alert('���ⲻ��Ϊ��,������4-20');"
						+ "window.history.back();" + "</script>");
			} else if (!check_dao.checContents(content)) {//У�����������Ƿ�Ϸ�
				out.print("<script>" + "alert('���ݲ���Ϊ�գ����ҳ��Ȳ�����100');"
						+ "window.history.back();" + "</script>");
			} else {
				Boolean result = topicinfo_dao.
					insertTopicInfo(title, content,sid, uid);//ִ�в������
				if (result) {//����ɹ�
					request.setAttribute("sid", sid);		//��������
					topicinfo_dao.getTopicCountById(sid);	//ȡ�ð����������
					request.getRequestDispatcher("servletListPage?sid=" 
						+ sid).forward(request, response);//��ת�������б�ҳ��
				} else {
					out.print("<script>" + "alert('������æ��');"
							+ "window.history.back();" + "</script>");
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}
