<%@page import="com.vehicledekho.model.Car"%>
<%@page import="com.vehicledekho.model.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VehicleDekho - Edit</title>
</head>
<body>
	<div class="container">
		<%@include file="../../header.jsp"%>
		<h1>Edit Vehicle</h1>
		<div class="row">
			<div class=col-md-3">
				<div class="col-md-3">
					<span class="glyphicon glyphicon-pencil" style="font-size: 150px"
						aria-hidden="true"></span>
				</div>
			</div>

			<div class="col-md-9">
				<form action="UpdateServlet" method="post">
					<div>
						<table>
							<tr>
								<td><label>Make</label></td>
								<td>
									<%
									    Car car = (Car) request.getAttribute("CarObject");
									    out.write("<input type='text' class='form-control' id='carnametb' name='carnametb' placeholder='Car Name' value='" + car.getMake()
											    + "' required ></input>");
									%>
								</td>
							</tr>


							<tr>
								<td><label>Model</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='carmodeltb' name='carmodeltb' placeholder='Car Model' value='" + car.getModel()
											    + "' required ></input>");
									%>
								</td>
							</tr>


							<tr>
								<td><label>Brand</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='manufacturertb' name='manufacturertb' placeholder='Brand' value='"
											    + car.getManufacturer() + "' required ></input>");
									%>
								</td>
							</tr>


							<tr>
								<td><label>Engine Capacity</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='enginecapacitytb' name='enginecapacitytb' placeholder='Engine' value='"
											    + car.getEngineInCc() + "' required ></input>");
									%>
								</td>
							</tr>


							<tr>
								<td><label>FuelCapacity</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='fuelcapacitytb' name='fuelcapacitytb' placeholder='Fuel Capacity' value='"
											    + car.getFuelCapacity() + "' required ></input>");
									%>
								</td>
							</tr>


							<tr>
								<td><label>Mileage</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='mileagetb' name='mileagetb' placeholder='mileage' value='" + car.getMileage()
											    + "' required ></input>");
									%>
								</td>
							</tr>
							<tr>
								<td><label>RoadTax</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='roadtaxtb' name='roadtaxtb' placeholder='Road Tax' value='" + car.getRoadTax()
											    + "' required ></input>");
									%>
								</td>
							</tr>
							<tr>
								<td><label>Price</label></td>
								<td>
									<%
									    out.write("<input type='text'  class='form-control' id='pricetb' name='pricetb' placeholder='Price' value='" + car.getPrice()
											    + "' required ></input>");
									%>
								</td>
							</tr>

							<tr>
								<td><label>Power Steering</label></td>
								<td>
									<%
									    if (car.isPowerSteeringAvailable())
											out.write("<input type='checkbox'  class='form-control' id='isPowerSteeringAvailableCheckBox' name='isPowerSteeringAvailableCheckBox' value='no'checked=true ></input>");
									    else
											out.write("<input type='checkbox'  class='form-control' id='isPowerSteeringAvailableCheckBox' name='isPowerSteeringAvailableCheckBox' value='no' ></input>");
									%>
								</td>
							</tr>

							<tr>
								<td><label>Accessory Kit</label></td>
								<td>
									<%
									    if (car.isAccessoryKitAvailable())
											out.write("<input type='checkbox'  class='form-control' id='isAccessoryKitAvailableCheckBox' name='isAccessoryKitAvailableCheckBox' value='no'checked=true ></input>");
									    else
											out.write("<input type='checkbox'  class='form-control' id='isAccessoryKitAvailableCheckBox' name='isAccessoryKitAvailableCheckBox' value='no' ></input>");
									%>
								</td>
							</tr>

							<tr>
								<td><label>Ac</label></td>
								<td>
									<%
									    if (car.isAcAvailable())
											out.write("<input type='checkbox'  class='form-control' id='isACAvailableCheckBox' name='isACAvailableCheckBox' value='no'checked=true ></input>");
									    else
											out.write("<input type='checkbox' class='form-control' id='isACAvailableCheckBox' name='isACAvailableCheckBox' value='no' ></input>");
									%>
								</td>
							</tr>
						</table>
						<div>
							<input type="submit" class='btn btn-primary md-col-12'
								value="Update Details"><br>
						</div>
					</div>
				</form>
			</div>
		</div>
		<%@include file="../../footer.html"%>
	</div>
</body>
</html>