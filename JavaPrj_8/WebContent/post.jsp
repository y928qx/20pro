<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ include file="checkLogin.jsp"%>
<%
	Integer uid = 0;
	//���������������
	Integer sid = Integer.parseInt( request.getParameter("sid"));
	Integer tid = Integer.parseInt(request.getParameter("tid"));
	String action = (String) request.getParameter("action");
	//out.print("<h1>"+action+sid+tid+"</h1>");
	//��ûỰ���������
	UserInfo users = (UserInfo) session.getAttribute("users");//�õ���ǰ��¼���û�
	//����pageCoontex���� 
	pageContext.setAttribute("page_sid", sid);
%>
<%
	if (users != null) {
		 uid = users.getUid();
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>��ҵ��̳--��������</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gbk">
		<Link rel="stylesheet" type="text/css" href="style/style.css" />
		<script type="text/javascript">
function check(flag){
	var topic = document.postForm.title.value;
	var content = document.postForm.content.value;
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
			<%@ include file="showLogin.jsp"%>
		</DIV>


		<!--      ����        -->
		<DIV>
			<BR />
			<!--      ����        -->
			<DIV>
				&gt;&gt;
				<B><a href="index.jsp">��̳��ҳ</a>
				</B><%@ include file="navigation.jsp"%>
			</DIV>
			<BR />
			<!-- �����ӵı� -->
			<%
				if ("reply".equals(action.toLowerCase())) {
			%>
			<DIV>
				<FORM name="postForm" onsubmit="return check(0);"
					action="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&uid=<%=uid%>&action=<%=action%>"
					method="post">
					<INPUT type="hidden" name="boardId" value="4" />
					<INPUT type="hidden" name="topicId" value="" />
					<DIV class="t">
						<TABLE cellSpacing="0" cellPadding="0" align="center">
							<TR>
								<TD class="h" colSpan="2">
									<B>
									�ظ�����
									</B>
								</TD>
							</TR>

							<TR class="tr3">
								<TH width="20%">
									<B>����</B>
								</TH>
								<TH>
									<INPUT class="input"
										style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1"
										size="60" name="title">
								</TH>
							</TR>

							<TR class="tr3">
								<TH vAlign=top>
									<DIV>
										<B>����</B>
									</DIV>
								</TH>
								<TH colSpan=2>
									<DIV>
										<span><textarea style="WIDTH: 500px;" name="content"
												rows="20" cols="90" tabIndex="2"></textarea>
										</span>
									</DIV>
									(���ܴ���:
									<FONT color="blue">1000</FONT>��)
								</TH>
							</TR>
						</TABLE>
					</DIV>

					<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
						<INPUT class="btn" tabIndex="3" type="submit" value="�� ��">
						<INPUT class="btn" tabIndex="4" type="reset" value="�� ��">
					</DIV>
				</FORM>
			</DIV>
			<!-- �������ӵı� -->
			<%
				} else{
			%>
			<DIV>
<FORM name="postForm" onsubmit="return check(1)"
	action="servletDetailPage?tid=<%=tid%>&sid=<%=sid%>&uid=<%=uid%>&action=<%=action%>"
	method="post">
	<INPUT type="hidden" name="boardId" value="4" />
	<INPUT type="hidden" name="topicId" value="" />
	<DIV class="t">
		<TABLE cellSpacing="0" cellPadding="0" align="center">
			<TR>
				<TD class="h" colSpan="2">
					<B>��������</B>
				</TD>
			</TR>
			<TR class="tr3">
				<TH width="20%">
					<B>����</B>
				</TH>
				<TH>
					<INPUT class="input"style="PADDING-LEFT: 2px; 
					FONT: 14px Tahoma" tabIndex="1"size="60" name="title">
				</TH>
			</TR>

			<TR class="tr3">
				<TH vAlign=top>
					<DIV>
						<B>����</B>
					</DIV>
				</TH>
				<TH colSpan=2>
					<DIV><span>
						<textarea style="WIDTH: 500px;" name="content"
						rows="20" cols="90" tabIndex="2"></textarea>
					</span></DIV>
					(���ܴ���:
					<FONT color="blue">1000</FONT>��)
				</TH>
			</TR>
		</TABLE>
	</DIV>
	<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
		<INPUT class="btn" tabIndex="3" type="submit" value="�� ��">
		<INPUT class="btn" tabIndex="4" type="reset" value="�� ��">
	</DIV>
</FORM>
			</DIV>
			<%
				}
			%>
		</DIV>
		<!--      ����        -->
		<BR />
		<CENTER class="gray">
			��Ȩ��Ϣ
		</CENTER>

	</BODY>
</HTML>