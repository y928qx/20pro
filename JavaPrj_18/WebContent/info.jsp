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
	
       
       if(f.Name.value=="")
       {
            alert("��������Ϊ��");
            f.Name.focus();
            f.Name.select();
            return false;
        }
       
        if(isNaN(f.Name.value))
        {
             if(f.Name.value.length<2 || f.Name.value.length>10)
            {
                alert("�������������������");
                f.Name.focus();
                f.Name.select();
                return false;
            }
         }
        else
        {
                alert("��������Ϊ����");
                f.Name.focus();
                f.Name.select();
                return false;    
        }
     
   
        
        if(f.Tel.value=="")
        {
            alert("�绰����Ϊ��");
            f.Tel.focus();
            f.Tel.select();
            return false;
        }
        if(f.Tel.value.length<8 || f.Tel.value.length>14)
        {
            alert("�绰���볤�Ȳ���ȷ");
            f.Tel.focus();
            f.Tel.select();
            return false;
        }
        if(isNaN(f.Tel.value))
        {
            alert("�绰����Ϊ����");
            f.Tel.focus();
            f.Tel.select();
            return false;
        }
        if(f.Email.value=="")
        {
            return true;
        }
        else
        {
            if(f.Email.value.indexOf("@",0)==-1)
            {
                            alert("��ַ����,��@����");
                             f.Email.focus();
                            f.Email.select();
                            return false;
            }	
            if(f.Email.value.indexOf(".",0)==-1)
            {
                            alert("��ַ����,��.����");
                            f.Email.focus();
                            f.Email.select();
                            return false;
            }
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
    <td><div align="center">�޸ĸ�����Ϣ</div></td>

    <td><div align="center"><a href="passwordamend.jsp">�����޸�</a></div></td>
    <td><div align="center"><a href="DestineServlet?param=1">Ԥ����Ʊ</a></div></td>
    <td><div align="center"><a href="ExamineSerlvet">�鿴���ﳵ</a></div></td>
    <td><div align="center"><a href="index.html">�˳�</a></div></td>
  </tr>
</table>
<p>&nbsp;</p>
<form name="form1" method="post" action="NoparamServlet?param=1" onsubmit="return User()">
    <p>&nbsp;</p>
    <table width="443" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="94" height="38"><div align="center">
          <p>��&nbsp;�� ��:</p>
          </div></td>
        <td width="400">          <div align="center">
           <input name="Username" type="text" id="yonghu" size="20" readonly="true" value="${user.username}"/>
        </div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">��ʵ����:</div></td>
        <td><div align="center">
          <input name="Name" type="text" id="xingbin" size="20" value="${user.name}">
        </div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">�� &nbsp;&nbsp;&nbsp;��:</div></td> 
        <td><div align="center">
            
            <select name="Sex" >
               <option value="${ho}" >${ho}</option>
               <option value="${mo}">${mo}</option>
                
            </select>
          
            
            </div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">�绰����:</div></td>
        <td><div align="center">
          <input name="Tel" type="text" id="zhengjian" size="20" value="${user.tel}">
        </div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">�����ʼ�:</div></td>
        <td><div align="center">
          <input name="Email" type="text" id="Emil" size="20" value="${user.email}">
        </div></td>
      </tr>
    </table>
    <p align="center">
      <input type="submit" name="Submit" value="�޸�">
   
    
</p>
  </form>
</body>
</html>

