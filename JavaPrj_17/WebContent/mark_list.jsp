<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="drp" uri="http://www.sanqing.com/drp/functions"%> 
<%@ include file="/commons/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>
	
    <script type="text/javascript">
		var req;
		
		function init() {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		
		function change() {
			init();
			var url = "getStudents.jsp?id=" + escape(document.markForm.teamId.options[document.markForm.teamId.selectedIndex].value);
			req.open("GET", url, true);
			req.onreadystatechange = callback;
			req.send(null);
		}
		
		function callback() {
			if(4 == req.readyState) {
		
				if(200 == req.status) {
					//alert(req.responseText);
					eval(req.responseText);
				}
			}
			
		}
	</script>
	
		
	<script src="script/windows.js"></script>
	<script type="text/javascript">

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
			alert("��ѡ����Ҫ�޸ĵĳɼ���");
			return;
		}
		if (count > 1) {
			alert("һ��ֻ���޸�һ���ɼ���");
			return;
		}
		if (count == 1) {
			window.self.location = "mark.do?p=edit&id=" + 
			                        document.getElementsByName("selectFlag")[j].value + 
			                        "&pageNo=${markForm.pageNo}";
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
			alert("��ѡ����Ҫɾ���ĳɼ���");
			return;
		}
		if (window.confirm("ȷ��ɾ����")) {
			with (document.getElementById("markForm")) {
				method = "post";
				action = "mark.do?p=delete&pageNo=${markForm.pageNo}";
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
		with (document.getElementById("markForm")) {
			method = "post";
			action = "mark.do?p=list&pageNo=1";
			submit();
		}
	}
	
	function resetItem() {
		window.self.location = "mark.do?p=analyse";
	}
	
	function myOnkeypress() {
		if (window.event.keyCode == 13) {
			queryItem();
		}
	}
	
	function topPage() {
		window.self.location = "mark.do?p=list&pageNo=${pageModel.topPageNo}"
	}
	
	function previousPage() {
		window.self.location = "mark.do?p=list&pageNo=${pageModel.previousPageNo}"
	}	
	
	function nextPage() {
		window.self.location = "mark.do?p=list&pageNo=${pageModel.nextPageNo}"
	}
	
	function bottomPage() {
		window.self.location = "mark.do?p=list&pageNo=${pageModel.bottomPageNo}"
	}
	
	</script>
  </head>
  
  <body>

    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="60%" align="center" border="0">
      <TBODY>
      <TR>
        <TD width="522" class="p1" height="2" nowrap><img src="images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>�ɼ�����</B></TD>
      </TR>
      </TBODY>
    </TABLE>
    
    <hr width="80%">
    
	<%@ include file="/commons/messages.jsp" %>
    
    <form name="markForm" id="markForm" >
    
    <input type="hidden" name="flag" id="flag" value="true">
    	
    <TABLE class=small cellSpacing="1" cellPadding="2" width="80%" align="center" bgColor="#000000" border="0">
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
          		<option value="">--��ѡ��--</option>
         		<c:forEach items="${drp:getCourseList()}" var="item" >
         			<option value="${item.id}">${item.name}</option>
        		</c:forEach>
        	</select>
        	<font color="#FF0000">ѧ��:</font>
            <select name="studentId" class="select1" id="studentId">
          		<option value="">--����ѡ��༶--</option>
        	</select>
        	<font color="#FF0000">ѧ��:</font>&nbsp;&nbsp;
            <select name="semester" class="select1" id="semester">
          		<option value="">--��ѡ��--</option>
        	</select>&nbsp;&nbsp;
            <input name="btnQuery" type="button" class="BigButton" id="btnQuery"  value="��ѯ" onClick="queryItem()">
            <input name="btnReset" type="button" class="BigButton" id="btnReset"  value="���ܷ���" onClick="resetItem()">
          </TD>
      </TR> 
      </TBODY>
    </TABLE>
    
    <p>
     
    <TABLE class=small cellSpacing="1" cellPadding="2" width="80%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
      	  <TD class="TableSeparator" width="5%" align="center"><input type="checkbox" name="ifAll" onClick="checkAll()" ></TD>
      	  <TD class="TableSeparator" width="25%" align="center"><strong>�γ�</strong></TD>
      	  <TD class="TableSeparator" width="25%" align="center"><strong>�༶</strong></TD>
      	  <TD class="TableSeparator" width="15%" align="center"><strong>ѧ��</strong></TD>
      	  <TD class="TableSeparator" width="15%" align="center"><strong>ѧ��</strong></TD>
      	  <TD class="TableSeparator" width="20%" align="center"><strong>����</strong></TD>
      </TR>
      
      <c:forEach items="${pageModel.list}" var="item">
      <TR>
      	  <TD class=TableData align="center"><input type="checkbox" name="selectFlag" id="selectFlag" class="checkbox1" value="${item.id }"></TD>
	      <TD class=TableData align="center">${ item.course.name }</TD>
	      <TD class=TableData align="center">${ item.student.team.name }</TD>
	      <TD class=TableData align="center">${ item.student.code }</TD>
	      <TD class=TableData align="center">${ item.student.name }</TD>
	      <TD class=TableData align="center">${ item.score }</TD>
	      
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
        	<input name="btnDelete" type="button" class="BigButton" id="btnDelete" value="ɾ��" onClick="deleteItem()">
        	<input name="btnModify" type="button" class="BigButton" id="btnModify" value="�޸�"  onClick="modifyItem()">
      	  </TD>
      </TR>
     </TBODY>
	</TABLE>
	</form>
  </body>
</html>


