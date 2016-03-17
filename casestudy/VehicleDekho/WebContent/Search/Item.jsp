<%@page import="misc.LoginStatus"%>
<%@page import="com.vehicledekho.model.Car"%>
<%@page import="com.vehicledekho.model.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
	<div class="container">
		<%@include file="../header.jsp"%>
		<div class="row">
			<%
			    Car carVehicle = (Car) request.getAttribute("CarDetails");
			    out.write("<table class='table table-hover'>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Model " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getMake() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Make " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getModel() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Brand " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getManufacturer() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Engine Power(CC)  " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getEngineInCc() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Fuel Capacity " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getFuelCapacity() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Mileage " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getMileage() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Price " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getPrice() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Road Tax " + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    out.write("<p>" + carVehicle.getRoadTax() + "</p>");
			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Ac" + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    if (carVehicle.isAcAvailable())
					out.write("<input type='checkbox' disabled=true id='isACAvailableCheckBox' name='isACAvailableCheckBox' value='no'checked=true ></input>");
			    else
					out.write("<input type='checkbox' disabled=true id='isACAvailableCheckBox' name='isACAvailableCheckBox' value='no' ></input>");

			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Accessory Kit" + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    if (carVehicle.isAccessoryKitAvailable())
					out.write("<input type='checkbox' disabled=true id='isAccessoryKitAvailableCheckBox' name='isAccessoryKitAvailableCheckBox' value='no'checked=true ></input>");
			    else
					out.write("<input type='checkbox' disabled=true id='isAccessoryKitAvailableCheckBox' name='isAccessoryKitAvailableCheckBox' value='no' ></input>");

			    out.write("</td>");
			    out.write("</tr>");

			    out.write("<tr>");
			    out.write("<td>");
			    out.write("<p>" + "Power Steering" + "</p>");
			    out.write("</td>");
			    out.write("<td>");
			    if (carVehicle.isPowerSteeringAvailable())
					out.write("<input type='checkbox' disabled=true id='isPowerSteeringAvailableCheckBox' name='isPowerSteeringAvailableCheckBox' value='no'checked=true ></input>");
			    else
					out.write("<input type='checkbox' disabled=true id='isPowerSteeringAvailableCheckBox' name='isPowerSteeringAvailableCheckBox' value='no' ></input>");

			    out.write("</td>");
			    out.write("</tr>");

			    if (LoginStatus.isLogged()) {
					out.write("	<a href='Edit?brand=" + carVehicle.getManufacturer() + "&make=" + carVehicle.getMake() + "&model="
						+ carVehicle.getModel() + "'><input type='Button' value='Edit' /></a>");
			    }
			%>
		</div>
	</div>
	<%@include file="../footer.html"%>
</body>
</html>