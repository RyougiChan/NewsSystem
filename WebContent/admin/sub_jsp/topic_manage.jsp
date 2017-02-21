<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑新闻</title>
<link type="text/css" rel="stylesheet" href="../../css/global.css" />
<link type="text/css" rel="stylesheet" href="../css/admin.css" />
</head>
<body>
	<div id="right_container">
		<div id="right_list">
			<ul>
				<li>
					<p>主题</p>
					<p>操作</p>
				</li>
				<s:iterator id="item" value="#session.topicList">
					<li><p>
							<input class="topicName" name="topic.name" value="${item.name}" type="text" disabled onblur="updateTopic(${item.id}, this)" />
							<input class="topicId" value="${item.id}" type="hidden"/>
						</p>
						<p><a onclick="editTopic(${item.id}, this)"> 编辑 </a> <a onclick="deleteTopic(${item.id})"> 删除 </a></p></li>
				</s:iterator>
			</ul>
			<div id="list_nav">
				<ul id="pagination" class="pagination-sm"></ul>
			</div>
		</div>
		<div id="right_form">
			<h1>管理主题</h1>
			<form action="queryTopic" method="POST">
				<div id="keywords">
					<div class="label">关键字</div>
					<input type="text" name="topic.name" /> <input class="inputBtn"
						type="submit" value="检索" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="../../js/jquery.twbsPagination.min.js"></script>
	<script type="text/javascript" src="../script/admin.js"></script>
</body>
</html>