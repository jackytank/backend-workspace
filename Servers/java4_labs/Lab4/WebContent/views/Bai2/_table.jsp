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
	<div class="box is-align-content-center">
		<table class="table is-bordered is-hoverable">
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Remember?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.remember?'Yes':'No'}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>