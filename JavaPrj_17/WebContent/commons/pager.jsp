<%@ page language="java" pageEncoding="gb2312"%>
<%@ include file="/commons/taglibs.jsp" %>

<TABLE border="0">
      <TBODY>
      <TR>
      	  <TD class=TableData align="center">
      	    <html:form action="${requestName }.do" method="post" > 
	      	    ��${pageModel.totalRecords }����¼&nbsp;&nbsp;��${pageModel.totalPages }ҳ&nbsp;&nbsp;��${pageModel.pageNo }ҳ&nbsp;&nbsp;&nbsp;&nbsp;
	      	  	<a href="${requestName }.do?p=list&pageNo=${pageModel.topPageNo }&pageSize=3"> ��ҳ </a> &nbsp;&nbsp;
				<a href="${requestName }.do?p=list&pageNo=${pageModel.previousPageNo}&pageSize=3"> ��һҳ </a> &nbsp;&nbsp;
				<a href="${requestName }.do?p=list&pageNo=${pageModel.nextPageNo}&pageSize=3"> ��һҳ </a> &nbsp;&nbsp;
				<a href="${requestName }.do?p=list&pageNo=${pageModel.bottomPageNo }&pageSize=3"> βҳ </a> &nbsp;&nbsp;	
		    	
		   	    <html:hidden property="p" value="list"/>
		    	
	     		<input type=text size=4 name="pageNo" />
	     		<input type="submit" value="go" />
		 	</html:form>
      	  </TD>
      </TR>
     </TBODY>
</TABLE>