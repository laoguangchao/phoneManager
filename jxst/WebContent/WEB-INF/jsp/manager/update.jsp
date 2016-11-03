<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form=$("#updateForm");
	form.off();
     form.on("submit",function(){
	form.ajaxSubmit(function(){
      /* 
      *form[0].reset();
      *重置表单
      **/
			alert("修改成功！");
      //模拟点击栏目管理
			$(".baseUI li :contains('产品管理')").trigger("click");
		});
		return false;
	});
});

</script>

	<form action="update.action" method="post" id="updateForm">
	   <input type="hidden" name="id" value="${category.id}" />
			<table>
			<caption>修改产品信息</caption>
			 <tr>
				<td>产品信息:</td>
				<td>
						<input type="text" name="name" value="${category.name}" />
				</td>
			</tr>
			<tr>
				<td>产品编号:</td>
				<td>
						<input type="text" name="code" value="${category.code}"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="修改" /></td>
			</tr> 
			</table>
		
	</form>
	
