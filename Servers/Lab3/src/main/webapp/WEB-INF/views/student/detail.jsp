<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	<h3>Name: ${student.name}</h3>
	<h3>Email: ${student.email}</h3>
	<h3>Mark: ${student.mark}</h3>
	<h3>Gender: ${student.gender?"Male":"Female"}</h3>
	<h3>Faculty: ${student.faculty}</h3>
	<h3>Hobby: ${student.hobby}</h3>
	<h3>Image: <img src="${student.imageUrl}" alt="" width="100"/></h3>
</body>

</html>