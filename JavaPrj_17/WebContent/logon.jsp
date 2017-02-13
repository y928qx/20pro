<%@ page language="java" pageEncoding="gb2312"%>
<%@ include file="/commons/taglibs.jsp" %>

<%
	session.removeAttribute("user");
%>

<html>
  <head>
    <title>${CompanyName}--${ProjectName}</title>
    <%@ include file="/commons/meta.jsp" %>
  </head>
  
  <body> 
    
    <div id="content">
    
    <TABLE cellSpacing="1" cellPadding="2" width="50%" align="center" border="0">
      <TBODY>
      <TR>
         <TD align=center><Strong><h2>�û���¼</h2></Strong></TD>
      </TR>
      </TBODY>
    </TABLE>  
    <hr width="90%">

	<%@ include file="/commons/messages.jsp" %>

    <html:form action="user.do" method="post">
    	<html:hidden property="p" value="logon"/>
    	<html:hidden property="type" value="1"/>
     
    <TABLE class=small cellSpacing="1" cellPadding="2" width="35%" align="center" bgColor="#000000" border="0">
      <TBODY>
      <TR>
          <TD class=TableLabel width="30%">��¼����</TD>
          <TD class=TableData><html:text property="name" styleClass="BigInput" size="24"/>
      	      <font color="#CC3300">
      	  	    <html:errors property="name"/>
      	      </font>
      	  </TD>
      </TR>
      <TR>
          <TD class=TableLabel>���룺</TD>
          <TD class=TableData><br><html:text property="password" styleClass="BigInput" size="24" />
              <font color="#CC3300">
      	  	    <html:errors property="password"/>
      	      </font>
      	  <br></TD> 
      </TR>
      <TR>
          <TD class=TableLabel>��֤�룺</TD>
          <TD class=TableData><br><html:text property="checkcode"></html:text>
		  	<img src="image.jsp">
      	  </TD> 
      </TR>
      <TR>
          <TD class=TableButton colspan=2 align=center>
              <html:submit styleClass="BigButton">��¼</html:submit>
          </TD>
      </TR>
      </TBODY>
    </TABLE>
    
    </html:form> 
    </div>    
  </body>
</html>

