<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*,com.page.*,com.dao.*,com.entity.*"%>
<%
	SectionInfoDAO section_dao = new SectionInfoDAO();
	TopicInfoDAO topic_dao = new TopicInfoDAO();
	ReplyInfoDAO reply_dao = new ReplyInfoDAO();
	
	//���������������
	List<ListPage> list = (List<ListPage>)request.getAttribute("listPage");
	Integer sid = (Integer)request.getAttribute("sid");
	List<SectionInfo> sectionInfoList = section_dao.getSectionById(sid);
	
	//����pageCoontex���� 
	pageContext.setAttribute("page_sid",sid);
	
	//��ʼ����ҳ����
	Integer currPage = 1;//Ĭ��ѡ���һҳ
	Integer recordConut = 0;//��¼����
	Integer PageCount = 0;//��ҳ����ҳ��
	Integer pageNum  = 10;//ÿҳ��ʾ�ļ�¼��
	Integer startIndex = 0;//��ʼ����
	Integer endIndex = 0;//��������
	Integer nextPage = 0;
	Integer PreviousPage = 0;
	
	//����������ķ�ҳ����
	String action = request.getParameter("action");
	
%>
<%-- ʵ�ַ�ҳ ��Ҫ����һ ��ʼ --%>
<%
	recordConut = list.size();
	//int result = recordConut % pageNum;
	
	//if(result != 0){//��÷�ҳ����ҳ��
		//PageCount = (recordConut / pageNum) + 1;
	//}else if(result == 0){
		//PageCount = (recordConut / pageNum); 
	//}
	PageCount = (recordConut + (pageNum-1))/pageNum;//��÷�ҳ����ҳ��
	
	if(action != null && "showpage".equals(action.toLowerCase())){//��õ�ǰѡ���ҳ��
	
		//��ҳ���Ƿ����ֵ�ʱ�򣬾�ת�����һҳ
		String str = (String)request.getParameter("currPage");
		if(str.matches("(\\+|\\-){0,1}[0-9]{0,9}")){
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}else{
			currPage = PageCount;
		}
		
		//���ơ���һҳ�� ����һҳ�� �����½���
		if (currPage <= 1) {
			currPage = 1;
		}
		if(currPage >= PageCount){
			currPage = PageCount;
		}
	}
	//
	endIndex = (currPage * pageNum) - 1;//��÷�ҳ��������
	//
	//���õ����һҳ��ʱ�򣬸ı��������
	if(currPage == PageCount){
		if(endIndex > recordConut){
			if(recordConut == endIndex-1){
				endIndex -= 1;
				startIndex = (currPage-1) * pageNum;
			}else{
			 	//int offset = (endIndex - recordConut) + 1;
				//endIndex -= offset;
				//startIndex = endIndex;
				endIndex = recordConut - 1;
				startIndex = (currPage-1) * pageNum;
			}
		}else{
			startIndex = ++endIndex - pageNum;
			endIndex = --recordConut;
		}
	}else if(endIndex > recordConut - 1){
		endIndex -= 1;
		startIndex = 0;
	}else{
		startIndex = endIndex - pageNum + 1 ;//��÷�ҳ��ʼ����
	}
	
	//�������ҳ��ҳ��
	PreviousPage = currPage;
	nextPage  = currPage;
%>
<%-- ʵ�ַ�ҳ ��Ҫ����һ ���� --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>��ҵ��̳--�����б�</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<DIV>
</DIV>
<!--      �û���Ϣ����¼��ע��        -->

<DIV class="h">
<%@ include file="showLogin.jsp" %>
</DIV>


<!--      ����        -->
<DIV>
<!--      ����        -->
<br/>
<DIV>
	&gt;&gt;<B><a href="index.jsp">��̳��ҳ</a></B><%@ include file="navigation.jsp" %>
</DIV>
<br/>
<%
	if(!section_dao.isParentById(sid)){
%>
<!--      ����        -->
	<DIV>
		<A href="post.jsp?tid=0&sid=<%=sid%>&action=post"><IMG src="image/post.gif" name="td_post" border="0" id=td_post></A>
	</DIV>
<!--         �� ҳ         -->
	<DIV class = "pages">
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=--PreviousPage%>">��һҳ</a>&nbsp;|&nbsp; 
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=++nextPage%>">��һҳ</a>&nbsp;|&nbsp;
	<%
		if(PageCount > 0){
	%>
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=1"><<</a>&nbsp;
	<%-- ʵ�ַ�ҳ ��Ҫ����� ��ʼ	ֻ��ʾx��ҳ�뵼����ť --%>
	<%
		 Integer x  = 3;//���Ʒ�ҳ������ť��ʾ�ĸ���
		 if(x > PageCount){//��ֹ x ������ҳ��ҳ��
		 	x = PageCount;
		 }
		
		Integer pageNavigationStartIndex = 1;//��ҳ������ť��ʼ����
		Integer pageNavigationEndIndex = x+1;//��ҳ������ť��������
		
		if(PageCount == 1){
		 	pageNavigationStartIndex = 1;
		 	pageNavigationEndIndex = 2;
		 }
		 else
		if(currPage <= 1){//���ѡ������ǰһҳ
			pageNavigationStartIndex = 1;
		}
		else
		if(currPage >= PageCount){//���ѡ�������һҳ
			pageNavigationStartIndex = PageCount - (x-(x-1)) ;//��ҳ������ʼ����
			pageNavigationEndIndex = PageCount + 1;//��ҳ������������
		}
		else
		if(currPage >= x+1 && currPage < PageCount){//���ѡ������ǰһҳ�����һҳ֮�������
			pageNavigationEndIndex = currPage+1;
			pageNavigationStartIndex = pageNavigationEndIndex - x;
		}
	%>
	<%-- ʵ�ַ�ҳ ��Ҫ����� ���� --%>
	
	<%-- ʵ�ַ�ҳ ��ӡ����һ ��ʼ --%>
	<%
		for(int i = pageNavigationStartIndex; i < pageNavigationEndIndex; i++){
	%>
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=i%>"><%=i%></a>&nbsp;
	<%
		} 
	%>
	<%-- ʵ�ַ�ҳ ��ӡ����һ ���� --%>
		<input style="width: 30px;height: 14px" type="text" onkeydown="javascript: if(event.keyCode==13){ location='servletListPage?&sid=<%=sid%>&action=showPage&currPage='+this.value+'';return false;}" \>
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=PageCount%>">>></a>&nbsp;
		Pages:&nbsp;(&nbsp;<%=currPage %>&nbsp;/&nbsp;<%=PageCount %>&nbsp;total&nbsp;)
		&nbsp; 
	<%
		}
	%>
	</DIV>
<%
	} 
%>
<!-- �Ӱ�� -->
<%
	if(sectionInfoList.size()>0){ 
%>
<DIV class="t">
			
			<TABLE cellSpacing="0" cellPadding="0" width="100%">
			<TR>
				<TH class="h" style="WIDTH: 100%" colSpan="4"><SPAN>&nbsp;�Ӱ��</SPAN></TH>
			</TR>
				<TR class="tr2" align="center">
					<TD colSpan="2">
						��̳
					</TD>
					<TD style="WIDTH: 10%">
						����
					</TD>
					<TD style="WIDTH: 30%">
						��󷢱�
					</TD>
				</TR>
				<!--       �Ӱ��      -->
				<%--���ѭ��	��ʼ--%>
				<%
						for (int i = 0; i < sectionInfoList.size(); i++) {
				%>
				<TR class="tr3">
					<TD width="5%">
						&nbsp;

					</TD>
					<Td align="left">
						<IMG src="image/board.gif">
						<A href="servletListPage?sid=<%=sectionInfoList.get(i).getSid()%>"><%=sectionInfoList.get(i).getSname()%></A>						
					</Td>
					<TD align="center">
						<%=sectionInfoList.get(i).getStopiccount()%>
					</TD>
					
				<TH>
						<%
							Integer tId=0,sId=0;
							IndexPage temp1 = null;
							IndexPage temp2 = null;
							sId= sectionInfoList.get(i).getSid();
							//���ͬһ�����������������ļ�¼
							temp1 = topic_dao.getALLTopicLastTimeById(sId);
							if (temp1 != null) {
								//���ͬһ������������������ļ�¼
								tId = temp1.getTid();
								temp2 = reply_dao.getAllReplyLastTimeById(sId,tId);
								if(temp2 != null){
							%>
							<%--��ʾͬһ������������������ļ�¼--%>
						<SPAN><A href="servletDetailPage?tid=<%=temp2.getTid()%>&sid=<%=sId%>&action=showDetail"><%=temp1.getTitle()%></A> </SPAN>
						<BR/>
						<SPAN><%=temp2.getAuthor()%></SPAN>
						<SPAN class="gray">[ <%=CommonDAO.getDateFormat(temp2.getPublishtime())%> ]</SPAN>
						
						<%		}else{
						%>
							<%--��ʾͬһ�����������������ļ�¼--%>
						<SPAN><A href="servletDetailPage?tid=<%=temp1.getTid()%>&sid=<%=sId%>&action=showDetail"><%=temp1.getTitle()%></A></SPAN>
						<BR/>
						<SPAN><%=temp1.getAuthor()%></SPAN>
						<SPAN class="gray">[ <%=CommonDAO.getDateFormat(temp1.getPublishtime())%> ]</SPAN>
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
				<%--���ѭ��	����--%>
			</TABLE>
			
			
		</DIV>
<%
	} 
%>
<%
	if(!section_dao.isParentById(sid)){ 
%>
<!-- ���� -->

	<DIV class="t">
		<TABLE cellSpacing="0" cellPadding="0" width="100%">		
			<TR>
				<TH class="h" style="WIDTH: 100%" colSpan="4">
				<SPAN>&nbsp;��ҵ��̳</SPAN></TH>
			</TR>
		<%
			if(list==null||list.size()==0){
		%>
		<tr class="tr3">
			<td colspan="4">�������ݣ�</td>
		</tr>
		<%
			}else{
		%>
			<TR class="tr2">
				<TD>&nbsp;</TD>
				<TD style="WIDTH: 80%" align="center">����</TD>
				<TD style="WIDTH: 10%" align="center">����</TD>
				<TD style="WIDTH: 10%" align="center">�ظ�</TD>
			</TR>
		<%
			if(recordConut > 0){//�����¼������0
				for(int i = startIndex; i <= endIndex; i++){//���б���
		%>
			<TR class="tr3">
				<TD><IMG src="image/topic.gif" border=0></TD>
				<TD style="FONT-SIZE: 15px">
					<A href="servletDetailPage?tid=<%=list.get(i).getTid()%>
					&sid=<%=sid%>&action=showDetail">
					<%=list.get(i).getTitle()%></A>
				</TD>
				<TD align="center"><%=list.get(i).getAuthor()%></TD>
				<TD align="center"><%=list.get(i).getReplycount()%></TD>
			</TR>
		<%
				}
			} 
		}
		%>
		</TABLE>
	</DIV>
	
<!--         �� ҳ         -->
	<DIV class = "pages">
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=PreviousPage%>">��һҳ</a>&nbsp;|&nbsp; 
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=nextPage%>">��һҳ</a>&nbsp;|&nbsp;
	<%
		if(PageCount > 0){
	%>
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=1"><<</a>&nbsp;
	<%-- ʵ�ַ�ҳ ��Ҫ����� ��ʼ	ֻ��ʾx��ҳ�뵼����ť --%>
	<%
		 Integer x  = 3;//���Ʒ�ҳ������ť��ʾ�ĸ���
		 if(x > PageCount){//��ֹ x ������ҳ��ҳ��
		 	x = PageCount;
		 }
		
		Integer pageNavigationStartIndex = 1;//��ҳ������ť��ʼ����
		Integer pageNavigationEndIndex = x+1;//��ҳ������ť��������
		
		if(PageCount == 1){
		 	pageNavigationStartIndex = 1;
		 	pageNavigationEndIndex = 2;
		 }
		 else
		if(currPage <= 1){//���ѡ������ǰһҳ
			pageNavigationStartIndex = 1;
		}
		else
		if(currPage >= PageCount){//���ѡ�������һҳ
			pageNavigationStartIndex = PageCount - (x-(x-1)) ;//��ҳ������ʼ����
			pageNavigationEndIndex = PageCount + 1;//��ҳ������������
		}
		else
		if(currPage >= x+1 && currPage < PageCount){//���ѡ������ǰһҳ�����һҳ֮�������
			pageNavigationEndIndex = currPage+1;
			pageNavigationStartIndex = pageNavigationEndIndex - x;
		}
	%>
	<%-- ʵ�ַ�ҳ ��Ҫ����� ���� --%>
	
	<%-- ʵ�ַ�ҳ ��ӡ����һ ��ʼ --%>
	<%
		for(int i = pageNavigationStartIndex; i < pageNavigationEndIndex; i++){
	%>
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=i%>"><%=i%></a>&nbsp;
	<%
		} 
	%>
	<%-- ʵ�ַ�ҳ ��ӡ����һ ���� --%>
		<input style="width: 30px;height: 14px" type="text" onkeydown="javascript: if(event.keyCode==13){ location='servletListPage?&sid=<%=sid%>&action=showPage&currPage='+this.value+'';return false;}" \>
		<a href="servletListPage?sid=<%=sid%>&action=showPage&currPage=<%=PageCount%>">>></a>&nbsp;
		Pages:&nbsp;(&nbsp;<%=currPage %>&nbsp;/&nbsp;<%=PageCount %>&nbsp;total&nbsp;)
		&nbsp; 
	<%
		}
	%>
	</DIV>
<%
	} 
%>

</DIV>
<!--             �� ��          -->
<BR/>
<CENTER class="gray">��Ȩ��Ϣ</CENTER>

</BODY>
</HTML>
