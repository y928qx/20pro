<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
<title>��¼</title>
<meta http-equiv="content-type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../STYLE/AJAXSTYLE.css" type="text/css">
</link>
<link rel="stylesheet" href="../STYLE/Styles.css" type="text/css">
</link>
<link rel="stylesheet" href="../STYLE/layer.css" type="text/css">
</link>
<style type="text/css">
#LoginMain{
margin-top:15%;
width:495px;
height:183px;
.Input{
	border:1px solid #99c029;
	width:144px;
	height:18px;
	padding-left:2px;
	color:#0066FF;
}
#LoginInput{
	border:none;
	width:48px;
	height:13px;
	background:url(../IMAGES/InputLogin.gif) left top
}
</style>
<script type="text/javascript" src="../JS/jquery.js"></script>
<script type="text/javascript" src="../JS/iutil.js"></script>
<script type="text/javascript" src="../JS/idrag.js"></script>
<script type="text/javascript" src="../JS/jquery.form.js"></script>
<script type="text/javascript" src="../JS/waiting.js"></script>
<script type="text/javascript">
		//AJAX��¼��֤
		function checkuser(){
			if(!validInput())return;
			var MyWait = new wait(150,30,'���Ժ�,���ڵ�¼','../IMAGES/processing.gif');
			MyWait.show();
			$("#LoginForm").ajaxSubmit(
				function(data){
					if(data=="true")
					{
						location.href="../Frame.html";
					}
					else
					{
						alert(data);
					}
					MyWait.hidden();
				}
			);
		}
		//��֤�û�����
		function validInput()
		{
			if($("#username").val()==""){
				alert("�û�������Ϊ��");
				return false;
			}
			if($("#password").val()==""){
				alert("���벻��Ϊ��");
				return false;
			}
			return true;
		}
		</script>
</head>
<body>
<center>
  <html:form action="/login" styleId="LoginForm">
    <div id="LoginMain">
      <table width="100%" height="126" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="12%" height="38">&nbsp;</td>
          <td width="50%">&nbsp;</td>
          <td width="31%">&nbsp;</td>
		  <td width="7%">&nbsp;</td>
        </tr>
        <tr>
          <td height="21">&nbsp;</td>
          <td>&nbsp;</td>
          <td><html:text property="username" styleId="username" styleClass="Input"/></td>
		  <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
          <td>&nbsp;</td>
          <td><html:password property="password" styleId="password" styleClass="Input"/></td>
		  <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="16">&nbsp;</td>
          <td>&nbsp;</td>
          <td align="right"><input id="LoginInput" name="button" type="button" onClick="checkuser();" value=""/>&nbsp;</td>
		  <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
		  <td>&nbsp;</td>
        </tr>
      </table>
    </div>
  </html:form>
</center>
</body>
</html>
