<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
	<form action="/product/save" method="post">
		<input name="name"> 
		<input name="price">
		<button>Save</button>
	</form>
	<ul>
		<li>${name}</li>
		<li>${price}</li>
	</ul>
</body>
</html>