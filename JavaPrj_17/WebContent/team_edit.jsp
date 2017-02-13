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
			alert("�༶���Ʋ���Ϊ��!");
			document.getElementById("name").focus();
			return;
		} 
		with (document.getElementById("teamForm")) {
			method = "post";
			action = "team.do?p=save&pageNo=${teamForm.pageNo}";
			submit();
		}
	}
	
	function goBack() {
		window.self.location = "team.do?p=list&pageNo=${teamForm.pageNo}";
	}
	
	
</script>
  </head>
  
  <body> 
    
    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="30%" align="center" border="0">
      <TBODY>
      <tr> 
        <td width="522" class="p1" height="25" nowrap><img src="images/mark_arrow_03.gif" width="14" height="14">&nbsp;<b>�༶����&gt;&gt;���Ӱ༶</b></td>
      </tr>
      </TBODY>
    </TABLE>  
    <hr width="30%">
    
    <%@ include file="/commons/messages.jsp" %>
    
    <form name="teamForm" id="teamForm">
  
  	<input type="hidden" name="id" value="${team.id }">
  	
    <TABLE class=small cellSpacing="1" cellPadding="2" width="30%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
          <TD class=TableLabel width="35%">�༶����</TD>
          <TD class=TableData><input id="name" name="name" size="24" value="${team.name }" class="BigInput" /></TD>
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
