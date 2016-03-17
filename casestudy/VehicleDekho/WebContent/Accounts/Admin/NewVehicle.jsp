<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new vehicle - VehicleDekho.com</title>
</head>
<body>
	<div class="container">
		<%@include file="/header.jsp"%>
		<h1>Add New Car</h1>
		<div class="row">
			<div class="col-md-3">
				<span class="glyphicon glyphicon-hdd" style="font-size: 150px"
					aria-hidden="true"></span>
			</div>
			<div class="col-md-6">
				<form class="form" action="/AddNewVehicleServlet" method="post">
					<div>
						<input type="text" class="form-control" id="carnametb" name="carnametb"
							placeholder="Car Name" required /><br> <input class="form-control"
							type="text" id="carmodeltb" name="carmodeltb" placeholder="Car Model"
							required /><br> <input class="form-control" type="text"
							id="manufacturertb" name="manufacturertb" placeholder="Manufacturer"
							required /><br> <input class="form-control" type="text"
							id="enginecapacitytb" name="enginecapacitytb"
							placeholder="Engine Capacity" required /><br> <input
							class="form-control" type="text" id="fuelcapacitytb"
							name="fuelcapacitytb" placeholder="Fuel Capacity" required /><br> <input
							class="form-control" type="text" id="mileagetb" name="mileagetb"
							placeholder="Mileage" required /><br> <input class="form-control"
							type="text" id="roadtaxtb" name="roadtaxtb" placeholder="Road Tax"
							required /><br> <input class="form-control" type="text"
							id="pricetb" name="pricetb" placeholder="Price" required /><br> <input
							type="checkbox" id="isPowerSteeringAvailableCheckBox"
							name="isPowerSteeringAvailableCheckBox" value="no" /><label>Power
							Steering </label><br> <input type="checkbox"
							id="isAccessoryKitAvailableCheckBox"
							name="isAccessoryKitAvailableCheckBox" value="no" /><label>Accessory
							Kit</label><br> <input type="checkbox" id="isACAvailableCheckBox"
							name="isACAvailableCheckBox" value="no" /><label>AC </label><br>
						<div>
							<input type="submit" class="btn btn-primary col-md-12" value="Add Car">
						</div>
						<br>
					</div>
				</form>
			</div>

		</div>

		<%@include file="/footer.html"%>
	</div>
</body>
</html>