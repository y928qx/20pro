<%@page contentType="text/html" %>
<%@page pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>

<script language="javascript">
function User()
{
	var f=document.form1;
	if(f.Username.value=="")
	{
		alert("���ֲ���Ϊ��");
                f.Username.focus();
                f.Username.select();
		return false;
	}
    if(f.Username.value.substring(0,1)==" ")
     {
        alert("��һλ����Ϊ��");
        f.Username.focus();
        f.Username.select();
        return false;
     }
	if(f.Username.value.length<8)
	{
		alert("�������û����Ȳ���ȷ");
                f.Username.focus();
                f.Username.select();
		return false;
	}
	if(f.Username.value.length>12)
	{
		alert("�������û����Ȳ���ȷ");
                f.Username.focus();
                f.Username.select();
		return false;
	}
        if(f.Password.value=="")
        {
               alert("���벻��Ϊ��");
               f.Password.focus();
                f.Password.select();
		return false;
        }
        if(f.Password.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.Password.focus();
            f.Password.select();
            return false;
         }
       
        if(isNaN(f.Password.value)!=true)
        {
                 if(f.Password.value.length>12 || f.Password.value.length<6)
                {	
                        alert("���볤�Ȳ���ȷ");
                        f.Password.focus();
                        f.Password.select();
                        return false;

                }
        }
        else
        {
                alert("�������Ϊ����");
                f.Password.focus();
                f.Password.select();
                return false; 
        }
        if(f.Password.value.indexOf("-",0)>=0 || f.Password.value.indexOf("+",0)>=0)
         {
            alert("���ܳ���+ - ��");
            f.Password.focus();
            f.Password.select();
            return false;
         }
        if(f.password2.value=="")
        {
               alert("���벻��Ϊ��");
               f.password2.focus();
                f.password2.select();
		return false;
        }
        if(f.password2.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.password2.focus();
            f.password2.select();
            return false;
         }
        if(f.password2.value!=f.Password.value)
	{
		alert("���벻һ��!");
                f.password2.focus();
                f.password2.select();
		return false;
	}
        if(f.Name.value=="")
        {
            alert("��������Ϊ��");
            f.Name.focus();
            f.Name.select();
            return false;
        }
        if(f.Name.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.Name.focus();
            f.Name.select();
            return false;
         }
       
        if(isNaN(f.Name.value))
        {
             if(f.Name.value.length<2 || f.Name.value.length>14)
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
       if(f.Tel.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.Tel.focus();
            f.Tel.select();
            return false;
         }
        
        if(isNaN(f.Tel.value)!=true)
        {
            if(f.Tel.value.length<8 || f.Tel.value.length>14)
            {
                alert("�绰���볤�Ȳ���ȷ");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
        }
        else
        {
            alert("�绰����Ϊ����");
            f.Tel.focus();
            f.Tel.select();
            return false;
        }
        if(f.Tel.value.indexOf("-",0)>=0 || f.Tel.value.indexOf("+",0)>=0)
         {
            alert("���ܳ���+ - ��");
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
            if(f.Email.value.substring(0,1)==" ")
             {
                alert("��һλ����Ϊ��");
                f.Email.focus();
                f.Email.select();
                return false;
             }
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
function Pass()
{
        var f=document.form1;

	
}

function Email()
{
        var f=document.form1;
	if(f.Email.value.indexOf("@",0)==-1)
	{
			alert("��ַ����,��@����");
			return;
	}	
	if(f.Email.value.indexOf(".",0)==-1)
	{
			alert("��ַ����,��.����");
			return;
	}	
	
}
</script>

<style type="text/css">
<!--.link {
color : #000000;
text-decoration : none;
}A.link:hover {
color : red;
}A.link:active {
color : #000000;
text-decoration : none;
}//-->
</style>
<style type="text/css">
<!--
#slidemenubar2{position:absolute;left:-110pt;width:120pt;top:100pt;border:1.5pt solid black;
background-color:#ffffff;layer-background-color:#ffffff;font: 9pt/20pt "����";}
body { font-size: 9pt; margin: 0pt}
#slidemenubar { position:absolute;
left:-110pt;width:120pt;top:100pt;border:1.5pt black solid;background-color:#F3F3F3;layer-background-color:lightyellow;
font: 9pt/20pt "����"; } 
//-->
</style>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	background-image: url(inmage/12d.JPG);
}
.style1 {
	font-size: 24pt;
	color: #FF3333;
	font-weight: bold;
}
.style3 {color: #000000}
-->
</style>
</head>

<script language="JavaScript1.2">
if (document.all)
document.write('<div id="slidemenubar2" ��¼yle="left:-100" onMouseover="pull()" onMouseout="draw()">')
</script> <layer id="slidemenubar" onMouseover="pull()" onMouseout="draw()"> <script language="JavaScript1.2">
var sitems=new Array()
var sitemlinks=new Array()
//�����ǲ˵����ݣ��������ã�
sitems[0]="��վ��ҳ"
sitems[1]="��Ա��¼"
sitems[2]="����Աͨ��"
sitems[3]="����...."

//�˵���Ŀ����
sitemlinks[0]="index.html"
sitemlinks[1]="login.jsp"
sitemlinks[2]="Adminlogin.jsp"
sitemlinks[3]="../index.htm"

for (i=0;i<=sitems.length-1;i++)
document.write('<a href='+sitemlinks[i]+'>'+sitems[i]+'</a><br>')
</script> </layer> 
<script language="JavaScript1.2">
function regenerate(){
window.location.reload()
}function regenerate2(){
if (document.layers)
setTimeout("window.onresize=regenerate",400)
}window.onload=regenerate2
if (document.all){
document.write('</div>')
themenu=document.all.slidemenubar2.style
rightboundary=0
leftboundary=-150
}else{
themenu=document.layers.slidemenubar
rightboundary=150
leftboundary=10
}function pull(){
if (window.drawit)
clearInterval(drawit)
pullit=setInterval("pullengine()",50)
}function draw(){
clearInterval(pullit)
drawit=setInterval("drawengine()",50)
}function pullengine(){
if (document.all&&themenu.pixelLeft<rightboundary)
themenu.pixelLeft+=5
else if(document.layers&&themenu.left<rightboundary)
themenu.left+=5
else if (window.pullit)
clearInterval(pullit)
}function drawengine(){
if (document.all&&themenu.pixelLeft>leftboundary)
themenu.pixelLeft-=5
else if(document.layers&&themenu.left>leftboundary)
themenu.left-=5
else if (window.drawit)
clearInterval(drawit)
}

</script> 

<body>

<p>&nbsp;</p>
<p align="center" class="style1">��ӭ��ע���Ա</p>
<hr>
  <form name="form1" method="post" action="NewUser" onsubmit="return User()">
    <p>&nbsp;</p>
    <table width="443" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="94" height="38"><div align="center">
          <p>��&nbsp;�� ��:</p>
          </div></td>
        <td width="343">          
           <div align="left">
             <input name="Username" type="text" id="yonghu" size="20"  >
        <span class="style3">*�û�������Ϊ8-16��ĸ����</span></div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">�� &nbsp;     &nbsp;��:</div></td>
        <td>          
          <div align="left">
          <input name="Password" type="password" id="password1" size="20" >        
        *���볤��Ϊ6-14����</div></td>
      </tr>
      <tr>
        <td height="38"><div align="center">�ظ�����:</div></td>
        <td>
          <div align="left">
            <input name="password2" type="password" id="password2" size="20">
            *���������뱣��һ��
          </div></td></tr>
      <tr>
        <td height="38"><div align="center">��ʵ����:</div></td>
        <td>
          <div align="left">
            <input name="Name" type="text" id="name" size="20"> 
            *ӦΪ��ʵ����
</div></td></tr>
      <tr>
        <td height="38"><div align="center">�� &nbsp;&nbsp;&nbsp;��:</div></td>
        <td>
          <div align="left">
            <input type="radio" name="Sex" value="1"checked>
            ��
              <input type="radio" name="Sex" value="2">
              Ů</div></td></tr>
      <tr>
        <td height="38"><div align="center">�绰����:</div></td>
        <td>
          <div align="left">
            <input name="Tel" type="text" id="zhengjian" size="20">
 *�绰����Ϊ8-14λ����</div></td></tr>
      <tr>
        <td height="38"><div align="center">�����ʼ�:</div></td>
        <td>
          <div align="left">
            <input name="Email" type="text" id="Email" size="20">
        </div></td></tr>
    </table>
    <p align="center">
      <input type="submit" name="submit" value="�ύ">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="reset" value="����">
      
    </p>
  </form>
<p>&nbsp;</p>

</body>
</html>

