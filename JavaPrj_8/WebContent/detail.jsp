<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*,com.page.*,com.dao.*,com.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	UserInfoDAO user_dao = new UserInfoDAO();
	
	//���������������
	Integer sid = (Integer)request.getAttribute("sid");
	Integer tid = (Integer)request.getAttribute("tid");
	List<DetailPage> replyList = (List<DetailPage>)request.getAttribute("replyListDetailPage");
	DetailPage topicObj = (DetailPage)request.getAttribute("topicListDetailPage");
	
	//��ʼ����ҳ����
	Integer currPage = 1;//Ĭ��ѡ���һҳ
	Integer recordConut = 0;//��¼����
	Integer PageCount = 0;//��ҳ����ҳ��
	Integer pageNum  = 4;//ÿҳ��ʾ�ļ�¼��
	Integer startIndex = 0;//��ʼ����
	Integer endIndex = 0;//��������
	Integer nextPage = 0;
	Integer PreviousPage = 0;
	
	//����������ķ�ҳ����
	String action = request.getParameter("action");
	
	//����pageCoontex���� 
	pageContext.setAttribute("page_sid",sid);
	//��õ�¼�û�����Ϣ
	UserInfo users = (UserInfo) session.getAttribute("users");
%>
<%-- ʵ�ַ�ҳ ��Ҫ����һ ��ʼ --%>
<%
	recordConut = replyList.size();
	//int result = recordConut % pageNum;
	//if(result != 0){//��÷�ҳ����ҳ��
		//PageCount = (recordConut / pageNum) + 1;
	//}else{
	//	PageCount = (recordConut / pageNum); 
	//}
	PageCount = (recordConut + (pageNum-1))/pageNum;//��÷�ҳ����ҳ��
	
	if("showpage".equals(action.toLowerCase())){//��õ�ǰѡ���ҳ��
	
		//currPage = Integer.parseInt(request.getParameter("currPage"));
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
			if(recordConut == --endIndex){
				endIndex -= 1;
				startIndex = 0;
			}else{
			 	int offset = (endIndex - recordConut) + 1;
				endIndex -= offset;
				startIndex = endIndex;
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
 <base href="<%=basePath%>">
<TITLE>��ҵ��̳--����</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<DIV>
</DIV>

<!--      �û���Ϣ����¼��ע��        -->

	<DIV class="h">
	<jsp:include page="showLogin.jsp"></jsp:include>
	<%-- include file="showLogin.jsp" --%>
	</DIV>

<!--      ����        -->
<DIV><br/>
	<!--      ����        -->
<DIV>
	&gt;&gt;<B><a href="index.jsp">��̳��ҳ</a></B><%@ include file="navigation.jsp" %>
</DIV>
	<br/>

	<!--      �ظ�������        -->
	<DIV>
		<A href="post.jsp?tid=<%=tid%>&sid=<%=sid%>&action=reply"><IMG src="image/reply.gif"  border="0" id=td_post></A> 
		<A href="post.jsp?tid=<%=tid%>&sid=<%=sid%>&action=post"><IMG src="image/post.gif"   border="0" id=td_post></A>
	</DIV>

	<!--         �� ҳ         -->
	<DIV class="pages">
	
	<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=--PreviousPage%>">��һҳ</a>&nbsp;|&nbsp;
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=++nextPage%>">��һҳ</a>&nbsp;|&nbsp;
	<%
		if(PageCount > 0){
	%>
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=1"><<</a>&nbsp;
		
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
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=i%>"><%=i%></a>&nbsp;
	<%
		} 
	%>
	<%-- ʵ�ַ�ҳ ��ӡ����һ ���� --%>
		<input style="width: 30px;height: 14px" type="text" onkeydown="javascript: if(event.keyCode==13){ location='servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage='+this.value+'';return false;}" \>
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=PageCount%>">>></a>&nbsp;
		Pages:&nbsp;(&nbsp;<%=currPage %>&nbsp;/&nbsp;<%=PageCount %>&nbsp;total&nbsp;)
		&nbsp; 
	<%
		}
	%>
	
	</DIV>
	<!--      ��ҳ����ı���        -->
	<DIV>
		<TABLE cellSpacing="0" cellPadding="0" width="100%">
			<TR>
				<TH class="h">��ҳ����: <%=topicObj.getTitle()%></TH>
			</TR>
			<TR class="tr2">
				<TD>&nbsp;</TD>
			</TR>
		</TABLE>
	</DIV>
	
	<!--      ����        -->
	
	<DIV class="t">
		<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" 
						cellSpacing="0" cellPadding="0" width="100%">
		<TR class="tr1">
		<TH style="WIDTH: 20%">
			<b>#1</b><br/>
			<B><%=topicObj.getName()%></B><BR/> 
			���<%=user_dao.getUserTypeNameById(topicObj.getType()) %><br/>
			�Ա�<%=user_dao.getSexName(topicObj.getSex()) %><br/>
			<img src="image/head/<%=topicObj.getFace()%>"/><BR/>
			ע��:<%=topicObj.getRegtime()%><BR/>
		</TH>
		<TH>
			<H4><%=topicObj.getTitle()%></H4>
			<DIV><%=topicObj.getContents()%></DIV>
			<DIV class="tipad gray">
			����[<%=CommonDAO.getDateFormat(topicObj.getPublishtime())%>] &nbsp;
			<%
				if(topicObj.getModifytime()!=null){
			%>
				����޸�:[<%=CommonDAO.getDateFormat(topicObj.getModifytime())%>]
			<%
				}
			%>
			<%
				//ֻ�й���Ա���޸�
				if(users != null && users.getUtype() == 2 ){ 
			%>
			 <A href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=delTopic"
			  onclick = "return confirm('ȷ��Ҫɾ����?');">[ɾ��]</A>
			<%
			 	} 
			%>
			<%
				//ֻ�й���Ա�͵�ǰ�������û����޸�
				if(users != null && (users.getUtype() == 2 ||
									 users.getUid() == topicObj.getUid())){ 
			%>
				<A href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>
							&action=editTopic">[�޸�]</A>
			<%
			 	} 
			%>
			</DIV>
		</TH>
		</TR>
		</TABLE>
	</DIV>
	
	<!--      �ظ�        -->

	<%
		if(recordConut > 0){
			for(int i = startIndex; i <= endIndex; i++){
	%>
		<DIV class="t">
	<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: 
				fixed" cellSpacing="0" cellPadding="0" width="100%">
	<TR class="tr1">
	<TH style="WIDTH: 20%">
		<b>#<%=i+2%></b><br/>
		<B><%=replyList.get(i).getName()%></B><BR/> 
		���<%=user_dao.getUserTypeNameById(replyList.get(i).getType()) %><BR/>
		�Ա�<%=user_dao.getSexName(replyList.get(i).getSex()) %><br/>
		<img src="image/head/<%=replyList.get(i).getFace()%>"/><BR/>
		ע��:<%=replyList.get(i).getRegtime()%><BR/>
	</TH>
	<TH>
		<H4><%=replyList.get(i).getTitle()%></H4>
		<DIV><%=replyList.get(i).getContents()%></DIV>
		<DIV class="tipad gray">
			����[<%=CommonDAO.getDateFormat(replyList.get(i).getPublishtime())%>] &nbsp;
			<%
				if(replyList.get(i).getModifytime()!=null){
			%>
				����޸�:[<%=CommonDAO.getDateFormat(replyList.get(i).getModifytime())%>]
			<%
				}
			 %>
			 <%
				//ֻ�й���Ա���޸�
				if(users != null && users.getUtype() == 2 ){ 
			%>
			<A href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&rid=
				<%=replyList.get(i).getId()%>&action=delReply"
					 onclick="return confirm('ȷ��Ҫɾ����?');">[ɾ��]</A>
			<%
				}
			%>
			<%
				//ֻ�й���Ա�͵�ǰ�������û����޸�
				if(users != null && (users.getUtype() == 2 ||
								 users.getUid() == replyList.get(i).getUid())){ 
			%>
			<A href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&rid=
								<%=replyList.get(i).getId()%>&action=editReply">[�޸�]</A>
			<%
				} 
			%>
		</DIV>
	</TH>
	</TR>
	</TABLE>
		</DIV>
	<%			}
			} 
	%>
</DIV>
<!--         �� ҳ         -->
	<DIV class="pages">
	
	<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=PreviousPage%>">��һҳ</a>&nbsp;|&nbsp;
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=nextPage%>">��һҳ</a>&nbsp;|&nbsp;
	<%
		if(PageCount > 0){
	%>
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=1"><<</a>&nbsp;
		
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
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=i%>"><%=i%></a>&nbsp;
	<%
		} 
	%>
	<%-- ʵ�ַ�ҳ ��ӡ����һ ���� --%>
		<input style="width: 30px;height: 14px" type="text" onkeydown="javascript: if(event.keyCode==13){ location='servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage='+this.value+'';return false;}" \>
		<a href="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=showPage&currPage=<%=PageCount%>">>></a>&nbsp;
		Pages:&nbsp;(&nbsp;<%=currPage %>&nbsp;/&nbsp;<%=PageCount %>&nbsp;total&nbsp;)
		&nbsp; 
	<%
		}
	%>
	
	</DIV>
<!--      ����        -->
<BR>
<CENTER class="gray">��Ȩ��Ϣ</CENTER>
</BODY>
</HTML>

