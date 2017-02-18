(function() {
	"use strict"
	$("#inputBtn").bind("click", function() {

	});

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