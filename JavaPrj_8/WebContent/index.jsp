<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ page import="java.util.*,com.dao.*,com.page.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>��ӭ������̳��ҳ</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gbk">
		<Link rel="stylesheet" type="text/css" href="style/style.css" />
	</HEAD>
	<BODY>
		<DIV>
		</DIV>
		<DIV class="h">
			<%@ include file="showLogin.jsp" %>
		</DIV>
		<%
			List<SectionInfo> listParent = null;		//������б�
			List<SectionInfo> listChild = null;			//�Ӱ���б�
			int sParentId = 0;							//�������
			int sId = 0;								//�Ӱ����
			int tId = 0;								//���ӱ��
			SectionInfoDAO section_dao = new SectionInfoDAO();//���DAO
			TopicInfoDAO topic_dao = new TopicInfoDAO();	//����DAO
			ReplyInfoDAO reply_dao = new ReplyInfoDAO();	//�ظ�DAO
		%>		
		<DIV class="t">
		<%
			listParent = section_dao.getSectionById(0);
			for (int i = 0; i < listParent.size(); i++) {
		%>
		<TABLE cellSpacing="0" cellPadding="0" width="100%">
			<TR class="tr2" align="center">
				<TD colSpan="2">��̳</TD>
				<TD style="WIDTH: 10%">����</TD>
				<TD style="WIDTH: 30%">��󷢱�</TD>
			</TR>
			<TR class="tr3">
				<TD colspan="4">
					<a href="servletListPage?sid=<%=listParent.get(i).getSid() %>">
					<%=listParent.get(i).getSname()%></a>
				</TD>
			</TR>
			<%
			sParentId = listParent.get(i).getSid();		//��ø������
			listChild = section_dao.getSectionById(sParentId);//������������Ӱ��
			for (int j = 0; j < listChild.size(); j++) {//�����Ӱ���б�
			%>
			<TR class="tr3">
				<TD width="5%">&nbsp;</TD>
				<TH align="left"><IMG src="image/board.gif">
					<A href="servletListPage?sid=<%=listChild.get(j).getSid()%>">
					<%=listChild.get(j).getSname()%></A>
				</TH>
				<TD align="center">
					<%=listChild.get(j).getStopiccount()%>
				</TD>
				<TH>
				<%
				IndexPage temp1 = null;			//�������¼
				IndexPage temp2 = null;			//��������¼
				sId= listChild.get(j).getSid();	//��ð����
				temp1 = topic_dao.getALLTopicLastTimeById(sId);//����������¼
				if (temp1 != null) {
					tId = temp1.getTid();		//������ӱ��
					temp2 = reply_dao.
						getAllReplyLastTimeById(sId,tId);//����������ļ�¼
					if(temp2 != null){
				%>
					<SPAN><A href="servletDetailPage?tid=<%=temp2.getTid()%>
					&sid=<%=sId%>&action=showDetail"><%=temp2.getTitle()%></A></SPAN>
					<BR/>
					<SPAN><%=temp2.getAuthor()%></SPAN>
					<SPAN class="gray">
					[ <%=CommonDAO.getDateFormat(temp2.getPublishtime())%> ]</SPAN>
				<%	}else{
				%>
					<SPAN><A href="servletDetailPage?tid=<%=temp1.getTid()%>
					&sid=<%=sId%>&action=showDetail"><%=temp1.getTitle()%></A></SPAN>
					<BR/>
					<SPAN><%=temp1.getAuthor()%></SPAN>
					<SPAN class="gray">
					[ <%=CommonDAO.getDateFormat(temp1.getPublishtime())%> ]</SPAN>
				<%
					}			
				}else{
				%>
					<SPAN>��δ</SPAN>
				<%	
				}
				%>
				</TH>
			</TR>
			<%
			}
			%>
		</TABLE>
		<%
			}
		%>
		</DIV>

		<BR />
		<CENTER class="gray"> 
			��Ȩ��Ϣ 
		</CENTER>
	</BODY>
</HTML>