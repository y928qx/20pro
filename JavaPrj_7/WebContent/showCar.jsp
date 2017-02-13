<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>���ɹ�����</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>

<div id="main_container">
  <div class="top_bar"></div>
	<div id="header">
	  <!-- end of oferte_content-->
</div>
    
   <div id="main_content"> 
   
            <div id="menu_tab">
            <div class="left_menu_corner"></div>
                    <ul class="menu">
                         <li><a href="goIndex.action" class="nav1">��ҳ</a></li>
                         <li class="divider"></li>
                         <li><a href="#" class="nav2">���߹���</a></li>
                         <li class="divider"></li>
                         <li><a href="#" class="nav5">�ҵĹ��ﳵ</a></li>
                         <li class="divider"></li>
                         <li><a href="#" class="nav4">�û���Ϣ</a></li>
                         <li class="divider"></li>
                         <li><a href="#" class="nav3">�û���¼</a></li>
                         <li class="divider"></li>                         
                         <li><a href="#" class="nav6">�û�ע�� </a></li>
                         <li class="divider"></li>
                         <li></li>
                         <li class="divider"></li>
                    </ul>

             <div class="right_menu_corner"></div>
            </div><!-- end of menu tab -->
            
    <div class="crumb_navigation">
    ����:<span class="current">��ҳ>>�ҵĹ��ﳵ</span>
    
    </div>        
    
    
    <div class="left_content">
    <div class="title_box">��Ʒ����</div>
        <ul class="left_menu">
       <s:iterator value="commodityClasses" var="commodityClass" status="stu">
        	<s:if test="#stu.odd">
        		<li class="odd">
        			<a href="showByClass.action?commodityClassID=${commodityClass.commodityClassId}">
        				${commodityClass.commodityClassName}
        			</a>
        		</li>
        	</s:if>
        	<s:else>
        		<li class="even">
        			<a href="showByClass.action?commodityClassID=${commodityClass.commodityClassId}">
        				${commodityClass.commodityClassName}
        			</a>
        		</li>
        	</s:else>	
        </s:iterator>
         <li class="odd"></li>
        </ul> 
     <div class="banner_adds">
     
     <a href="#"></a>     </div>    
   </div><!-- end of left content -->
   
     <div class="center_content">
     <div class="center_title_bar">�ҵĹ��ﳵ</div>
     <div class="prod_box_big">
     	<div class="top_prod_box_big"></div>
	 	<div class="center_prod_box_big"> 
      <table>
		<s:if test="#session.car.isEmpty">
			<td colspan="5">���ﳵ����û����Ʒ��</td>
		</s:if>
		<s:else>
		<tr>
			<td width="147">��Ʒ���</td>
			<td width="144">��Ʒ����</td>
			<td width="124">��������</td>
			<td width="119">��Ʒ�۸�</td>
			<td width="119">�Ƴ�����Ʒ</td>
		</tr>
		<s:iterator var="com" value="#session.car">
		<tr>
			<td width="147">${com.commodityId}</td>
			<td width="144">${com.commodityName}</td>
			<td width="124">${com.manufacturer}</td>
			<td width="119">${com.fcPrice}</td>
			<td width="119"><a href="deleteFromCar.action?commodityID=${com.commodityId}">�Ƴ�</a></td>
		</tr>
		</s:iterator>
		</s:else>
	  </table>
	  	<div align="right"><a href="" class="addtocart">�����������</a></div>
	  </div>
	   <div class="bottom_prod_box_big"></div>
     </div>
     </div>
     
   <!-- end of center content -->
   
   <div class="right_content">
   		<div class="shopping_cart">
        	<div class="cart_title">���ﳵ</div>
            
            <div class="cart_icon"><a href="#" title=""><img src="images/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a></div>
        </div>
   		<div class="title_box">�û���¼</div>  
        <div class="border_box">
		<p>�û�����<input name="username" type="text" size="15" /></p>
		<p>��&nbsp;&nbsp;&nbsp;�룺<input name="username" type="password" size="15" /></p>
        <p><input name="�ύ" type="submit" value="��¼" /><input name="����" type="reset" value="����" />
        </p>
     </div>  
   
        <div class="border_box"></div>
   </div>
   <!-- end of right content -->   
   
            
   </div><!-- end of main content -->
   
   
   
  <div class="footer"></div>                 


</div>
<!-- end of main_container -->
</body>
</html>