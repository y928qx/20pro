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
<title>��ѯ�û���Ϣ</title>
</head>
<body>
<center>
<form action="user.do" method="post">
<input type="hidden" name="query" value="true">
<center>
<TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=<%=basePath%>images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=<%=basePath%>images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>�û���ѯ<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
            <TD align=middle width=11 background=<%=basePath%>images/title_middle.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
            <TD align=middle background=<%=basePath%>images/title_right.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
          </TR>
        </TBODY>
      </TABLE>
</center>
<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD width="82%" height=14 align=right vAlign=center noWrap>
            </TD>
            <TD width="18%" align=right vAlign=center noWrap>��</TD>
          </TR>
          <TR>
            <TD height=14 align=right vAlign=center noWrap>
            	<!-- ����������ѯ�� -->
            </TD>
          </TR>
          <TR>
            <TD height=28 colspan="2" align=right vAlign=center noWrap background="<%=basePath%>images/list_middle.jpg">&nbsp;&nbsp;
            <!-- ��������������ҳ������ -->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:778px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >�û���</td>			
		<td class="tdEditContent"><input type="text" name="username">
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
				class="MyButton" value="��ѯ�û���Ϣ"> 
			</TD>
		</TR>
</TABLE>
<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD height=28 align=right vAlign=center noWrap background="<%=basePath%>images/list_middle.jpg">&nbsp;&nbsp;
    		</TD>
          </TR>
        </TBODY>
</TABLE>
</form>
</center>
</body>
</html>