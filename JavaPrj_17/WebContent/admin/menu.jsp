<%@ page contentType="text/html;charset=Gb2312" %>
<%@ include file="/commons/taglibs.jsp" %>

<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<link href="${ctx}/styles/admin/admin.css" type="text/css" rel="stylesheet">
</head>

<body>
<div id="menu" style="margin-top:10px;">
	<ul>
	<logic:present name="admin" scope="session">
		<li>
			<a href="${ctx}/user.do?p=list&pageNo=1&flag=true" target="mainFrame">�û�����</a>
		</li>
		<li>
			<a href="${ctx}/team.do?p=list&pageNo=1&flag=true" target="mainFrame">�༶����</a>
		</li>
		<li>
			<a href="${ctx}/course.do?p=list&pageNo=1&flag=true" target="mainFrame">�γ̹���</a>
		</li>
		<li>
			<a href="${ctx}/teacher.do?p=list&pageNo=1&flag=true" target="mainFrame">��ʦ����</a>
		</li>
		<li>
			<a href="${ctx}/student.do?p=list&pageNo=1&flag=true" target="mainFrame">ѧ������</a>
		</li>
		<li>
			<a href="${ctx}/mark.do?p=list&pageNo=1&flag=true" target="mainFrame">�ɼ�����</a>
		</li>
		</logic:present>
		
		<logic:present name="teacher" scope="session">
			<li>
				<a href="${ctx}/courseSchedule.do?p=input" target="mainFrame">�ɼ�¼��</a>
			</li>
		</logic:present>
		
		<li>
			<a href="${ctx}/user.do?p=logoff" target="_parent">��¼/�˳�ϵͳ</a>
		</li>
		

	</ul>
</div>
</body>
</html>