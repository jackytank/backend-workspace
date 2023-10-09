<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
</head>

<body>
	<form action="/Lab3/login" method="post" class="mx-auto">
		<div class="form-group">
			<label for="username">Username:</label> <input class="form-control"
				name="username" type="text" />
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input class="form-control"
				name="password" type="password" />
		</div>

		<div class="form-group">
			<button type="button" class="btn btn-outline-success">Submit</button>
		</div>
		<div class="form-group">
			<h1 class="text-danger">${message}</h1>
		</div>
	</form>
</body>
</html>
