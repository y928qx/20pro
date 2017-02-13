<%@ page language="java" pageEncoding="gb2312"%>
<%@ include file="/commons/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>

  </head>
  
  <body>

    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="60%" align="center" border="0">
      <TBODY>
      <TR>
        <TD width="522" class="p1" height="2" nowrap><img src="images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>�γ̹���&gt;&gt;<strong>${requestScope.course.name }</strong>��ϸ��Ϣ</B></TD>
      </TR>
      </TBODY>
    </TABLE>
    
    <hr width="60%">
    
	<%@ include file="/commons/messages.jsp" %>
    
    <form name="courseScheduleForm" id="courseScheduleForm" >
    
  	 <TABLE cellSpacing="1" cellPadding="2" width="60%" align="center" border="0">
      <TBODY>
      <TR>
        <TD width="522" align="center">����ÿγ̵İ༶��Ϣ</TD>
      </TR>
      </TBODY>
    </TABLE>
    <p>
    <TABLE class=small cellSpacing="1" cellPadding="2" width="60%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
		  <TD class="TableSeparator" width="25%" align="center">�γ�</TD>
		  <TD class="TableSeparator" width="25%" align="center">�༶</TD>
		  <TD class="TableSeparator" width="25%" align="center">ѧ��</TD>
		  <TD class="TableSeparator" width="25%" align="center">ѧ��</TD>
      </TR>
      
      <c:forEach items="${courseSchedules}" var="item">
      <TR>
	      <TD class=TableData align="center">${ item.course.name }</TD>
	      <TD class=TableData align="center">${ item.team.name }</TD>
	      <TD class=TableData align="center">${ item.semester }</TD>
	      <TD class=TableData align="center">${ item.score }</TD>
      </TR>
      </c:forEach>
      
      </TBODY>
    </TABLE>

    <TABLE class=small cellSpacing="1" cellPadding="2" width="60%" align="center" >
      <TBODY>    
      <TR>
          <TD class=TableButton colspan=2 align=center>
			<input type="button"  value="����" onClick="history.back(-1);" class="BigButton">
          </TD>
      </TR>
     </TBODY>
    </TABLE>

	</form>
  </body>
</html>
