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
        <div class="container">
            <div class="columns is-centered mt-6">
                <div class="column is-4">
                    <div class="content">
                        <h2 class="title is-3">User Management</h2>
                    </div>
                    <div class="block">
                        <jsp:include page="./_form.jsp"></jsp:include>
                    </div>
                    <hr>
                    <div class="block">
                        <jsp:include page="./_table.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        </div>
	</body>

	</html>