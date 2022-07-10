<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row justify-content-center my-4">
			<h3>Enter Company Form</h3>
		</div>
		<form action="/servletjsp-dxc/home" method="post">
			<div class="mb-3">
				<input type="text" class="form-control" name="firstName" placeholder="Firstname..." />
			</div>
			<div class="mb-3">
				<input type="text" class="form-control" name="lastName" placeholder="lastName..." />
			</div>
			<div class="mb-3">
				<input type="text" class="form-control" name="identify" placeholder="Identify..." />
			</div>
			<div class="mb-3">
				<input type="radio" name="gender" id="" value="true" />Male
				<input type="radio" name="gender" id="" value="false"/>Female
			</div>
			<div class="mb-3">
				<input class="form-control" type="text" name="address" id="" placeholder="Address..."/>
			</div>
			<button class="btn btn-success">Submit</button>
		</form>
	</div>





	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>