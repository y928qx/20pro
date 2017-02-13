<%@ page language="java" pageEncoding="gb2312"%>
<%@ include file="/commons/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>
	
	<script src="script/windows.js"></script>
	<script type="text/javascript">

	function addItem() {
		window.self.location = "courseSchedule.do?p=edit&teamId=${team.id}";
	}
	
	function deleteItem() {
		var flag = false;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				flag = true;
			}		
		}
		if (!flag) {
			alert("��ѡ����Ҫɾ���Ŀγ̣�");
			return;
		}
		if (window.confirm("ȷ��ɾ����")) {
			with (document.getElementById("courseScheduleForm")) {
				method = "post";
				action = "courseSchedule.do?p=delete&id=${courseSchedule.id}";
				submit();
			}
		}
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
			alert("��ѡ����Ҫ�޸ĵĿγ̣�");
			return;
		}
		if (count > 1) {
			alert("һ��ֻ���޸�һ���γ̣�");
			return;
		}
		if (count == 1) {
			window.self.location = "courseSchedule.do?p=edit&id=" + 
			                        document.getElementsByName("selectFlag")[j].value + 
			                        "&pageNo=${courseScheduleForm.pageNo}";
		}
	}
	
	function checkAll() {
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			document.getElementsByName("selectFlag")[i].checked = document.getElementById("ifAll").checked;
		}
	}
	
	function queryItem() {
	
		window.self.location = "teacher.do?p=detail&teamId=${team.id}&id=${teacher.id}";
	}
	
	function resetItem() {
		document.getElementsByName("query").value = "";
	}
	
	function myOnkeypress() {
		if (window.event.keyCode == 13) {
			queryItem();
		}
	}
	
	</script>
  </head>
  
  <body>

    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="60%" align="center" border="0">
      <TBODY>
      <TR>
        <TD width="522" class="p1" height="2" nowrap><img src="images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>�༶����&gt;&gt;�༶�γ̹���&gt;&gt;${team.name }�α���Ϣ</B></TD>
      </TR>
      </TBODY>
    </TABLE>
    
    <hr width="60%">
    
	<%@ include file="/commons/messages.jsp" %>
    
    <form name="courseScheduleForm" id="courseScheduleForm" >
    
    <input type="hidden" name="teamId" value="${team.id }">
    
    <TABLE class=small cellSpacing="1" cellPadding="2" width="60%" align="center" bgColor="#000000" border="0">
      <TBODY>  
      <TR>
          <TD class=TableData align=center>
            <font color="#FF0000">��ʦ:</font>&nbsp;&nbsp;
            <select name="teacherId" class="select1" id="teacherId">
          		<option value="">--��ѡ��--</option>
         		<c:forEach items="${courseSchedules}" var="item" >
         			<option value="${item.teacher.id}">${item.teacher.name}</option>
        		</c:forEach>
        	</select>
            <input name="btnQuery" type="button" class="BigButton" id="btnQuery"  value="��ѯ" onClick="queryItem()">
            <input name="btnReset" type="button" class="BigButton" id="btnReset"  value="����" onClick="resetItem()">
          </TD>
      </TR> 
      </TBODY>
    </TABLE>
    
    <p>
    
    <TABLE class=small cellSpacing="1" cellPadding="2" width="60%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
      	  <TD class="TableSeparator" width="5%" align="center"><input type="checkbox" name="ifAll" onClick="checkAll()" ></TD>
		  <TD class="TableSeparator" width="25%" align="center"><strong>����γ�</strong></TD>
		  <TD class="TableSeparator" width="25%" align="center"><strong>�ον�ʦ</strong></TD>
		  <TD class="TableSeparator" width="25%" align="center"><strong>ѧ��</strong></TD>
		  <TD class="TableSeparator" width="25%" align="center"><strong>ѧ��</strong></TD>
      </TR>
      
      <c:forEach items="${courseSchedules}" var="item">
      <TR>
      	  <TD class=TableData align="center" ><input type="checkbox" name="selectFlag" id="selectFlag" class="checkbox1" value="${item.id }"></td>
	      <TD class=TableData align="center">${ item.course.name }</TD>
	      <TD class=TableData align="center">${ item.teacher.name }</TD>
	      <TD class=TableData align="center">${ item.semester }</TD>
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
      	    <input name="btnAdd" type="button" class="BigButton" id="btnAdd"  value="���" onClick="addItem()">
        	<input name="btnDelete" type="button" class="BigButton" id="btnDelete" value="ɾ��" onClick="deleteItem()">
      	  </TD>
      </TR>
     </TBODY>
	</TABLE>
	</form>
  </body>
</html>
