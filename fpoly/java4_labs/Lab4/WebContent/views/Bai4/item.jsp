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
	<div class="card pt-1">
		<div class="content has-text-centered">
			<p class="title is-5">${item.name}</p>
		</div>
		<div class="card-image">
			<div class="box">
				<div class="figure image is-5by3">
					<img
						src="https://www.theday.com/storyimage/NL/20100908/ENT04/309089950/AR/0/AR-309089950.jpg&Maxw=800&q=62"
						alt="">
				</div>
			</div>
		</div>
		<div class="card-content">
			<div class="content has-text-centered">
				<p class="title is-6">
					<del>$${item.price}</del> $${item.price*(1-item.discount)}
				</p>
			</div>
		</div>
	</div>
</body>

</html>