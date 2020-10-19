<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="utf-8">
	<title>主页</title>
	<link rel ="stylesheet" type ="text/css" href ="css/main.css"/>

  </head>
  
  <body>
	  <div id ="header">
		  <div id ="header_tupian"></div>
			<div id ="header_word">
				<div id="p">
					<p >当前用户:${currentUser}  <a href="/loginout.do" id="header_p_a">[安全退出]</a></p>
				</div>
				<div id ="id">
					<div id="li">
						<a href="#" class="a1">主站</a>
					</div>
					<div id="li">
						<a href="#" class="a1">番剧</a>
					</div>
					<div id="li">
						<a href="#" class="a1">游戏中心</a>
					</div>
					<div id="li">
						<a href="#" class="a1">直播</a>
					</div>
				
					<div id ="li">
						<a href="../servlet/GetDownloadListController" class="a1">下载</a>
					</div>
					
				</div>
			</div>
	  </div>

	  <div id="center"></div>
	  <div id="element"><img src="../images/bilibili1.jpg"/>
	</div>
  
  </body>
</html>
