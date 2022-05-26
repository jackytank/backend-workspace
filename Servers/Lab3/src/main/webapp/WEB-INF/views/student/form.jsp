<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous" defer></script>
</head>

<body>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
	%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container d-flex justify-content-center">
		<form:form action="/student/save" method="post"
			modelAttribute="student" enctype="multipart/form-data">
			<form:input path="name" class="form-control"></form:input>
			<form:errors path="name" class="text-danger" />
			<br />

			<form:input path="email" class="form-control"></form:input>
			<form:errors path="email" class="text-danger" />
			<br />

			<form:input type="number" path="mark" class="form-control"></form:input>
			<form:errors path="mark" class="text-danger" />
			<br />

			<form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
			<br />
			Faculty: 
			<form:select path="faculty" multiple="false">
				<form:options items="${faculties}"></form:options>
			</form:select>
			<br />
			Hobbies: 
			<form:select path="hobby" multiple="false">
				<form:options items="${hobbies}"></form:options>
			</form:select>
			<br />
			<input type="file" name="imageFile" class="form-control" />
			<form:button class="btn btn-success">Save</form:button>

			<h3 class="text-warning">${message}</h3>

		</form:form>

	</div>
</body>

</html>