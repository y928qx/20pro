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
    ����:<span class="current">��ҳ>>${commodity.commodityName}</span>
    
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
     <div class="center_title_bar">${commodity.commodityName}</div>
     <div class="prod_box_big">
       <div class="top_prod_box_big"></div>
       <div class="center_prod_box_big">
         <div class="product_img_big"> 
             <div><img src="showImg.action?commodityID=${commodity.commodityId}" alt="" title="" border="0" /></div>
         </div>
         <div class="details_big_box">
           <div class="product_title_big">${commodity.commodityName}</div>
           <div class="specifications"> 
           	���ɳ���: <span class="blue">${commodity.manufacturer}</span><br />
              ��Ʒ���: <span class="blue">${commodity.commodityId}</span><br />
              ������: <span class="blue">${commodity.commodityAmount}</span><br />
              ʣ������: <span class="blue">${commodity.commodityLeaveNum}</span><br />
              �ϼ�ʱ��: <span class="blue"><s:date name="commodity.regTime" format="yyyy��MM��dd��"/></span><br />
           </div>
           <div class="prod_price_big"><span class="reduce">${commodity.commodityPrice}</span> <span class="price">${commodity.fcPrice}</span></div>
           <a href="addToCar.action?commodityID=${commodity.commodityId}" class="addtocart">��ӵ����ﳵ</a></div>
            </div>
       <div class="bottom_prod_box_big"></div>
     </div>
     <div class="center_title_bar">��Ʒ����</div>
	     <div class="prod_box_big">
			${commodity.commodityDepict}
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