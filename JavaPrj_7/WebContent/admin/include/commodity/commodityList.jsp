<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>��ӭ����ϵͳ��̨</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312"><LINK 
href="<%=basePath %>admin/images/syscome.files/Admin.css" rel=stylesheet>
<SCRIPT language=javascript src="<%=basePath %>images/syscome.files/Admin.js"></SCRIPT>

<STYLE type=text/css>.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</STYLE>

<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY>
  <TR>
    <TH colSpan=10 height=24>����Ʒ�б�</TH> 
   </TR>
     <TR>
    <TD class=forumrow>��Ʒ���</TD>
    <TD class=forumrow>��Ʒ����</TD>
    <TD class=forumrow>��Ʒ����</TD>
    <TD class=forumrow >��������</TD>
    <TD class=forumrow>��Ʒ�۸�</TD>
    <TD class=forumrow>�������۸�</TD>
    <TD class=forumrow>��Ʒ������</TD>
    <TD class=forumrow>��Ʒʣ������</TD>
    <TD class=forumrow>��Ʒ�ϼ�ʱ��</TD>
    <TD class=forumrow>����</TD>
  </TR>
   <s:iterator value="commodities" var="commodity" >
  <TR>
    <TD class=forumrow>${commodity.commodityId}</TD>
    <TD class=forumrow>${commodity.commodityName}</TD>
    <TD class=forumrow>${commodity.commodityClass.commodityClassName}</TD>
    <TD class=forumrow >${commodity.manufacturer}</TD>
    <TD class=forumrow>${commodity.commodityPrice}</TD>
    <TD class=forumrow>${commodity.fcPrice}</TD>
    <TD class=forumrow>${commodity.commodityAmount}</TD>
    <TD class=forumrow>${commodity.commodityLeaveNum}</TD>
    <TD class=forumrow><s:date name="regTime" format="yyyy-MM-dd"/>
    </TD>
    <TD class=forumrow><a href="deleteCommodity.action?commodityID=${commodity.commodityId}">ɾ��</a></TD>
  </TR>
  </s:iterator>
    <TR>
    <TD class=forumrow height=24 colspan="10" align="center">
    <s:if test="page.hasPrePage">
		<a href="findAllCommodity.action?currentPage=1">��ҳ</a>
		<a href="findAllCommodity.action?currentPage=${currentPage - 1}">��һҳ</a>
	</s:if>
	<s:else>
		<EM>��ҳ</EM>
		<EM>��һҳ</EM>
	</s:else>
	<s:if test="page.hasNextPage">
		<a href="findAllCommodity.action?currentPage=${currentPage + 1}">��һҳ</a>
		<a href="findAllCommodity.action?currentPage=${page.totalPage}">βҳ</a>
	</s:if>
	<s:else>
		<EM>��һҳ</EM>
		<EM>βҳ</EM>
	</s:else>
    </TD>
  </TR>
  </TBODY>
  </TABLE>
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
