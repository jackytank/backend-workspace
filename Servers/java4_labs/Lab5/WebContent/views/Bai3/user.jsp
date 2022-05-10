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
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<c:url var="url" value="/user"></c:url>

	<div class="container">
		<div class="columns is-centered mt-3">
			<div class="column is-4">
				<div class="box">
					<form action="${url}/index" method="post">
						<div class="field">
							<div class="control">
								<label for="" class="label">Username</label> <input type="text"
									class="input" value="${form.id}" name="id">
							</div>
						</div>
						<div class="field">
							<div class="control">
								<label for="" class="label">Password</label> <input type="text"
									class="input" value="${form.password}" name="password">
							</div>
						</div>
						<div class="field">
							<div class="control">
								<label for="" class="label">Fullname</label> <input type="text"
									class="input" value="${form.fullname}" name="fullname">
							</div>
						</div>
						<div class="field">
							<div class="control">
								<label for="" class="label">Email</label> <input type="email"
									class="input" value="${form.email}" name="email">
							</div>
						</div>
						<div class="field">
							<div class="control">
								<label class="radio"> <input ${form.admin?"checked":""}
									type="radio" name="admin" value="true"> Admin
								</label> <label class="radio"> <input ${!form.admin?"checked":""}
									type="radio" name="admin" value="false"> User
								</label>
							</div>
						</div>
						<div class="field is-grouped">
							<div class="control">
								<button formaction="${url}/create" class="button is-light">Create</button>
							</div>
							<div class="control">
								<button formaction="${url}/update" class="button is-light">Update</button>
							</div>
							<div class="control">
								<button formaction="${url}/delete" class="button is-light">Delete</button>
							</div>
							<div class="control">
								<button formaction="${url}/reset" class="button is-light">Reset</button>
							</div>
						</div>
						<div class="field">
							<p>${message}</p>
						</div>
					</form>
				</div>
			</div>
			<div class="column is-5">
				<div class="box">
					<table class="table is-bordered is-hoverable">
						<thead>
							<tr>
								<td>Username</td>
								<td>Password</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Admin</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${items}">
								<tr>
									<td>${item.id}</td>
									<td>${item.password}</td>
									<td>${item.fullname}</td>
									<td>${item.email}</td>
									<td>${item.admin}</td>
									<td><a href="${url}/edit/${item.id}">Edit</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

</html>