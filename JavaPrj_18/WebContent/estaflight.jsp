<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
function add()
{
    var f=document.form1;
     if(f.Qifei.value==f.Mudi.value)
     {
        alert("��ɵص��Ŀ�ĵز�����ͬ");
        
        return false;
     }   
}
</script>

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
<p align="center" class="style1">�ƶ�����</p>
<hr>
<p>&nbsp;</p>
<table width="644" height="26" border="2" align="center" cellpadding="1" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#CDE9FE">
  <tr>
    <td><div align="center"></div>      
      <div align="center"><a href="estaflight.jsp">�ƶ�����</a></div></td>
      <td><div align="center"><a href="HavingServlet">���ź���</a></div></td>
    <td><div align="center"><a href="DestineServlet?param=2">�鿴����</a></div></td>
    <td><div align="center"></div>      <div align="center"><a href="index.html">�˳�</a></div></td>
  </tr>
</table>
<p align="center">&nbsp;</p>
<form name="form1" method="post" action="SchedServlet"  onsubmit="return add()">
<table width="400" border="1" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td width="150" height="30" align="center">�����</td>
    <td width="250"><div align="center">
                <select name="Hao">
                    <c:forEach var="flight" items="${a}">
                        <option value="${flight}">${flight}</option>
                </c:forEach>
                
            </select>
    </div></td>
  </tr>

  <tr>
    <td height="30" align="center">��ɵص�</td>
    <td><div align="center"><select name="Qifei" >
                <option value="�人">�人</option>
                <option value="����">����</option>
                <option value="�Ϻ�">�Ϻ�</option>
                <option value="��ɳ">��ɳ</option>
                <option value="����">����</option>   
                <option value="�Ͼ�">�Ͼ�</option>  
                <option value="����">����</option> 
                <option value="����">����</option> 
                <option value="���">���</option> 
                <option value="����">����</option> 
    </select></div></td>
  </tr>
  <tr>
    <td height="30" align="center">Ŀ�ĵص�</td>
    <td><div align="center">
            <select name="Mudi">
                <option value="����">����</option>
                <option value="�Ϻ�">�Ϻ�</option>
                <option value="��ɳ">��ɳ</option>
                <option value="����">����</option> 
                <option value="�Ͼ�">�Ͼ�</option>  
                <option value="����">����</option> 
                <option value="����">����</option> 
                <option value="���">���</option> 
                <option value="����">����</option> 
                
        </select></div>
    </td>
  </tr>
  <tr>
    <td height="30" align="center">�ó�(Сʱ)</td>
    <td><div align="center">
       
        <select name="Lchen">
                    <c:forEach var="h" items="${b}">
                        <option value="${h}">${h}</option>
                </c:forEach>
    </div></td>
  </tr>
  <tr>
    <td height="30" align="center">�۸�(��)</td>
    <td><div align="center">
        <select name="Jiage">
                    <c:forEach var="mon" items="${c}">
                        <option value="${mon}">${mon}</option>
                </c:forEach>

    </div></td>
  </tr>
  <tr>
    <td height="30" align="center">Ʊ��(��)</td>
    <td><div align="center">
        <select name="Piaosu">
                    <c:forEach var="piao" items="${d}">
                        <option value="${piao}">${piao}</option>
                </c:forEach>
       
    </div></td>
  </tr>
</table>
<p align="center">
  <input name="tijiao" type="submit" id="tijiao" value="�ύ">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input name="chongzhi" type="reset" id="chongzhi" value="����">
</p>
<p align="center">&nbsp;</p>
</form>
</body>
</html>


