<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
</head>

<body>
	<div class="container">
		<div class="columns is-centered mt-6">
			<div class="column is-4">
				<form action="/thelab3/staff" method="post" class="box" enctype="multipart/form-data">
					<div class="field">
						<label for="" class="label">Fullname</label> <input type="text"
							class="input" name="fullname">
					</div>
					<div class="field">
						<label for="" class="label">Picture</label> <input class="input"
							type="file" name="photo">
					</div>
					<div class="field">
						<label for="" class="label">Birthday</label> <input type="text"
							class="input" name="birthday">
					</div>
					<div class="field">
						<label for="" class="label">Country</label>
						<div class="select">
							<select name="country" id="">
								<option value="VN">Vietnam</option>
								<option value="US">United States</option>
							</select>
						</div>
					</div>
					<div class="field">
						<label for="" class="label">Gender</label>
						<div class="control">
							<label class="radio"> <input type="radio" name="gender">
								Male
							</label> <label class="radio"> <input type="radio" name="gender">
								Female
							</label>
						</div>
					</div>
					<div class="field">
						<label for="" class="label">Married</label>
						<div class="control">
							<label class="checkbox"> <input type="checkbox"
								name="married">Married?
							</label>
						</div>
					</div>
					<div class="field">
						<label for="" class="label">Hobbies</label>
						<div class="control">
							<label class="checkbox"> <input type="checkbox"
								name="hobbies" value="R">Reading
							</label> <label class="checkbox"> <input type="checkbox"
								name="hobbies" value="T">Travel
							</label> <label class="checkbox"> <input type="checkbox"
								name="hobbies" value="M">Music
							</label> <label class="checkbox"> <input type="checkbox"
								name="hobbies" value="O">Other
							</label>
						</div>
					</div>
					<div class="field">
						<div class="control">
							<textarea class="textarea" name="notes" id="" cols="30" rows="5"></textarea>
						</div>
					</div>
					<div class="field">
						<div class="control">
							<button class="button is-primary">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>