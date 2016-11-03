<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合信息管理系统-后台</title>

<link rel="stylesheet" type="text/css" href="../theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/style.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/table.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/icon.css">
<link rel="stylesheet" type="text/css"
	href="../theme/1/jquery-easyui-themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../theme/1/css/easyui-tabs.css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../theme/1/js/base.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$(".baseUI li").on("click",function(){
		var url = $(this).attr("url");
		$(".right").load(url);		
	});
	//进入后台首页默认点击第一个
	$(".baseUI li").filter(":first").trigger("click");
});
</script>
<body>
	<div class="main">
		<div id="top">
			<div class="top">
				<div class="t_logo"></div>
				<div class="t_sign">
					<span>你好，管理员</span><a href="http://localhost:8080/jxst/toIndex.action" class="t_exit">退出</a>
				</div>
			</div>
		</div>
		<div id="cont">
			<div class="centent">
				<div class="left">
					<ul class="baseUI">
					<!-- 左侧导航栏 -->
						<!-- 李四 -->
						<li url="toAddCategory.action">
							<a href="#"><em class="base_basicset"></em><span>添加产品</span></a>
						</li>
						<!-- 王五 -->
						<li url="toCategoryManager.action">
							<a href="#"><em class="base_userset"></em><span>产品管理</span></a>
						</li>
						<li url="toAddArticle.action">
							<a href="#"><em class="base_roll"></em><span>信息发布</span></a>
						</li>
						<li url="toArticleManager.action">
							<a href="#"><em class="base_sys"></em><span>信息管理</span></a>
						</li>
						<li url="toAddCellphone.action">
							<a href="#"><em class="base_sys"></em><span>添加产品信息</span></a>
						</li>
						<li url="toCellphoneManager.action">
							<a href="#"><em class="base_sys"></em><span>手机产品管理</span></a>
						</li>
						<li url="">
							<a href="#"><em class="base_sys"></em><span>管理员管理</span></a>
						</li>
					</ul>
				</div>
				<!-- 内容页面 -->
				<div class="right" style="padding:30px;background-color:#ECFFFF;opacity:0.6";>
						
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div id="foot">
			<a href="#">上海师悦信息科技有限公司</a>
		</div>
	</div>
</body>
</html>
