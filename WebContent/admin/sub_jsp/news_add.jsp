<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="../../css/global.css" />
<link type="text/css" rel="stylesheet" href="../css/admin.css" />
</head>
<body>

	<div id="right_container">
		<div id="right_form">
			<h1>添加新闻</h1>
			<form action="addNews" method="POST">
				<div id="title">
					<div class="label">标题</div>
					<input type="text" name="newsInfo.title" /><b> *</b>
				</div>
				<div id="topic">
					<div class="label">主题</div>
					 <s:select name="newsInfo.topic.id" list="#session.topicList" listKey="id" listValue="name"></s:select>
				</div>
				<div id="summary">
					<div class="label">摘要</div>
					<textarea name="newsInfo.summary" id="summaryBox" cols="100"
						rows="5"></textarea>
				</div>
				<div id="content">
					<div class="label">内容</div>
					<textarea name="newsInfo.content" id="contentBox" cols="100"
						rows="10"></textarea>
				</div>
				<div id="submitBtn">
					<input id="inputBtn" class="inputBtn" type="submit" value="添加" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="../script/admin.js"></script>
</body>
</html>