<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
function User()
{
	var f=document.form1;
	if(f.Password.value=="")
        {
               alert("ԭ���벻��Ϊ��");
               f.Password.focus();
                f.Password.select();
		return false;
        }
        if(f.Password.value.length>16 || f.Password.value.length<6)
	{	
		alert("ԭ���볤�Ȳ���ȷ");
                f.Password.focus();
                f.Password.select();
		return false;
		
	}
        if(isNaN(f.Password.value))
        {
                alert("ԭ�������Ϊ����");
                f.Password.focus();
                f.Password.select();
                return false;
                
        }
        
        
      if(f.Password1.value=="")
        {
               alert("�����벻��Ϊ��");
               f.Password1.focus();
                f.Password1.select();
		return false;
        }
        if(f.Password1.value.length>16 || f.Password.value.length<6)
	{	
		alert("�����볤�Ȳ���ȷ");
                f.Password1.focus();
                f.Password1.select();
		return false;
		
	}
        if(isNaN(f.Password1.value))
        {
                alert("���������Ϊ����");
                f.Password1.focus();
                f.Password1.select();
                return false;   
        }
      if(f.Password1.value!=f.Password2.value)
	{
		alert("���벻һ��!");
                f.Password2.focus();
                f.Password2.select();
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
<p align="center" class="style1">������Ϣ����</p>
<hr>
<p>&nbsp;</p>
<table width="644" height="26" border="2" align="center" cellpadding="1" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#CDE9FE">
  <tr>
    <td><div align="center"><a href="index.html">��ҳ</a></div></td>
    <td><div align="center"><a href="ModifySerlvet?param=0">�޸ĸ�����Ϣ</a></div></td>

    <td><div align="center">�����޸�</a></div></td>
    <td><div align="center"><a href="DestineServlet?param=1">Ԥ����Ʊ</a></div></td>
    <td><div align="center"><a href="ExamineSerlvet">�鿴���ﳵ</a></div></td>
    <td><div align="center"><a href="index.html">�˳�</a></div></td>
  </tr>
</table>
<p>&nbsp;</p>
<form name="form1" method="post" action="PassServlet" onsubmit="return User()">
    <p>&nbsp;</p>
    <table width="300" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="94" height="38"><div align="center"><p>ԭ����</p> </div></td>
        <td width="200"><div align="center"><input name="Password" type="password"  size="20" />
        </div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">������</div></td>
        <td><div align="center"><input name="Password1" type="password"  size="20" >     
        </div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">ȷ������</div></td>
        <td><div align="center"> <input name="Password2" type="password" size="20" >
        </div></td>
      </tr>
      <tr>

    </table>
    <p align="center">
      <input type="submit" name="Submit" value="�޸�"/>&nbsp;&nbsp;&nbsp;
      <input type="reset" name="reset" value="����"/>
   
    
</p>
  </form>
</body>
</html>

