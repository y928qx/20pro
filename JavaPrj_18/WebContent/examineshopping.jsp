<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">
<!--
body {
	background-image: url(inmage/12d.JPG);
}
.style1 {
	font-size: 36px;
	color: #FF0000;
}
-->
</style><body>
<p align="center" class="style1">��Ʊ��Ϣ</p>
<hr>
<p>&nbsp;</p>
<table width="644" height="26" border="2" align="center" cellpadding="1" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#CDE9FE">
  <tr>
    <td><div align="center"><a href="index.html">��ҳ</a></div></td>
    <td><div align="center"><a href="ModifySerlvet?param=0">�޸ĸ�����Ϣ</a></div></td>
    <td><div align="center"><a href="passwordamend.jsp">�����޸�</a></div></td>
    <td><div align="center"><a href="DestineServlet?param=1">Ԥ����Ʊ</a></div></td>
    <td><div align="center">�鿴���ﳵ</div></td>
    <td><div align="center"><a href="index.html">�˳�</a></div></td>
  </tr>
</table>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<table width="593" border="1" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td width="70" height="32"><div align="center">�����</div></td>
    <td width="100"><div align="center">�����ص�</div></td>
    <td width="100"><div align="center">Ŀ�ĵ�</div></td>
    <td width="150"><div align="center">��������</div></td>
    <td width="83"><div align="center">Ʊ��</div></td>
     <td width="83"><div align="center">��Ʊ��</div></td>
    <td width="91"><div align="center">�˶�</div></td>
  </tr>
  <c:forEach var="ary" items="${ary}">
      <tr>
          <td height="32" align="center">&nbsp;${ary.hao}</td>
          <td align="center">&nbsp;${ary.qifei}</td>
          <td align="center">&nbsp;${ary.mudi}</td>
          <td align="center">&nbsp;${ary.rqi}</td>
          <td align="center">&nbsp;${ary.jiage}</td>
          <td align="center">&nbsp;${ary.piaosu}</td>
          <td align="center">&nbsp;<a href=RecedServlet?hao=${ary.hao}>��Ʊ</td>
      </tr> 
  </c:forEach>
</table>
<p align="center">&nbsp;*������Ʊ,���û��������ڹ涨��������ǰһ����Ʊ.</p>
<p align="center">&nbsp;�����涨����,��ϵͳ����Ʊ.</p>
</body>
</html>

