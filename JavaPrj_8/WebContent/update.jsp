<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ include file ="checkLogin.jsp" %>
<%
	//���������������
	Integer sid = (Integer)request.getAttribute("sid");
	Integer tid = (Integer)request.getAttribute("tid");
	TopicInfo edittopic = (TopicInfo)request.getAttribute("edittopic");
	ReplyInfo editreply = (ReplyInfo)request.getAttribute("editreply");
	String action = (String)request.getAttribute("action");
	//����pageCoontex���� 
	pageContext.setAttribute("page_sid",sid);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>��ҵ��̳--�޸�����</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript">
function check(flag){
	var topic = document.updateForm.title.value;
	var content = document.updateForm.content.value;
	var regTopic = /^.{4,20}$/;
	var regContent = /^(.|[\r\n]){1,1000}$/;
	if(flag){
		if(topic=="" || !topic.match(regTopic)){
			alert("���ⲻ��Ϊ��,������4-20");
			return false;
		}
		
	}
	
	if(content=="" || !content.match(regContent)) {
		alert("���ݲ���Ϊ�գ����ҳ��Ȳ�����1000");
		return false;
	}
}
</script>
</HEAD>

<BODY>
<DIV>
</DIV>
<!--      �û���Ϣ����¼��ע��        -->

<DIV class="h">
<%@ include file="showLogin.jsp" %>
</DIV>                                                           


<!--      ����        -->
<DIV><BR/>
	<!--      ����        -->
	<DIV>
		&gt;&gt;<B><a href="index.jsp">��̳��ҳ</a></B><%@ include file="navigation.jsp" %>
	</DIV><BR/>
	<!-- �޸������ı� -->
	<%
		if("edittopic".equals(action.toLowerCase())){
	%>
	<DIV>
		<FORM name="updateForm" onSubmit="return check(1);" action="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&action=updateTopic" method="post">
			<INPUT type="hidden" name="boardId" value="8"/>
			<INPUT type="hidden" name="replyId" value="61"/>
			<DIV class="t">
				<TABLE cellSpacing="0" cellPadding="0" align="center">
				 
				    <TR>
					    <TD class="h" colSpan="3"><B>�޸�����</B></TD>
				    </TR>
				
				    <TR class="tr3">
					    <TH width="20%"><B>����</B></TH>
					    <TH><INPUT name="title" value="<%=edittopic.getTtopic()%>" class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60"></TH>
				    </TR>
				 
				    <TR class="tr3">
					    <TH vAlign="top">
					      <DIV><B>����</B></DIV>
					    </TH>
					    <TH colSpan="2">
					        <DIV>
						        <span><textarea  name="content" style="WIDTH: 500px;word-break:break-all;" rows="20" cols="90" tabIndex="2" ><%=edittopic.getTcontents() %></textarea></span>
						    </DIV>
					      (���ܴ���:<FONT color="blue">1000</FONT>��)
					    </TH>
					</TR>
				</TABLE>
			</DIV>

			<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
				<INPUT class="btn" tabIndex="3" type="submit" value="�� ��"> 
			</DIV>
		</FORM>
	</DIV>
	<!-- �޸ĸ����ı� -->
	<%
		}else if("editreply".equals(action.toLowerCase())){
	%>
		<DIV>
		<FORM name="updateForm" onSubmit="return check(0);" action="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&rid=<%=editreply.getRid()%>&action=updateReply" method="post">
			<INPUT type="hidden" name="boardId" value="8"/>
			<INPUT type="hidden" name="replyId" value="61"/>
			<DIV class="t">
				<TABLE cellSpacing="0" cellPadding="0" align="center">
				 
				    <TR>
					    <TD class="h" colSpan="3"><B>�޸Ļ���</B></TD>
				    </TR>
				
				    <TR class="tr3">
					    <TH width="20%"><B>����</B></TH>
					    <TH><INPUT name="title" value="<%=editreply.getRtopic()%>" class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60"></TH>
				    </TR>
				 
				    <TR class="tr3">
					    <TH vAlign="top">
					      <DIV><B>����</B></DIV>
					    </TH>
					    <TH colSpan="2">
					        <DIV>
						        <span><textarea  name="content" style="WIDTH: 500px;word-break:break-all;" rows="20" cols="90" tabIndex="2" ><%=editreply.getRcontents() %></textarea></span>
						    </DIV>
					      (���ܴ���:<FONT color="blue">1000</FONT>��)
					    </TH>
					</TR>
				</TABLE>
			</DIV>

			<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
				<INPUT class="btn" tabIndex="3" type="submit" value="�� ��"> 
			</DIV>
		</FORM>
	</DIV>
	<%
	 	}
	%>
	<!--      ����        -->
	<BR/>
</DIV>
<CENTER class="gray">��Ȩ��Ϣ</CENTER>

</BODY>
</HTML>
