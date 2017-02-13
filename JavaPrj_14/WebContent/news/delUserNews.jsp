<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.sql.*" %>
<%@ include file="check.jsp" %>


<jsp:useBean id="userN" scope="page" class="com.sanqing.news.UserNews"/>

<%
	int newsId=servlet.requestInt(request,"newsId");
	userN.delUserNews(servlet.requestInt(request,"newsId"));
	servlet.responseUrl(response,"personal.jsp");
%>