<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	Login Here
	<div class="container">
		<div class="align-self-center">
			<form action="signin" method="get">
				
				<div class="form-group">
					<label for="email">Email address</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email">
				</div>

				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" placeholder="Password">
				</div>

				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
</body>
</html>