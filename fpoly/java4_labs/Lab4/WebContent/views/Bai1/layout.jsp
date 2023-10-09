<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
		<link rel="stylesheet" href="./css/style.css">
	</head>

	<body>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<div class="app">
				<header>
					<div class="navbar">
						<div class="navbar-start">
							<div class="navbar-item">
								<h1 class="title is-bold">ONLINE SHOPPING MALL</h1>
							</div>
						</div>
						<div class="navbar-end">
							<div class="navbar-item mr-2">
								<div class="span icon">
									<i class="fas fa-shopping-cart fa-2x"></i>
								</div>
							</div>
						</div>
					</div>
				</header>
				<nav class="navbar is-light">
					<%@include file="./menu.jsp" %>
				</nav>
				<main>
					<div class="hero is-fullheight">
						<div class="container">
							<div class="hero-body">
								<div class="columns is-fullwidth">
									<div class="column is-two-thirds" style="border-right: 1px solid grey;">
										<div class="columns">
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Dua hau 1"></jsp:param>
												</jsp:include>
											</div>
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Dua hau 2"></jsp:param>
												</jsp:include>
											</div>
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Khong phai dua hau"></jsp:param>
												</jsp:include>
											</div>
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Khong phai dua hau"></jsp:param>
												</jsp:include>
											</div>
										</div>
										<div class="columns">
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Khong phai dua hau"></jsp:param>
												</jsp:include>
											</div>
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Khong phai dua hau"></jsp:param>
												</jsp:include>
											</div>
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Khong phai dua hau"></jsp:param>
												</jsp:include>
											</div>
											<div class="column">
												<jsp:include page="./item.jsp">
													<jsp:param name="name" value="Khong phai dua hau"></jsp:param>
												</jsp:include>
											</div>
										</div>
									</div>
									<div class="column">
										<%@include file="./login.jsp" %>
											<hr>
											<%@include file="./category.jsp" %>
									</div>
								</div>
							</div>
						</div>
					</div>
				</main>
				<footer class="footer">
					<div class="content has-text-centered">
						<p>FPT POLYTECHNIC 2022. ALL RIGHTS RESERVED.</p>
					</div>
				</footer>
			</div>
	</body>

	</html>