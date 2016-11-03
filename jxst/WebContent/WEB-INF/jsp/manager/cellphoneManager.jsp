<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
	th{
		background: lightblue;
		font-family: 微软雅黑;
		font-size: 14px;
	}
	td{
		text-align: center;
		font-family: 微软雅黑;
		font-size: 14px;
	}
</style>
<h1>产品信息管理</h1>
<hr>
<table  border="1" style="width: 100%;border-collapse: collapse;margin-top: 10px" >
	<tr>
		<th>编号</th>
		<th>产品名称</th>
		<th>价格</th>
		<th>产品信息</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${cellphoneList}" var="ce">
	<tr>
		<td>${ce.id }</td>
		<td>${ce.name }</td>
		<td>${ce.price }</td>
		
		<td>${ce.information}</td>
		<td>
		<a href="javascript:void(0);" val="${ce.id }" class="upd">修改</a>
			<a href="javascript:void(0);" val="${ce.id }" class="del">删除</a>
		<input type="checkbox" value="${ce.id }"/>
			
		</td>
	</tr>
	</c:forEach>
</table>
<script>
/* $(function(){
	$(".upd").off();
	$(".upd").on("click",function(){
		alert("功能未完善");
	}); */

	$(function(){
		
		$(".upd").off();
		$(".upd").on("click",function(){
				var id = $(this).attr("val");
				$(".right").load("toUpdateCellphone.action",{id:id});

				});
		
	
	$(".del").off();
	$(".del").on("click",function(){
		var flag = confirm("确定删除吗？");
		if(flag){
			var id = $(this).attr("val");
			$.post("delCellphone.action",{id:id},function(){
				$(".baseUI li :contains('手机产品管理')").trigger("click");
			});
		}
	});
	
	
});
	
</script>