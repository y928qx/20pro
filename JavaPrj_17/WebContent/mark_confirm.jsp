<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="drp" uri="http://www.sanqing.com/drp/functions"%> 
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
        <TD width="522" class="p1" height="2" nowrap><img src="images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>�ɼ�¼��&gt;&gt;¼��ȷ��</B></TD>
      </TR>
      </TBODY>
    </TABLE>
    
    <hr width="80%">
    
    <form name="markForm" action="mark.do" method="post">
    
     <input type="hidden" name="p" value="save">
			
    <TABLE class=small cellSpacing="1" cellPadding="2" width="80%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
      	  <TD class="TableSeparator" width="15%" align="center"><strong>�γ�</strong></TD>
      	  <TD class="TableSeparator" width="10%" align="center"><strong>ѧ��</strong></TD>
      	  <TD class="TableSeparator" width="10%" align="center"><strong>ѧ��</strong></TD>
      	  <TD class="TableSeparator" width="10%" align="center"><strong>����</strong></TD>
      </TR>
   
      <c:forEach items="${sessionScope.marks}" var="item">
      
      <TR>
	      <TD class=TableData align="center">${ item.course.name }</td>
	      <TD class=TableData align="center">${ item.student.code }</td>
	      <TD class=TableData align="center">${ item.student.name }</td>
		  <TD class=TableData align="center">${ item.score }</td>
      </TR>

      </c:forEach>
      </TBODY>
    </TABLE>
    
    <TABLE class=small cellSpacing="1" cellPadding="2" width="80%" align="center" >
      <TBODY>    
      <TR>
          <TD class=TableButton colspan=2 align=center>
            <input type="submit" value="ȷ��" class="BigButton" />
			<input type="button"  value="����" onClick="history.back(-1);" class="BigButton">
          </TD>
      </TR>
     </TBODY>
    </TABLE>
	</form>
  </body>
</html>


