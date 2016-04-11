<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>汇趣星城--管理</title>
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link type="text/css" rel="stylesheet" media="all" href="css/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="css/global_color.css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/roundabout.js"></script>
<script type="text/javascript" src="js/roundabout_shapes.js"></script>
<script type="text/javascript" src="js/gallery_init.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if (${sessionScope.user.root!=1}) {
			location.href = "toIndex.do";
		}
		$("#hidden_menu").hide();
		$("#categort").click(function() {
			$("#hidden_menu").toggle();
		});
	});
</script>
<script language="javascript" type="text/javascript">
	//按照id排序
	function sortId() {
		if ($("table tr:eq(1) td:eq(0)").html() == 1) {
			location.href = "toManageDesc.do";
		}
		if ($("table tr:eq(1) td:eq(0)").html() != 1) {
			location.href = "toManage.do";
		}
	}
	//按照权限排序
	function sortRoot() {
		if ($("table tr:eq(1) td:eq(6)").html() == " 管理员") {
			location.href = "toManageByRoot.do";
		}
		if ($("table tr:eq(1) td:eq(6)").html() != " 管理员") {
			location.href = "toManageByRootDesc.do";
		}
	}

	//删除
	function deleteMember(id) {
		var r = window.confirm("确定要删除此资费吗？");
		if (r) {
			document.getElementById("operate_result_info").style.display = "block";
			setTimeout(function() {
				location.href = "toDeleteMember.do?id=" + id;
			}, 2000);
		}
	}

	function goback() {
		location.href = "toIndex.do";
	}
</script>
<!--[if lt IE 7]>
<link rel="stylesheet" href="css/ie/ie6.css" type="text/css" media="all">
<![endif]-->
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/ie9.js"></script>
<![endif]-->
</head>
<body style=" background-image: url('images/background3.jpg'); ">
	<header>
	<div class="container">
		<h1 style="cursor: default;">&nbsp;&nbsp;&nbsp;Management</h1>
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

	<!-- 表格开始 -->
	<div id="main">
		<form>
			<div>
				<img src="images/add_member.png" alt=""
					style="padding-left:87%; cursor: pointer;"
					onclick="location.href='toAddMember.do';" /><span
					style="color: black; font-weight: bold; line-height: 24px;font-size: 15px;">增加会员</span>
			</div>
			<!--启用操作的操作提示-->
			<div id="operate_result_info" class="operate_success">
				<img src="images/close.png"
					onclick="this.parentNode.style.display='none';" /> 删除成功！
			</div>
			<!--数据区域：用表格展示数据-->
			<div id="data">
				<table id="datalist" style="background-color: #666">
					<tr>
						<th style="color: black;" class="width50" onclick="sortId();">ID</th>
						<th style="color: black;">姓名</th>
						<th style="color: black;">email</th>
						<th style="color: black;">密码</th>
						<th style="color: black;">phone</th>
						<th style="color: black;">QQ</th>
						<th style="color: black; " onclick="sortRoot();">Root</th>
						<th class="width200" style="color: black;">个人信息</th>
						<th class="width150"></th>
					</tr>
					<c:forEach var="c" items="${members}">
						<tr>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.email}</td>
							<td>${c.password}</td>
							<td>${c.phone}</td>
							<td>${c.qq}</td>
							<td><c:if test="${c.root==0||c.root==null}">游客</c:if> <c:if
									test="${c.root==1}">管理员</c:if></td>
							<td>${c.descr}</td>
							<td><input type="button" value="修改" class="btn_modify"
								onclick="location.href='toUpdateMember.do?id=${c.id}'" /> <input
								type="button" value="删除" class="btn_delete"
								onclick="deleteMember(${c.id});" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!--分页-->
			<div id="pages">
				<a href="?page=${param.page-1}">上一页</a> <a href="?page=1"
					class="${param.page==1?'current_page':''}">1</a> <a href="?page=2"
					class="${param.page==2?'current_page':''}">2</a> <a href="?page=3"
					class="${param.page==3?'current_page':''}">3</a> <a href="?page=4"
					class="${param.page==4?'current_page':''}">4</a> <a href="?page=5"
					class="${param.page==5?'current_page':''}">5</a> <a
					href="?page=${param.page+1}">下一页</a>
			</div>
		</form>
	</div>
</body>
</html>