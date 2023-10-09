<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Lab2/tam-giac" method="post">
		<input name="a" placeholder="Cạnh a?"><br>
		<input name="b" placeholder="Cạnh b?"><br> 
		<input name="c" placeholder="Cạnh c?"><br>

		<button formaction="/Lab2/dien-tich">Tính diện tích</button>
		<button formaction="/Lab2/chu-vi">Tính chu vi</button>

	</form>
	<h3>${message}</h3>
</body>
</html>