<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/share/taglib.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="<%=basePath%>style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=basePath%>script/public.js"></script>
<script type="text/javascript">
		//��ָ���ķ�ҳҳ��
	function topage(page){
		var form = document.forms[0];
		form.page.value=page;
		form.submit();
	}
</script>
<title>��Ʒ����</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=<%=basePath%>images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=<%=basePath%>images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7> ��Ʒ����<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
            <TD align=middle width=11 background=<%=basePath%>images/title_middle.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
            <TD align=middle background=<%=basePath%>images/title_right.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD width="82%" height=14 align=right vAlign=center noWrap>
            </TD>
            <TD width="18%" align=right vAlign=center noWrap>��</TD>
          </TR>
          <TR>
            <TD height=14 align=right vAlign=center noWrap>
            	<!-- ����������ѯ�� -->
            </TD>
            <TD height=14 align="left" vAlign=center noWrap>
            <a href="#" onclick="openWin('productmanage_addUI.do','addperson',600,200);">������Ʒ��Ϣ</a>
            </TD>
          </TR>
          <TR>
            <TD height=28 colspan="2" align=right vAlign=center noWrap background="<%=basePath%>images/list_middle.jpg">&nbsp;&nbsp;
            <!-- ��������������ҳ������ -->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <form action="product.do" method="post">
      <s:hidden name="query"/>
      <s:hidden name="page"/>
      <s:hidden name="productcode"/>
      <s:hidden name="producttypename"/>
      <s:hidden name="productname"/>
      <s:hidden name="producingarea"/>
      <s:hidden name="productowner"/>
      <s:hidden name="unit"/>
      <s:hidden name="price"/>
      <s:hidden name="quantity"/>
      <s:hidden name="otherInfo"/>
      <table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
          <!-- �б������ -->
	      <tr bgcolor="#EFF3F7" class="TableBody1">
		      <td width="5%" height="37" align="center"><b>���</b></td>
		      <td width="10%" height="37" align="center"><B>����</B></td>
		      <td width="10%" height="37" align="center"><B>����</B></td>
		      <td width="10%" height="37" align="center"><B>��������</B></td>
		      <td width="10%" height="37" align="center"><B>������</B></td>
		      <td width="10%" height="37" align="center"><B>��λ</B></td>
		      <td width="10%" height="37" align="center"><B>�۸�</B></td>
		      <td width="10%" height="37" align="center"><B>����</B></td>
		      <td width="10%" height="37" align="center"><B>����</B></td>
              <td width="10%" height="37" align="center"><b>����</b></td>
          </tr>
          <!-- �б������� -->
         <s:if test="null != #request.pageView.records && !#request.pageView.records.isEmpty() ">
          <s:iterator value="#request.pageView.records" id="entity"> 
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		      <td align="center" vAlign="center">${entity.productNO }</td>
	          <td align="center" vAlign="center">${entity.productType.producttypeName }</td>
	          <td align="center" vAlign="center">${entity.productName }</td>
	          <td align="center" vAlign="center">${entity.producingArea }</td>
	          <td align="center" vAlign="center">${entity.productOwner }</td>
	          <td align="center" vAlign="center">${entity.unit }</td>
	          <td align="center" vAlign="center">${entity.price }</td>
	          <td align="center" vAlign="center">${entity.quantity }</td>
	          <td align="center" vAlign="center">${entity.otherInfo }</td>
	          <td align="center" vAlign="center"><a href="#" onclick="del('productmanage_del.do?productNO=${entity.productNO}');">ɾ��</a>
	          <a href="#" onclick="openWin('productmanage_updateUI.do?productNO=${entity.productNO}','addperson',600,200);">�޸�</a>
	          </td>
        </tr>
        </s:iterator>
		</s:if>
        <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	    <s:else>
	    <tr>
	    	<td colspan="10" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	    </s:else>
      </table>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD height=28 align=right vAlign=center noWrap background="<%=basePath%>images/list_middle.jpg">&nbsp;&nbsp;
            <!-- ��������������ҳ������ -->
            <%@ include file="/share/fenye.jsp" %>
    		</TD>
          </TR>
        </TBODY>
      </TABLE>
      </form>
</center>

</body>

</html>
