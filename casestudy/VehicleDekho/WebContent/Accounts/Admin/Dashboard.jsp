<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin DashBoard vehicleDekho</title>
</head>
<body>
	<div class="container">
		<%@include file="/../header.jsp"%>
		
		<div class="row">
			<div class=col-md-3">
				<div class="col-md-3" style="background-color: Orange;">
				<h2>Admin DashBoard</h2>
					<span class="glyphicon glyphicon-cog" style="font-size: 150px"
						aria-hidden="true"></span>
				</div>
			</div>
			<div class="col-md-3">
				<a href="Admin/NewVehicle "> <span class="glyphicon glyphicon-plus"
					style="font-size: 120px" aria-hidden="true"></span>
				</a>
			</div>
			<div class="col-md-3">
				<a href="Search "> <span class="glyphicon glyphicon-pencil"
					style="font-size: 120px" aria-hidden="true"></span>
				</a>
			</div>
		</div>

		<%@include file="/../footer.html"%>
</body>
</html>