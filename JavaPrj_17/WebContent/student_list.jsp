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

	function addItem() {
		window.self.location = "student.do?p=edit&pageNo=${studentForm.pageNo}";
	}
	
	function modifyItem() {
		var count = 0;
		var j = 0;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("��ѡ����Ҫ�޸ĵ�ѧ����");
			return;
		}
		if (count > 1) {
			alert("һ��ֻ���޸�һ��ѧ����");
			return;
		}
		if (count == 1) {
			window.self.location = "student.do?p=edit&id=" + 
			                        document.getElementsByName("selectFlag")[j].value + 
			                        "&pageNo=${studentForm.pageNo}";
		}
	}
	
	function deleteItem() {
		var flag = false;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				flag = true;
			}		
		}
		if (!flag) {
			alert("��ѡ����Ҫɾ����ѧ����");
			return;
		}
		if (window.confirm("ȷ��ɾ����")) {
			with (document.getElementById("studentForm")) {
				method = "post";
				action = "student.do?p=delete&pageNo=${studentForm.pageNo}";
				submit();
			}
		}
	}
	
	function checkAll() {
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			document.getElementsByName("selectFlag")[i].checked = document.getElementById("ifAll").checked;
		}
	}
	
	function queryItem() {
		with (document.getElementById("studentForm")) {
			method = "post";
			action = "student.do?p=list&pageNo=1";
			submit();
		}
	}
	
	function countItem() {
		window.self.location = "student.do?p=count&pageNo=1&flag=true";
	}
	
	function myOnkeypress() {
		if (window.event.keyCode == 13) {
			queryItem();
		}
	}
	
	function topPage() {
		window.self.location = "student.do?p=list&pageNo=${pageModel.topPageNo}"
	}
	
	function previousPage() {
		window.self.location = "student.do?p=list&pageNo=${pageModel.previousPageNo}"
	}	
	
	function nextPage() {
		window.self.location = "student.do?p=list&pageNo=${pageModel.nextPageNo}"
	}
	
	function bottomPage() {
		window.self.location = "student.do?p=list&pageNo=${pageModel.bottomPageNo}"
	}
	
	</script>
  </head>
  
  <body>

    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="60%" align="center" border="0">
      <TBODY>
      <TR>
        <TD width="522" class="p1" height="2" nowrap><img src="images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>ѧ������</B></TD>
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
            <font color="#FF0000">ѧ������:</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="name" class="BigInput" onkeypress="myOnkeypress()" size="20" maxlength="20" >&nbsp;&nbsp;
            <font color="#FF0000">ѧ��ѧ��:</font>&nbsp;&nbsp;<input type="text" name="code" id="code" class="BigInput" onkeypress="myOnkeypress()" size="20" maxlength="20" >
            <input name="btnQuery" type="button" class="BigButton" id="btnQuery"  value="��ѯ" onClick="queryItem()">
            <input name="btnReset" type="button" class="BigButton" id="btnReset"  value="ͳ��" onClick="countItem()">
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
	      <TD class=TableData align="center">${item.code }</TD>
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
      	    <input name="btnAdd" type="button" class="BigButton" id="btnAdd"  value="���" onClick="addItem()">
        	<input name="btnDelete" type="button" class="BigButton" id="btnDelete" value="ɾ��" onClick="deleteItem()">
        	<input name="btnModify" type="button" class="BigButton" id="btnModify" value="�޸�"  onClick="modifyItem()">
      	  </TD>
      </TR>
     </TBODY>
	</TABLE>
	</form>
  </body>
</html>
