// 设置banner logo 的连接指向首页
$('#banner_logo').on('click', function() {
	var root = getRootPath();
	window.parent.location.href =  root + "/index.jsp";
})

// 获取项目根路径
function getRootPath() {
	// 获取当前网址
	var curPath = window.document.location.href;
	// 获取主机地址之后的目录
	var pathName = window.document.location.pathname;
	var pos = curPath.indexOf(pathName);
	// 获取主机地址
	var localhostPaht = curPath.substring(0, pos);
	// 获取带"/"的项目名
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}