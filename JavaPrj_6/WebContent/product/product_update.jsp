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
<title>�޸Ĳ�Ʒ��Ϣ</title>
</head>
<body>
<center>
<form action="productmanage_update.do" method="post">
<input type="hidden" name="productNO" value="${product.productNO}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">�޸Ĳ�Ʒ��Ϣ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent"><input type="text" name="productName" value="${product.productName}">
		</td>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent">
		<select name="producttypeNO">
			<s:iterator value="#request.producttypes" id="producttype">
			<option value="${producttype.producttypeNO}" 
			<s:if test="#request.product.productType.producttypeNO == #producttype.producttypeNO">selected="selected"</s:if>
			>${producttype.producttypeName}</option>
			</s:iterator>
		</select>
	</tr>
	<tr>
		<td class="tdEditLabel" >������</td>			
		<td class="tdEditContent"><input type="text" name="productOwner" value="${product.productOwner}">
		</td>
		<td class="tdEditLabel" >��������</td>			
		<td class="tdEditContent"><input type="text" name="producingArea" value="${product.producingArea}"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >�۸�</td>			
		<td class="tdEditContent"><input type="text" name="price" value="${product.price}">
		</td>
		<td class="tdEditLabel" >��λ</td>			
		<td class="tdEditContent"><input type="text" name="unit" value="${product.unit}"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent"><input type="text" name="quantity" value="${product.quantity}"></td>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent" ><input type="text" name="otherInfo" value="${product.otherInfo}">
		</td>
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
				class="MyButton" value="�޸Ĳ�Ʒ��Ϣ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>