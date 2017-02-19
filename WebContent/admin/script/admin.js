(function() {
	"use strict"

	$(document).ready(function() {
		$('#pagination').twbsPagination({
			totalPages : 35,
			visiblePages : 7,
			onPageClick : function(event, page) {
				$('#page-content').text('Page ' + page);
			}
		});

		if ($.session.get('delete') === "success") {
			window.prompt("删除成功");
		}

	})
	
	$("#topicName").bind("focusout", function () {
		$("#topicName").attr("disabled", "disabled");
		var renew_name = $('#topicName').val();
		var renew_id = $('#topicId').val();
		var jsp = "sub_jsp/topic_manage.jsp/topicUpdate?id=" + renew_id;
		var flag = window.confirm("确认修改主题: "+renew_name+"?");
		if (flag) {
			window.location.href = jsp;
		}
	});
	
})()

function deleteNews(arg) {
	var flag = window.confirm("确认删除?");
	var jsp = "sub_jsp/news_manage.jsp/newsdelete?id=" + arg;
	if (flag) {
		window.location.href = jsp;
	}
}

function editTopic(arg) {
	console.log("click");
	$("#topicName").removeAttr("disabled");
	$("#topicName").focus();
}

function deleteTopic(arg) {
	var flag = window.confirm("确认删除?");
}