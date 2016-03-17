<%@page import="com.vehicledekho.exceptions.UserNotFoundException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VehicleDekho Login</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body background="pictures/background.jpg" style="background-size: cover">

	<div class="container ">
		<form action="LoginServlet" method="post" class="form-horizontal" role="form">
			<div class="col-lg-2 col-lg-offset-5 col-md-2 col-md-offset-5 col-sm-2 col-sm-offset-5 col-xs-2 col-xs-offset-5">
				<div class="form-group text-center">
					<img class="img-responsive" src="pictures/logo.png" wi>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-lg-2 col-lg-offset-5 col-md-2 col-md-offset-5 col-sm-2 col-sm-offset-5 col-xs-2 col-xs-offset-5">
					<div class="form-group text-center">
						<input type="text" class="form-control" id="usernametb" name="usernametb"
							placeholder="User Name" required>
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="passwordtb"
							name="passwordtb" placeholder="Password" required>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-default col-lg-12">Submit</button>
					</div>
				</div>

			</div>
		</form>
	</div>
</body>
</html>
