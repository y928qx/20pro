<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="drp" uri="http://www.sanqing.com/drp/functions"%> 
<%@ include file="/commons/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>
	
	<script src="script/windows.js"></script>
	<script type="text/javascript">
	
	function queryItem() {
		with (document.getElementById("studentForm")) {
			method = "post";
			action = "student.do?p=count&pageNo=1";
			submit();
		}
	}	
	
	function resetItem() {
		window.self.location = "student.do?p=list&pageNo=1&flag=true";
	}
	
	function myOnkeypress() {
		if (window.event.keyCode == 13) {
			queryItem();
		}
	}
	
	function topPage() {
		window.self.location = "student.do?p=count&pageNo=${pageModel.topPageNo}"
	}
	
	function previousPage() {
		window.self.location = "student.do?p=count&pageNo=${pageModel.previousPageNo}"
	}	
	
	function nextPage() {
		window.self.location = "student.do?p=count&pageNo=${pageModel.nextPageNo}"
	}
	
	function bottomPage() {
		window.self.location = "student.do?p=count&pageNo=${pageModel.bottomPageNo}"
	}
	
	</script>
  </head>
  
  <body>

    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="60%" align="center" border="0">
      <TBODY>
      <TR>
        <TD width="522" class="p1" height="2" nowrap><img src="images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>ѧ������&gt;&gt;ѧ��ͳ��</B></TD>
      </TR>
      </TBODY>
    </TABLE>
    
    <hr width="60%">
    
	<%@ include file="/commons/messages.jsp" %>
    
    <form name="studentForm" id="studentForm" >
    
    <input type="hidden" name="flag" id="flag" value="true">

      <TABLE class=small cellSpacing="1" cellPadding="2" width="60%" align="center" bgColor="#000000" border="0">
      <TBODY>  
      <TR>
          <TD class=TableData align=center>
            <font color="#FF0000">�༶:</font>
            <select name="teamId" class="select1" id="teamId" onchange="change()">
          		<option value="">--��ѡ��--</option>
         		<c:forEach items="${drp:getTeamList()}" var="item" >
         			<option value="${item.id}">${item.name}</option>
        		</c:forEach>
        	</select>
        	<font color="#FF0000">�γ�:</font>
            <select name="courseId" class="select1" id="courseId">
          		<option value="">----��ѡ��----</option>
         		<c:forEach items="${drp:getCourseList()}" var="item" >
         			<option value="${item.id}">${item.name}</option>
        		</c:forEach>
        	</select>
        	<font color="#FF0000">��ʦ:</font>
            <select name="teacherId" class="select1" id="teacherId">
          		<option value="">--��ѡ��--</option>
         		<c:forEach items="${drp:getTeacherList()}" var="item" >
         			<option value="${item.id}">${item.name}</option>
        		</c:forEach>
        	</select>
            <input name="btnQuery" type="button" class="BigButton" id="btnQuery"  value="��ѯ" onClick="queryItem()">
         	<input name="btnQuery" type="button" class="BigButton" id="btnQuery"  value="����" onClick="resetItem()">
          </TD>
      </TR> 
      </TBODY>
    </TABLE>
    
    <p>
     
    <TABLE class=small cellSpacing="1" cellPadding="2" width="60%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
      	  <TD class="TableSeparator" width="5%" align="center"><input type="checkbox" name="ifAll" onClick="checkAll()" ></TD>
      	  <TD class="TableSeparator" width="20%" align="center"><strong>ѧ��</strong></TD>
          <TD class="TableSeparator" width="20%" align="center"><strong>����</strong></TD>
          <TD class="TableSeparator" width="15%" align="center"><strong>��ѧʱ��</strong></TD>
          <TD class="TableSeparator" width="20%" align="center"><strong>��������</strong></TD>
          <TD class="TableSeparator" width="5%" align="center"><strong>�Ա�</strong></TD>
          <TD class="TableSeparator" width="25%" align="center"><strong>�༶</strong></TD>
      </TR>
      
      <c:forEach items="${pageModel.list}" var="item">
      <TR>
      	  <TD class=TableData align="center" ><input type="checkbox" name="selectFlag" id="selectFlag" class="checkbox1" value="${item.id }"></td>
	      <TD class=TableData align="center">${item.code }</td>
          <TD class=TableData align="center">${item.name}</TD>
          <TD class=TableData align="center">${item.enrollDate}</TD>
          <TD class=TableData align="center">${item.birthday}</TD>
          <TD class=TableData align="center">${item.sex}</TD> 
          <TD class=TableData align="center">${item.team.name}</TD>    
      </TR>
      </c:forEach>
      
      </TBODY>
    </TABLE>
        
    <p>
    <TABLE border="0">
      <TBODY>
      <TR>
      	  <TD class=TableData align="right">
      	     ��${pageModel.totalRecords }����¼&nbsp;&nbsp;��${pageModel.totalPages }ҳ&nbsp;&nbsp;��${pageModel.pageNo }ҳ&nbsp;&nbsp;&nbsp;&nbsp;
      	    <input name="btnTopPage" type="button" class="BigButton" id="btnTopPage" value="��ҳ"  title="��ҳ" onClick="topPage()">
            <input name="btnPreviousPage" type="button" class="BigButton" id="btnPreviousPage" value="��һҳ"  title="��һҳ" onClick="previousPage()">
            <input name="btnNext" type="button" class="BigButton" id="btnNext" value="��һҳ"  title="��һҳ" onClick="nextPage()">
            <input name="btnBottomPage" type="button" class="BigButton" id="btnBottomPage" value="βҳ"  title="βҳ" onClick="bottomPage()">
      	  </TD>
      </TR>
     </TBODY>
	</TABLE>
	</form>
  </body>
</html>
