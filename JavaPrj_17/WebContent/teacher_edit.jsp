<%@ page language="java" pageEncoding="gb2312"%>
<%@ include file="/commons/taglibs.jsp" %>


<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>
    
    <script src="script/client_validate.js"></script>
	<script type="text/javascript">
	
	function addItem() {
		if (trim(document.getElementById("name").value) == "") {
			alert("��ʦ���Ʋ���Ϊ��!");
			document.getElementById("name").focus();
			return;
		} 
		with (document.getElementById("teacherForm")) {
			method = "post";
			action = "teacher.do?p=save&pageNo=${teacherForm.pageNo}";
			submit();
		}
	}
	
	function goBack() {
		window.self.location = "teacher.do?p=list&pageNo=${teacherForm.pageNo}";
	}
	
	
</script>
  </head>
  
  <body> 
    
    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="30%" align="center" border="0">
      <TBODY>
      <tr> 
        <td width="522" class="p1" height="25" nowrap><img src="images/mark_arrow_03.gif" width="14" height="14">&nbsp;<b>��ʦ����&gt;&gt;���ӽ�ʦ</b></td>
      </tr>
      </TBODY>
    </TABLE>  
    <hr width="30%">
    
    <%@ include file="/commons/messages.jsp" %>
    
    <form name="teacherForm" id="teacherForm">
  
  	<input type="hidden" name="id" value="${teacher.id }">
  	
    <TABLE class=small cellSpacing="1" cellPadding="2" width="30%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
          <TD class=TableLabel width="35%">��ʦ������</TD>
          <TD class=TableData><input id="name" name="name" size="24" value="${teacher.name }" class="BigInput" /></TD>
      </TR>

      <TR>
          <TD class=TableButton colspan=2 align=center>
            <input type="button" value="����" class="BigButton" onclick="addItem()">
			<input type="button" value="����" class="BigButton" onClick="goBack()">
          </TD>
      </TR>
      </TBODY>
    </TABLE>
    
    </form>
   </div>    
  </body>
</html>
