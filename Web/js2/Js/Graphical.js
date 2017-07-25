
// This function validates the input and creates the table.
function validate() {
	var textbox = document.getElementById("inputBox").value;
	if (textbox == "" || isNaN(textbox)) {
		alert("Please enter a valid number.");
	} else {
		var result = "<table border=1 align='center'>";
		result += "<tr>";
		result += "<th>Name</th><th>Minimum</th><th>Maximum</th>"
		result += "</tr>";
		for (var count = 0; count < textbox; count++) {
			result += "<tr>";
			result += "<td><input type='text'id='name" + count + "'></td>";
			result += "<td><input type='number' min=0 max=9 id='min" + count
					+ "'></td>";
			result += "<td><input type='number' min=0 max=9 id='max" + count
					+ "'></td>";
			result += "</tr>";
		}
		result += "<tr align='center'><td colspan='3'><input type='button' value='OK' onclick='graphical()'></td</tr>"
		result += "</table>";
		document.getElementById("table").innerHTML = result;
	}
}

// This function creates the graphical representation of the input.
function graphical() {
	var graph = "<table border=1 align='center'>";
	var textbox = document.getElementById("inputBox").value;
	for (var count = 0; count < textbox; count++) {
		name = document.getElementById("name" + count).value;
		min = document.getElementById("min" + count).value;
		max = document.getElementById("max" + count).value;
		if (min == "" || max == "") {
			continue;
		}
		if (min > max) {
			alert("Row " + count
					+ " column maximum have value less then minimum.");
			continue;
		} else if (min < 0 || max > 9 || min > 9 || max < 0) {
			alert("Row " + count + " !! Enter value within range..");
			continue;
		} else {
			graph += "<tr ><td id='name'>" + name + "</td>";
			for (count2 = 0; count2 <= 9; count2++) {
				if (count2 < min || count2 > max) {
					graph += "<td></td>";
				} else
					graph += "<td class='data'></td>";
			}
			graph += "</tr>"
		}
	}
	graph += "</table>";
	document.getElementById("tablegraphical").innerHTML = graph;
}