<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内容管理系统</title>
<link type="text/css" rel="stylesheet" href="../css/global.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />
</head>
<body>
	<div id="right_container">
		<div id="right_list">
			<ul>
				<li>
					<p>标题</p>
					<p>更新时间</p>
					<p>状态</p>
					<p>操作</p>
				</li>
				<s:iterator id="news" value="#session.newsInfoList8">
					<li><p id="title">
							<a href="newsread?id=${news.id}"> ${news.title}</a>
						</p>
						<p><s:date name="%{#news.createDate}" format="yy-MM-dd" /></p>
						<p>已审核</p>
						<p id="operation">
							<a href="newsedit?id=${news.id}">编辑</a> <a
								href="newsread?id=${news.id}"> 查看</a> <a href=""
								onclick="deleteNews(${news.id})"> 删除</a>
						</p></li>
				</s:iterator>
			</ul>
			<div id="list_nav">
				<ul id="pagination" class="pagination-sm"></ul>
			</div>
		</div>
		<div id="right_form">
			<h1>管理员档案</h1>
			<ul>
				<li class="admin_account"><div>登录账号${sessionScope.admin.loginName}</div></li>
				<li class="admin_group"><div>用户组别</div></li>
				<li class="true_name"><div>真实姓名</div></li>
				<li class="login_time"><div>登录时间</div></li>
				<li class="login_ip"><div>登录IP</div></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="../js/jquery.twbsPagination.min.js"></script>
	<script type="text/javascript" src="script/admin.js"></script>
</body>
</html>