<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户信息管理
	<hr />
	<h2>原生操作</h2>
	<a href="user/add">新增用户</a><br/>
	<a href="user/update">修改用户</a><br/>
	<a href="user/list">显示用户</a><br/>
	<hr />
	<h2>BaseServlet操作</h2>
	<a href="user?method=add">新增用户</a><br/>
	<a href="user?method=update">修改用户</a><br/>
	<a href="user?method=list">显示用户</a><br/>
</body>
</html>