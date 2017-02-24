<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内容管理系统</title>
<link type="text/css" rel="stylesheet" href="../../css/global.css" />
<link type="text/css" rel="stylesheet" href="../css/admin.css" />
<sx:head />
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
							<a href="newsscan?id=${news.id}"> ${news.title}</a>
						</p>
						<p><s:date name="%{#news.createDate}" format="MM/dd/yyyy" /></p>
						<p>已审核</p>
						<p id="operation">
							<a href="newsedit?id=${news.id}">编辑</a> <a href=""
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
				<li><span class="admin_account"></span><div><p>登录账号</p><p>${admin.loginName}</p></div></li>
				<li><span class="admin_group"></span><div><p>用户组别</p><p></p></div></li>
				<li><span class="true_name"></span><div><p>真实姓名</p><p></p></div></li>
				<li><span class="login_time"></span><div><p>登录时间</p><p>${time}</p></div></li>
				<li><span class="login_ip"></span><div><p>登录IP</p><p>${ip}</p></div></li>
			</ul>
		</div>
	</div>
	<input type="hidden" id="totalPages" value="${session.pager8.totalPage}">
	<input type="hidden" id="rowCount" value="${session.pager8.rowCount}">
	<input type="hidden" id="curPage" value="${session.pager8.curPage}">
	<script type="text/javascript" src="../../js/jquery-3.1.0.js"></script>
	<%-- <script type="text/javascript" src="../../js/jquery.twbsPagination.js"></script> --%>
	<script type="text/javascript" src="../../js/jquery.twbsPagination.min.js"></script>
	<script type="text/javascript" src="../script/admin.js"></script>
	<script>
	(function(){
		var yetVisited = $('#rowCount').val() == 0 ? false : true;
		console.log("yetVisited --> "+yetVisited);
	    if (!yetVisited) {
	    	console.log("神TM执行了");
			window.location.href = "queryNews?reqpage=right";
	    }
	    
	    $(document).ready(function() {
	    	// Initial pagination bar
			var totalPages = $('#totalPages').val();
	    	console.log("totalPages="+totalPages);
			$('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 7,
				onPageClick : function(event, page) {
					console.log("当前页="+page);
				}
			}).on('page',  function(event, page) {
				console.log("当前页="+page+"listener");
				window.location.href = "queryNews?reqpage=right&pager.curPage="+page;
			});
		})
		$('#pagination').ready(function() {
			var $nav_item = $($('#pagination').find('li'));
			var $cur_active = $($nav_item.get(2));
			var reset_cur = parseInt($('#curPage').val())+1;
			var $reset_active = $($nav_item.get(reset_cur));
			$cur_active.removeClass('active');
			$reset_active.addClass('active');
		})
	})();
	</script>
</body>
</html>