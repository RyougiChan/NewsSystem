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
	})
	
})()

function deleteNews(arg) {
	var flag = window.confirm("确认删除?");
	var jsp = "newsdelete?id=" + arg;
	if (flag) {
		window.location.href = jsp;
		window.event.returnValue=false;
	}
}

function editTopic(arg0, arg1) {
	$arg1 = $(arg1);
	$topicName = $arg1.parent().siblings().children('.topicName');
	$topicName.removeAttr('disabled');
	$topicName.focus();
}

function updateTopic(arg0, arg1) {
	$arg1 = $(arg1);
	var new_val = $(arg1).val();
	$arg1.attr("disabled", "disabled");
	var jsp = "topicupdate?id=" + arg0 +"&newTopic=" + new_val;
	var flag = window.confirm("确认修改主题?");
	if (flag) {
		window.location.href = jsp;
		window.event.returnValue=false;
	}
}

function deleteTopic(arg) {
	var flag = window.confirm("确认删除?");
	var jsp = "topicdelete?id=" + arg;
	if (flag) {
		window.location.href = jsp;
		window.event.returnValue=false;
	}
}