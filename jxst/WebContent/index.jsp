<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//request.getRequestDispatcher("/toIndex.action").forward(request, response);
	response.sendRedirect("toIndex.action");//外部跳转
%>