<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Insert title here</title>
</head>
<body>
	<form action="/ctrl/ok" method="post">
		<button>OK 1</button>
		<button formmethod="get">OK 2</button>
		<button formaction="/ctrl/ok?x">OK 3</button>
	</form>
	<h1>Kết Quả: ${result}</h1>
</body>
</html>