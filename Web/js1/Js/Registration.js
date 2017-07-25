//Validation for Activating The Submit Button
function activateSubmit() {

	if (document.getElementById("acceptCondition").checked == true) {
		document.getElementById("button").disabled = false;

	} else {
		document.getElementById("button").disabled = true;
	}
}

// Validation for Checking all the conditions
function validate() {
	var count = 0;
	if (document.getElementById("firstName").value.trim() == "") {
		count = 1;
		document.getElementById("firstName-error").innerHTML = "First name missing";
	}
	if (document.getElementById("lastName").value.trim() == "") {
		count = 1;
		document.getElementById("lastName-error").innerHTML = "Last name missing";
	}
	if (document.getElementById("password").value.length < 8) {
		count = 1;
		document.getElementById("password-error").innerHTML = "Set password";
	}
	if (document.getElementById("password").value != document
			.getElementById("confirmPassword").value) {
		count = 1;
		document.getElementById("confirm-error").innerHTML = "Password mismatch";
	}
	if (document.getElementById("state").value == "Select State"
			|| document.getElementById("city").value == "Select City") {
		count = 1;
		document.getElementById("state-error").innerHTML = "Select state and city";
	}
	if (count == 0) {
		alert("USER CREATED SUCCESSFULLY");
		document.getElementById("myForm").submit();
	}
}

// function to fill The cities
function createCity() {
	var map = new Map();
	var value1 = [ "Jaipur", "Udaipur", "Kota", "Ajmer" ];
	var value2 = [ "Bareilly", "Kanpur", "Lucknow", "Mathura" ]
	map.set("Rajasthan", value1);
	map.set("UP", value2);
	var stateObject = document.getElementById("state").value;
	var cityObject = document.getElementById("city");
	switch (stateObject) {
	case "Rajasthan":
		var value = map.get("Rajasthan");
		var options = "<option>" + value[0] + "</option>" + "<option> "
				+ value[1] + "</option>" + "<option>" + value[2] + "</option>"
				+ "<option>" + value[3] + "</option>";
		cityObject.innerHTML = options;
		break;
	case "UP":
		var value = map.get("UP");
		var options = "<option>" + value[0] + "</option>" + "<option> "
				+ value[1] + "</option>" + "<option>" + value[2] + "</option>"
				+ "<option>" + value[3] + "</option>";
		cityObject.innerHTML = options;
		break;
	}
}
