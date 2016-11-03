<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form=$("#updateCellphoneForm");
	form.off();
     form.on("submit",function(){
	form.ajaxSubmit(function(){
      /*
      *form[0].reset();
      *重置表单
      **/
			alert("修改成功！");
      //模拟点击栏目管理
			$(".baseUI li :contains('手机产品管理')").trigger("click");
		});
		return false;
	});
});

</script>
<h1>修改手机产品信息</h1>
<hr>
<form action="updateCellphone.action" method="post" id="updateCellphoneForm">
<input type="hidden" name="id" value="${cellphone.id}" />
	产品名称:<input type="text" name="name" value="${cellphone.name}"/><br/>
	产品价格:<input type="text" name="price" value="${cellphone.price}"/><br/>
	产品类型:	<select name="c_id">
				<option value="">请选中</option>
				<c:forEach items="${cateogryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	产品信息:
			<textarea name="information" rows="10" cols="30" >${cellphone.information}</textarea>
		<br/>
	<input type="submit" value="修改"/><br/>
</form>