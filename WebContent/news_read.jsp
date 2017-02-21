<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@  taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${newsInfo.title}</title>
<link type="text/css" rel="stylesheet" href="css/ryougi_css.css" />
<link type="text/css" rel="stylesheet" href="css/global.css" />
<link type="text/css" rel="stylesheet" href="css/font-awesome.min.css" />
</head>
<body>
	<div id="main_container">
		<div id="banner" class="article_banner">
			<div id="banner_logo"></div>
			<div id="banner_nav">
				<ul class="banner_nav_level1">
					<li class="banner_nav_level1_item">り
						<ul class="banner_nav_level2">
							<li><a>り</a></li>
							<li><a>り</a></li>
							<li><a>り</a></li>
						</ul>
					</li>
					<li class="banner_nav_level1_item">ょ
						<ul class="banner_nav_level2">
							<li></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>
					</li>
					<li class="banner_nav_level1_item">う
						<ul class="banner_nav_level2">
							<li></li>
							<li></li>
						</ul>
					</li>
					<li class="banner_nav_level1_item">ぎ
						<ul class="banner_nav_level2">
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<div id="main" class="article_main">
			<div id = "article">
				<div id="article_head">
					<time><s:date name="#session.newsInfo.createDate" format="MM-dd-yyyy"/></time>
					<h1>${newsInfo.title}</h1>
					<p>${newsInfo.summary}</p>
				</div>
				<div id="article_tags">
					<a href="">${newsInfo.topic.name}</a>
					<div>
						<a data-ga-action="facebook" data-ga-label="sidebar" href="#" onclick="window.open('http://www.facebook.com/sharer.php?u=http%3A%2F%2FRyougiChan.com%2FNewsSystem', '_blank','height=570, width=520, scrollbars=yes, status=no');" data-provider="facebook" rel="nofollow" title="Share on Facebook"><i class="fa fa-facebook-square fa-3x"></i></a>
						<a data-ga-action="twitter" data-ga-label="sidebar" href="#" onclick="window.open('http://www.twitter.com/intent/tweet?url=http%3A%2F%2FRyougiChan.com%2FNewsSystem&amp;via=RyougiChan','_blank','height=570, width=520, scrollbars=yes, status=no');" data-provider="twitter" rel="nofollow" title="Share on Twitter"><i class="fa fa-twitter-square fa-3x"></i></a>
						<a data-ga-action="email" data-ga-label="sidebar" href="mailto:?subject=An%20interesting%20article%20from%20RyougiChan%20News&amp;body=I%20want%20to%20share%20this%20news%20from%20RyougiChan%20with%20you%3A%20http%3A%2F%2FRyougiChan.com%2FNewsSystem" data-provider="mail" target="_blank" rel="nofollow" title="Share by email"><i class="fa fa-envelope-square fa-3x"></i></a>
					</div>
				</div>
				<div id="article_body">
					<span>By ${newsInfo.author}</span>
					<p>${newsInfo.content}</p>
				</div>
			</div>
		</div>
		<div id="footer" class="article_footer">
			<div>
				Sun Yat-sen University Guangzhou,P.R.China &nbsp; |&nbsp; E-mail: <a
					href="mailto:ryougi.chan.fire@gmail.com">ryougi.chan.fire@gmail.com</a>
			</div>
			<div class="contact">
				Technic: <a href="">RyougiChan </a> <a href="login.jsp">Management</a>
				&nbsp; | &nbsp;Copyright © <a href="">RyougiChan</a>
			</div>
		</div>
	</div>

</body>
</html>