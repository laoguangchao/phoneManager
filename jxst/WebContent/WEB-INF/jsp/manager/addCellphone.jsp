<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#addCellphoneForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			form[0].reset();
			alert("添加成功！");
		});
		return false;
	});
});

</script>
<h1>添加手机产品信息</h1>
<hr>
<form action="addCellphone.action" method="post" id="addCellphoneForm">
	产品名称:<input type="text" name="name"/><br/>
	产品价格:<input type="text" name="price"/><br/>
	产品类型:	<select name="c_id">
				<option value="">请选中</option>
				<c:forEach items="${cateogryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	产品信息:
			<textarea name="information" rows="10" cols="30"></textarea>
		<br/>
	<input type="submit" value="提交"/><br/>
</form>