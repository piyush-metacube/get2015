<%@page import="org.w3c.dom.Document"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search VehicleDekho</title>
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>
		<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<form class="form" method="post" action="Search">
					<fieldset>
						<legend>
							<h3>Search by Make and Model</h3>
						</legend>

						<div>
							<h5>select brand</h5>
							<select name="brandselector" class="dropdown">
								<%
								    ArrayList<String> arrayList = (ArrayList<String>) request.getAttribute("brandList");
								    for (String string : arrayList) {
										out.println("<option value = '" + string + "' id = '" + string + "'>" + string + "</option>");
								    }
								%>
							</select><br>
							<h5>select Make</h5>
							<select name="makeselector">
								<%
								    arrayList = (ArrayList<String>) request.getAttribute("makeList");
								    for (String string : arrayList) {
										out.println("<option value = '" + string + "' id = '" + string + "'>" + string + "</option>");
								    }
								%>
							</select>
						</div>
						<br> <input class="btn btn-success" type="submit" value="Search" />
					</fieldset>
				</form>
			</div>


			<div class="col-md-4 col-md-offset-1">
				<form action="SearchByBudget" method="post">
					<fieldset>
						<legend>
							<h3>Search by Budget</h3>
						</legend>

						<h5>Enter Starting Range</h5>
						<input type="number" name="startRangetb" value="10" min='10' />
						<h5>Enter Ending Range</h5>
						<input type="number" name="endRangetb" value="10" min='10' /> <br />
						<br /> <input class="btn btn-success" type="submit" value="Search"></input>
					</fieldset>
				</form>
			</div>
		</div>
		<%@include file="footer.html"%>
	</div>
</body>
</html>