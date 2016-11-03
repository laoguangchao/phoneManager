<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form=$("#updateArticleForm");
	form.off();
     form.on("submit",function(){
	form.ajaxSubmit(function(){
      /*
      *form[0].reset();
      *重置表单
      **/
			alert("修改成功！");
      //模拟点击栏目管理
			$(".baseUI li :contains('信息管理')").trigger("click");
		});
		return false;
	});
});

</script>

	<form action="updateArticle.action" method="post" id="updateArticleForm">
	
	<input type="hidden" name="id" value="${haha.id}" />
	文章标题:<input type="text" name="title" value="${haha.title}"/><br/>
	文章作者:<input type="text" name="author" value="${haha.author}"/><br/>
	所属栏目:	<select name="c_id">
				<option value="">请选中</option>
				<c:forEach items="${cateogryList}" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	文章内容:
			<textarea name="content" rows="10" cols="30"> ${haha.content}</textarea>
		<br/>
	<input type="submit" value="修改" /><br/>
</form>
