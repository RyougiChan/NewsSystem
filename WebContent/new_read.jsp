<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>标题：${newsInfo.title}</li>
		<li>作者： ${newsInfo.author}</li>
		<li>类型：${newsInfo.topic.name}</li>
		<li>发布时间：${newsInfo.createDate}</li>
		<li>摘要：${newsInfo.summary}</li>
	</ul>
	<div>
		${newsInfo.content}
	</div>
</body>
</html>