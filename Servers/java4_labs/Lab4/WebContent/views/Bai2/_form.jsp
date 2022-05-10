<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<link rel="stylesheet" href="./css/style.css">
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="box">
		<form action="/Lab4/user" method="post">
			<div class="field">
				<p>${message}</p>
			</div>
			<div class="field">
				<div class="control">
					<label for="" class="label">Username</label> <input class="input"
						type="text" value="${form.username}">
				</div>
			</div>
			<div class="field">
				<div class="control">
					<label for="" class="label">Password</label> <input class="input"
						type="text" value="${form.password}">
				</div>
			</div>
			<div class="field">
				<div class="control">
					<label class="checkbox"> <input type="checkbox"
						${form.remember?"checked":""}>Remember me?
					</label>
				</div>
			</div>
			<div class="field">
				<div class="control">
					<button class="button is-primary">CREATE</button>
				</div>
			</div>
		</form>
	</div>
</body>

</html>