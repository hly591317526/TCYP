<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>汇趣星城--新用户注册</title>
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link type="text/css" rel="stylesheet" media="all" href="css/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="css/global_color.css" />
<script type="application/x-javascript">
	
	 addEventListener("load", function()
			 { setTimeout(hideURLbar, 0); }, false); 
	 function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style_login.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
	<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
		type='text/css'>
		<!--//webfonts-->
		<script
			src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/roundabout.js"></script>
		<script type="text/javascript" src="js/roundabout_shapes.js"></script>
		<script type="text/javascript" src="js/gallery_init.js"></script>
		<script type="text/javascript">
			function f1() {
				if ($("#name").val().length > 1) {
					return true;
				} else
					return false;
			}
			function f2() {
				//1.获取email
				var user_name = document.getElementById("email").value;
				//2.校验其格式。
				var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				var span = document.getElementById("info");
				if (reg.test(user_name)) {
					//匹配成功
					span.innerHTML = "注册一起玩吧！";
					return true;
				} else {
					//匹配失败
					span.innerHTML = "邮箱格式错误！";
					return false;
				}
			}
			function f3() {
				//1.获取密码
				var user_psw = document.getElementById("password").value;
				//2.校验其格式。
				var reg = /^\w{3,20}$/;
				var span = document.getElementById("info");
				if (reg.test(user_psw)) {
					//匹配成功
					span.innerHTML = "注册一起玩吧！";
					return true;
				} else {
					//匹配失败
					span.innerHTML = "密码格式错误！";
					return false;
				}
			}
			function f4() {
				if ($("#phone").val().length > 3) {
					return true;
				} else
					return false;
			}

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
<body
	style=" background: url('images/background4.jpg')   repeat-y   top ; ">
	<header>
	<div class="container">
		<h1
			style="cursor: default; padding-top: 0; color: white; font-size:40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Joining
			Us !</h1>
		<nav>
		<ul>
			<li><a href="toIndex.do">Home</a></li>
			<li><a href="http://www.xxcb.cn/" target="_blank">News</a></li>
			<li><a href="百货页面">Store</a></li>
			<li><a href="同城交易">Trade</a></li>
			<li><a href="活动页面">Activity</a></li>
			<li><a href="咸鱼组介绍">About us</a></li>
		</ul>
		</nav>
	</div>

	<!-- 右上角状态区 -->
	<div id="logo">
		<span
			style="font-size: 16px;color: #fff;font-weight: bold; line-height: 24px">
			<c:if test="${sessionScope.user.root==1}">
				<a href="toManage.do?page=1" style="text-decoration: none;">${sessionScope.user.name}
					&nbsp;</a>
			</c:if>
		</span> <img alt="" src="images/fail.png" id="categort"
			style="cursor: pointer;" />
	</div>
	</header>

	<!-- 设置块区 -->
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

	<h1 style="color:#D80115; margin-left: 40%;" id="info">我们一起玩吧！</h1>
	<div class="login-form">
		<div class="clear"></div>
		<form action="addMember.do" method="post"
			onsubmit="return (f1()+f2()+f3()+f4())==4;">
			<input onblur="f1()" type="text" name="name" id="name"
				placeholder="姓名&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(必填)" />
			<input onblur="f2()" type="text" class="text" name="email" id="email"
				placeholder="email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(必填)" />
			<input onblur="f3()" type="text" name="password" id="password"
				placeholder="密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(必填)" />
			<input onblur="f4()" type="text" name="phone" id="phone"
				placeholder="电话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(必填)" />
			<input type="text" name="qq" id="qq"
				placeholder="qq&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(选填)" />
			<input type="text" name="descr" id="descr"
				placeholder="个人描述&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(选填)" />
			<br /> <input type="submit" value="注册" style="height: 60px;" />
		</form>
	</div>
	<br />
	<br />








	<!-- 声明块 -->
	<div style="text-align:center;margin:20px 0;font-size: 20px;">
		<br />
		<p style="font-weight: bold; font-size: 20px;">
			感谢：<a href="http://www.tmooc.cn/" target="_blank"
				style="font-weight: bold;">达内长沙中心</a>&nbsp;&nbsp;&nbsp; 指导老师：<a
				href="https://www.jd.com/" target="_blank"
				style="font-weight: bold;">聂志明</a>
		</p>
		<br />
		<p>
			<span style="font-weight: bold; color: yellow;">咸鱼组</span>参赛作品：Fun
			ChangSha（汇趣星城）;
		</p>
		<br />
		<p style="font-weight: bold;">参与人员:欧婷、谢炼、刘佳、刘清、李阳、胡嘉伟、贺凌云、王润获、李敏、陈新、江兵。</p>
	</div>

</body>
</html>