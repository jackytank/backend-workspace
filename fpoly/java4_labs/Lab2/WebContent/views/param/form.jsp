<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Lab2/dang-ky" method="post">
		Tên đăng nhập: <input name="username" type="text"><br>
		Mật khẩu: <input name="password" type="password"><br> 
		Giới tính:
		<input name="gender" type="radio" value="true">Nam
		<input name="gender" type="radio" value="false">Nữ
		<input name="married" type="checkbox">Đã có gia đình?<br>
		Quốc tịch:
		<select name="country">
			<option value="VN">Vietnam</option>
			<option value="US">United States</option>
		</select><br>
		Sở thích:
		<input name="hobby" type="checkbox" value="R">Đọc sách
		<input name="hobby" type="checkbox" value="T">Du lịch
		<input name="hobby" type="checkbox" value="M">Âm nhạc
		<input name="hobby" type="checkbox" value="O">Khác<br>
		Ghi chú: 
		<textarea name="notes" rows="3" cols="30"></textarea>
		<hr>
		<button>Đăng ký</button>
	</form>
</body>
</html>