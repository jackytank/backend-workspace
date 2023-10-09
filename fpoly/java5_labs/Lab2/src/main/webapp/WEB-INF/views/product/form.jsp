<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<form action="/product/save2" method="post">
		<input name="name"> <input name="price">
		<button>Save</button>
	</form>
	<ul>
		<li>${product1.name}</li>
		<li>${product1.price}</li>
	</ul>
	<ul>
		<li>${product2.name}</li>
		<li>${product2.price}</li>
	</ul>
	<ul>
		<c:forEach var="item" items="${myList}">
			<li>${item.name}</li>
			<li>${item.price}</li>
		</c:forEach>
	</ul>
</body>
</html>