<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>系统登录页面</title>
		<!-- 资源包 -->
		<link href="/JavaPrj_10/ext/resources/css/ext-all.css" rel="stylesheet">
		<link href="/JavaPrj_10/ext/resources/css/xtheme-gray.css"
			rel="stylesheet">
		<script type="text/javascript"
			src="/JavaPrj_10/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/JavaPrj_10/ext/ext-all.js"></script>
		<script type="text/javascript"
			src="/JavaPrj_10/ext/build/locale/ext-lang-zh_CN.js"></script>

		<style type="text/css">
/* .user {
	background: url(images/man.gif) no-repeat 1px 2px;
}

.key {
	background: url(images/key.gif) no-repeat 1px 2px;
}

.key,.user {
	background-color: #FFFFFF;
	padding-left: 20px;
	font-weight: bold;
	color: # 000033;
} */
</style>
	</head>
	<body>
		<script type="text/javascript" src="/JavaPrj_10/login.js"></script>
		<div id="loginWin" style="height:500px; width:500px; margin:0 auto;"></div>
		<div id="loading-mask" style="">
			<div id="loading">
				<div style="text-align: center; padding-top: 26%">
					<img src="images/Loader.gif" width="32" height="32"
						style="margin-right: 8px;" align="absmiddle" />
					Loading...
				</div>
			</div>
		</div>
	</body>
</html>
