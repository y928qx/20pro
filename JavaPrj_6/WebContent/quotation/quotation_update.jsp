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
<title>���±�����Ϣ</title>
</head>
<body>
<center>
<form action="quotationmanage_update.do" method="post">
<input type="hidden" name="quotationNO" value="${quotation.quotationNO}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">���±�����Ϣ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >������</td>			
		<td class="tdEditContent"><input type="text" name="quotationMan" value="${quotation.quotationMan}"></td>
		<td class="tdEditLabel" >�ͻ�����</td>			
		<td class="tdEditContent">
		<select name="customer.customerNO">
			<s:iterator value="#request.customers" id="customer">
				<option value="${customer.customerNO}" 
				<s:if test="#request.quotation.customer.customerNO == #customer.customerNO">selected="selected"</s:if>
				>${customer.customerName}</option>
			</s:iterator>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >��Ʒ����</td>			
		<td class="tdEditContent">
		<select name="product.productNO">
			<s:iterator value="#request.products" id="product">
				<option value="${product.productNO}" 
				<s:if test="#request.quotation.product.productNO == #product.productNO">selected="selected"</s:if>
				>${product.productName}</option>
			</s:iterator>
		</select>
		</td>
		<td class="tdEditLabel" >������Ϣ</td>			
		<td class="tdEditContent" ><input type="text" name="otherInfo" value="${quotation.otherInfo}"></td>
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
				class="MyButton" value="���±�����Ϣ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>