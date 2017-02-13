package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ManagerDAO;
import com.dao.UserInfoDAO;
import com.entity.UserInfo;
import com.match.CheckDAO;
import com.sun.corba.se.spi.activation.Repository;

public class ServletManager extends HttpServlet {

	private ServletConfig config = null;
	private ManagerDAO manager_dao = new ManagerDAO();
	private CheckDAO check_dao = new CheckDAO();
	private UserInfo mUser = null;
	private UserInfoDAO udao = new UserInfoDAO();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");			//������������ʽ
		response.setCharacterEncoding("gb2312");		//������Ӧ��Ÿ�ʽ
		response.setContentType("text/html");			//������Ӧ�ı�����
		PrintWriter out = response.getWriter();			//�����Ӧ�����
		String action = request.getParameter("action");	//���action����
		if ("add".equals(action.toLowerCase())) {		//��Ӱ��
			Integer sParentId = Integer
				.parseInt(request.getParameter("select"));//��ø������
			Integer sType = Integer
				.parseInt(request.getParameter("sType"));//��ð������
			String sName = request.getParameter("sName").trim();//��ð������
			String uName = request.getParameter("uName").trim();//��ð����û���
			if (sType == 0) {							//��̳���
				sParentId = 0;							//�����丸�����Ϊ0
			} else if (sType == 1) {					//��̳�Ӱ��
				if (sParentId == -1) {					//����������Ϊ-1
					out.print("<script>" + "alert('��ѡ����̳���������');"
							+ "window.history.back();" + "</script>");
					return;								//�����Ի�����ʾ
				}
			}
			if (check_dao.checkSectionName(sName)) {	//��֤�������
				if(check_dao.checkUserNameIsExist(uName)) {//��֤�����û���
					Boolean flag = manager_dao.
						addSection(sParentId, sName,uName);//ִ���������
					if (!flag) {						//���ʧ��
						out.print("<script>" + "alert('���ʧ��');"
						+ "window.history.back();" + "</script>");
					} else {							//��ӳɹ�
						response.sendRedirect("manager/addSection.jsp");
					}
				}else {
					out.print("<script>" + "alert('���û������ڣ�����ָ��Ϊ����');"
						+ "window.history.back();" + "</script>");
				}
			} else {
				out.print("<script>" + "alert('��̳���Ƴ���Ϊ3-20');"
						+ "window.history.back();" + "</script>");
			}
	
		} else if ("edit".equals(action.toLowerCase())) {
			Integer sId = Integer.
						parseInt(request.getParameter("sid"));	//��ð����
			String sName = request.getParameter("sName");		//��ð������
			String uName = request.getParameter("uName").trim();//��ð����û���
			out.println(sName);
			if (check_dao.checkSectionName(sName)) {			//��֤�����
				if(check_dao.checkUserNameIsExist(uName)) {		//��֤�����û���
					Boolean flag = manager_dao.
						updateSectionInfoById(sId, sName,uName);//ִ�и���
					if (!flag) {								//�޸�ʧ��
						out.print("<script>" + "alert('�޸�ʧ��');"
								+ "window.history.back();" + "</script>");
					} else {									//�޸ĳɹ�
						response.sendRedirect("manager/managerSection.jsp");
					}
				}else{
					out.print("<script>" + "alert('���û������ڣ�����ָ��Ϊ����');"
							+ "window.history.back();" + "</script>");
				}
			} else {
				out.print("<script>" + "alert('��̳���Ƴ���Ϊ3-20');"
						+ "window.history.back();" + "</script>");
			}
		
			} else if ("del".equals(action.toLowerCase())) {
				Integer sid = Integer.parseInt(request.getParameter("sid"));
				if (!manager_dao.isHaveChildNode(sid)) {// �����鲻�����ӽڵ�
					Boolean flag = manager_dao.delSectionInfo(sid);
					if (!flag) {// ɾ��ʧ��
						out.print("<script>" + "alert(\'ɾ��ʧ��\');" + "</script>");
					} else {// ɾ���ɹ�
						response.sendRedirect("manager/managerSection.jsp");
					}
				} else {
					out.print("<script>" + "alert(\'�ð�麬���Ӱ�飬����ɾ��\');"
							+ "window.history.back();" + "</script>");
				}
			} else if ("move".equals(action.toLowerCase())) {
			Integer moveType = Integer.parseInt(request
					.getParameter("moveType"));
			Integer sourceSid = Integer
					.parseInt(request.getParameter("source"));
			Integer targetSid = Integer
					.parseInt(request.getParameter("target"));
			if (moveType == 0) {
				Boolean flag = manager_dao.moveToChildSectionInfoById(
						sourceSid, targetSid);
				if (!flag) {// �ƶ�ʧ��
					out.print("<script>" + "alert('�ƶ�ʧ��\\n���ܰ�������ΪĿ�����ƶ�');"
							+ "window.history.back();" + "</script>");
				} else {// �ƶ��ɹ�
					response.sendRedirect("manager/welcome.htm");
				}
			}
			if (moveType == 1) {
				Boolean flag = manager_dao.moveToRootSectionInfoById(sourceSid);
				if (!flag) {// �ƶ�ʧ��
					out.print("<script>" + "alert('�ƶ�ʧ��');"
							+ "window.history.back();" + "</script>");
				} else {// �ƶ��ɹ�
					response.sendRedirect("manager/welcome.htm");
				}
			}

		} else if ("login".equals(action.toLowerCase())) {
			String userName = request.getParameter("uName");
			String passWord = request.getParameter("uPass");
			
			if (udao.checkLogin(userName, passWord)) {
				mUser = udao.getUserInfo(userName);
				HttpSession session = request.getSession();// �û���¼�Ự��ʼ
				session.setAttribute("mUsers", mUser);
				response.sendRedirect("manager/index.jsp");
			}else{
				out.print("<script>" + "alert('�������');"
						+ "window.history.back();" + "</script>");
			}
			
		}else if ("exit".equals(action.toLowerCase())) {
			HttpSession session = request.getSession();// ��ûỰ
			session.invalidate();//�رջỰ
			response.sendRedirect("index.jsp");
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
