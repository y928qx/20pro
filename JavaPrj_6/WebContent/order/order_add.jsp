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
<title>��Ӷ�����Ϣ</title>
</head>
<body>
<center>
<form action="ordermanage_add.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">��Ӷ�����Ϣ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >�������</td>			
		<td class="tdEditContent"><input type="text" name="orderNO">
		</td>
		<td class="tdEditLabel" >�ͻ�����</td>			
		<td class="tdEditContent">
		<select name="customer.customerNO">
			<s:iterator value="#request.customers" id="customer">
				<option value="${customer.customerNO}">${customer.customerName}</option>
			</s:iterator>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >��Ʒ����</td>			
		<td class="tdEditContent">
		<select name="product.productNO">
			<s:iterator value="#request.products" id="product">
				<option value="${product.productNO}">${product.productName}</option>
			</s:iterator>
		</select>
		</td>
		<td class="tdEditLabel" >��Ʒ����</td>			
		<td class="tdEditContent"><input type="text" name="quantity"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >������Ϣ</td>			
		<td class="tdEditContent" colspan="3"><input type="text" name="otherInfo"></td>
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
				class="MyButton" value="���涩����Ϣ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>