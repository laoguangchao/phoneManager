<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script type="text/javascript">

		var index = 0;
		function changeImg() {
			if (index == 3) {
				index = 0;
			}
			var current = index + 1;
			document.getElementById('img1').src = "images/roll" + current
					+ ".jpg";
			index++;

			setTimeout("changeImg()", 1000);

		}
	</script>
<div class="top">
	<div class="topbg">
		<div class="logo_sign">
			<div class="logo">
			</div>
			<div class="sign">
				<span>欢迎您系统管理员</span> <span class="sp_home">首页</span> <span
					class="sp_backstage"><a href="manager/toLogin.action">后台管理</a></span>
				<span class="sp_signout">退出</span>
			</div>
		</div>
		<div class="nav">
			<ul class="navUI">
				<li><a href="toIndex.action"><img
						src="http://localhost:8080/jxst/images/huawei.png" width="100px"
						height="45px"></a></li>

				<c:forEach items="${categoryList }" var="c">
					<li><a href="toList.action?c_id=${c.id}">${c.name }</a></li>
				</c:forEach>
				<li><a href="mailto:171531321@qq.com?&subject=你好">联系我们</a></li>
			</ul>
		</div>
		<div class="banner" style="background-color: 00FFFF;">
			<div style="text-align: left;">
				<video id="video1" width="540" controls="controls"
					style="margin-top: 2px;">
					<source src="video/huawei.mp4" type="video/mp4" />
					<source src="videohuawei.ogg" type="video/ogg" />
					Your browser does not support HTML5 video.
				</video>
		</div>
		<div class="banner1" style="background-color: 00FFFF;position: absolute;right:130px;top:155px;">
			<div style="text-align:right;">
				<body onload="changeImg()">
    <div><img src="images/roll1.jpg" alt="" width="530" height="303" id="img1"></div>
  
  </body>
		</div>
	</div>


</div>