<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"
	import="com.entity.*"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>��ҵ��̳--��¼</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css"/>
<script language="javascript">
function check() {
 if(document.loginForm.uName.value==""){
    alert("�û�������Ϊ��");
    return false;
 }
 if(document.loginForm.uPass.value==""){
    alert("���벻��Ϊ��");
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


<BR/>
<!--      ����        -->
<DIV>
	&gt;&gt;<B><a href="index.jsp">��̳��ҳ</a></B>
</DIV>
<!--      �û���¼��        -->
<DIV class="t" style="MARGIN-TOP: 15px" align="center">
<%
	UserInfo temp = (UserInfo)session.getAttribute("users"); 
	if(temp==null){
%>

<FORM name="loginForm" onSubmit="return check()" action="ServletLogin" method="post"> 
	�û����� <INPUT class="input" tabIndex="1"  type="text"      maxLength="20" size="35" name="uName" style="width: 225px"><Br> 
	�ܡ��룺 <INPUT class="input" tabIndex="2"  type="password"  maxLength="20" size="40" name="uPass" style="width: 225px"><br>
	<INPUT class="btn"  tabIndex="3"  type="submit" value="�� ¼">
</FORM>
<%
	} else{
	%>
	<meta http-equiv="refresh" content="2; url=/bbs" />
	<table width="80%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="100" align="center" valign="middle"><h1>��ʾ��Ϣ </h1>
      <p>���Ѿ���¼�������ظ���¼ </p>
    <p><a href="/bbs">��������û��ת��, ��������. </a></p></td>
  </tr>
	</table>
<%
	}
%>
</DIV>
<!--      ����        -->
<BR/>
<CENTER class="gray">��Ȩ��Ϣ</CENTER>
</BODY>
</HTML>
