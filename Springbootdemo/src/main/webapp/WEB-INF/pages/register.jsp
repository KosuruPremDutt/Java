<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	Register Here
	<a href="loginpage">Login</a>
	<div class="container">
		<div class="align-self-center">
			<form action="addEmp" method="POST">
				<!--   <div class="form-group">
					<label for="txteid">Eid</label> <input type="text"
						class="form-control" name="txteid" id="eid"
						placeholder="Enter ID">
				</div> -->
				<div class="form-group">
					<label for="ename">Emp name</label> <input type="text"
						class="form-control" name="txtename" id="ename"
						placeholder="Enter Name">
				</div>
				<div class="form-group">
					<label for="email">Email address</label> <input type="email"
						class="form-control" name="txtemail" id="email"
						placeholder="Enter email">
				</div>

				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="txtpassword" id="password"
						placeholder="Password">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>