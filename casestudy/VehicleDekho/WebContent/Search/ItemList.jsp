<%@page import="java.util.ArrayList"%>
<%@page import="com.vehicledekho.model.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VehicleDekho Search</title>
</head>
<body>
	<div class="container">
		<%@include file="../header.jsp"%>
		<table class="table table-striped">
			<thread>
			<tr>
				<th>Make
				</td>
				<th>Model
				</td>
				<th>Brand
				</td>
				<th>Price
				</td>
			</tr>
			<tr></tr>
			</thread>
			<tbody>
			<%
			    ArrayList<Car> listOfCars = (ArrayList<Car>) request.getAttribute("CarList");
			    for (Car car : listOfCars) {
					out.write("<tr>");
					out.write("<td>" + car.getMake() + "</td>");
					out.write("<td>" + car.getModel() + "</td>");
					out.write("<td>" + car.getManufacturer() + "</td>");
					out.write("<td>" + car.getPrice() + "</td>");

					out.write("<td> <a href='SearchByBudget?make=" + car.getMake() + "&model=" + car.getModel() + "&brand=" + car.getManufacturer()
						+ "'> View</a></td>");

					out.write("</tr>");
			    }
			%>
			</tbody>
			</table>
	</div>
	<%@include file="../footer.html"%>
</body>
</html>