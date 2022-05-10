<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
</head>
</head>
<body>
	<div class="container">
		<div class="columns is-centered mt-6">
			<div class="column is-4">
				<h1 class="block title has-text-centered">LOGIN</h1>
				<form action="/thelab3/login" method="post" class="box"
					id="form-login">
					<div class="field">
						<label for="" class="label">Username</label>
						<div class="control has-icons-left">
							<input type="text" class="input" name="username" value="${username}"> <span
								class="icon is-small is-left"> <i class="fas fa-user"></i>
							</span>
						</div>
					</div>
					<div class="field">
						<label for="" class="label">Password</label>
						<div class="control has-icons-left">
							<input type="password" class="input" name="password"value="${password}"> <span
								class="icon is-small is-left"> <i class="fas fa-lock"></i>
							</span>
						</div>
					</div>
					<div class="field is-horizontal">
						<div class="control">
							<label class="checkbox"> <input type="checkbox" name="remember">
								Remember me
							</label>
						</div>
					</div>
					<hr>
					<div class="field">
						<div class="control">
							<button class="button is-fullwidth is-primary" type="submit">Login</button>
						</div>
					</div>
					<div class="field">
						<mark class="subtitle">${message}</mark>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>