<%@ page language="java" pageEncoding="gb2312"%>
<%@ include file="/commons/taglibs.jsp" %>

<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>
    
    <script src="script/client_validate.js"></script>
	<script type="text/javascript">
	
	function addItem() {
		if (trim(document.getElementById("score").value) == "") {
			alert("��������Ϊ��!");
			document.getElementById("name").focus();
			return;
		} 
		if(!isInteger(document.getElementById("score").value)) {
    		alert('����������������');
    		return false;
    	}
		with (document.getElementById("markForm")) {
			method = "post";
			action = "mark.do?p=modify";
			submit();
		}
	}

	//�������
	function  isInteger(strInteger){
        var  newPar=/^(-|\+)?\d+$/;
        return  newPar.test(strInteger);
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
    
    <form name="markForm" id="markForm">
  
  	<input type="hidden" name="id" value="${mark.id }">
  	
    <TABLE class=small cellSpacing="1" cellPadding="2" width="30%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
          <TD class=TableLabel width="35%">�γ̣�</TD>
          <TD class=TableData>${mark.course.name }</TD>
      </TR>
      <TR>
          <TD class=TableLabel width="35%">ѧ�ţ�</TD>
          <TD class=TableData>${mark.student.code }</TD>
      </TR>
      <TR>
          <TD class=TableLabel width="35%">ѧ����</TD>
          <TD class=TableData>${mark.student.name }</TD>
      </TR>
      <TR>
          <TD class=TableLabel width="35%">������</TD>
          <TD class=TableData><input id="score" name="score" size="24" value="${mark.score }" class="BigInput" /></TD>
      </TR>

      <TR>
          <TD class=TableButton colspan=2 align=center>
            <input type="button" value="����" class="BigButton" onclick="addItem()">
			<input type="button" value="����" class="BigButton" onClick="history.back(-1);">
          </TD>
      </TR>
      </TBODY>
    </TABLE>
    
    </form>
   </div>    
  </body>
</html>

