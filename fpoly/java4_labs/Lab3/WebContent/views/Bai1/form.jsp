<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
</head>

<body>
	<form action="/Lab3/upload" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<input type="file" name="photo_file" class=" form-control">
		</div>
		<div class="form-group">
			<input type="file" name="doc_file" class="form-control">
		</div>
		<div class="form-group">
			<button class="btn btn-success">Submit</button>
		</div>
	</form>
</body>

</html>