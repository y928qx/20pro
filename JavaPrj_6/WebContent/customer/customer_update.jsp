<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/share/taglib.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="<%=basePath%>style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=basePath%>script/public.js"></script>
<title>���¿ͻ���Ϣ</title>
</head>
<body>
<center>
<form action="customermanage_update.do" method="post">
<input type="hidden" name="customerNO" value="${customer.customerNO}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">���¿ͻ���Ϣ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >�ͻ�����</td>			
		<td class="tdEditContent"><input type="text" name="customerName" value="${customer.customerName}"></td>
		<td class="tdEditLabel" >��ϵ�绰</td>			
		<td class="tdEditContent"><input type="text" name="phone" value="${customer.phone}">
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >��ϵ��ַ</td>			
		<td class="tdEditContent"><input type="text" name="address" value="${customer.address}"></td>
		<td class="tdEditLabel" >��ϵ��</td>			
		<td class="tdEditContent"><input type="text" name="relationman" value="${customer.relationman}">
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent" colspan="3"><input type="text" name="otherInfo" value="${customer.otherInfo}"></td>
	</tr>
</table>
			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="���¿ͻ���Ϣ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>