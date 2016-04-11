<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>汇趣星城</title>
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/roundabout.js"></script>
		<script type="text/javascript" src="js/roundabout_shapes.js"></script>
		<script type="text/javascript" src="js/gallery_init.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#hidden_menu").hide();
				$("#categort").click(function() {
					$("#hidden_menu").toggle();
				});
			});
		</script>
		<!--[if lt IE 7]>
<link rel="stylesheet" href="css/ie/ie6.css" type="text/css" media="all">
<![endif]-->
		<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/ie9.js"></script>
<![endif]-->
</head>
<body style=" background-image: url('images/background1.jpg'); ">
	<header>
	<div class="container">
		<h1 style="cursor: default;">&nbsp;&nbsp;&nbsp;Fun ChangSha</h1>
		<nav>
		<ul>
		<li><a href="toIndex.do">Home</a></li>
			<li><a href="http://www.xxcb.cn/" target="_blank">News</a></li>
			<li><a href="百货页面">Store</a></li>
			<li><a href="同城交易">Trade</a></li>
			<li><a href="活动页面">Activity</a></li>
			<li><a href="aboutus.html">About us</a></li>
		</ul>
		</nav>
	</div>

	<div id="logo">
		<!-- 当用户存在时，显示用户名字，   管理员多出一个链接  -->
		<span
			style="font-size: 16px;color: #fff;font-weight: bold; line-height: 24px">
			<c:if test="${sessionScope.user.root==1}">
				<a href="toManage.do?page=1" style="text-decoration: none;">${sessionScope.user.name}
					&nbsp;</a>
			</c:if> <c:if test="${sessionScope.user.root!=1}">${sessionScope.user.name} &nbsp;</c:if>
			<!--	${sessionScope.user.name} &nbsp; 或者${cookie.adminCode.value} -->
		</span>

		<!-- 当游客时，显示登陆图标。 客户显示设置图标 -->
		<!-- 会员模式 -->
		<c:if test="${sessionScope.user.name!=null}">
			<img alt="" src="images/fail.png" id="categort"
				style="cursor: pointer;">
		</c:if>
		<!-- 游客模式 -->
		<c:if test="${sessionScope.user.name==null}">
			<img alt="" src="images/up.png" onclick="location.href='toLogin.do'"
				style="cursor: pointer;"><span
				onclick="location.href='toLogin.do'"
				style="line-height:22px; font-weight: bold; cursor: pointer;">登陆</span>
		</c:if>
	</div>
	</header>

	<!-- 设置模块 -->
	<div id="divv1">
		<div id="hidden_menu">
			<img src="images/person.png" alt="个人信息修改"
				onclick="location.href='toPerson.do'" /> <img
				src="images/advice.png" alt="意见反馈"
				onclick="location.href='toRefelect.do'" /> <img
				src="images/quit.png" alt="跳转到登陆界面"
				onclick="location.href='toQuit.do'" />
		</div>
	</div>

	<!-- 轮换模块 -->
	<section id="gallery">
	<div class="container">
		<ul id="myRoundabout">
			<li><img src="images/slide3.jpg" alt=""></li>
			<li><img src="images/slide2.jpg" alt=""></li>
			<li><img src="images/slide5.jpg" alt=""></li>
			<li><img src="images/slide1.jpg" alt=""></li>
			<li><img src="images/slide4.jpg" alt=""></li>
		</ul>
	</div>
	</section>

	<!-- 声明块 -->
	<div style="text-align:center;margin:20px 0">
		<br />
		<p style="font-weight: bold;">
			感谢：<a href="http://www.tmooc.cn/" target="_blank"
				style="font-weight: bold;">达内长沙中心</a>&nbsp;&nbsp;&nbsp; 指导老师：<a
				href="https://www.jd.com/" target="_blank"
				style="font-weight: bold;">聂志明</a>
		</p>
		<p>
			<span style="font-weight: bold; color: yellow;">咸鱼组</span>参赛作品：Fun
			ChangSha（汇趣星城）;
		</p>
		<p style="font-weight: bold;">参与人员:欧婷、谢炼、刘佳、刘清、李阳、胡嘉伟、贺凌云、王润获、李敏、陈新、江兵。</p>
	</div>

</body>
</html>