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
	<c:url var="url" value="/account"></c:url>
	
	<div class="container">
		<div class="columns is-centered">
			<div class="column is-4">
				<div class="box">
					<form action="" method="post">
						<div class="field">
							<p class="sub-title is-dangerous">${message}</p>
						</div>
						<div class="field has-text-centered">
							<p class="title">SIGNIN</p>
						</div>
						<div class="field">
							<div class="control">
								<input type="text" class="input" name="username" placeholder="Username?">
							</div>
						</div>
						<div class="field">
							<div class="control">
								<input type="password" class="input" name="password" placeholder="Password?">
							</div>
						</div>
						<hr>
						<div class="field">
							<button formaction="${url}/sign-in" class="button is-fullwidth is-primary">Login</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>