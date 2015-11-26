/**
 * 
 */

//google.load('visualization', '1', {'packages':['corechart']});

// Set a callback to run when the API is loaded.
google.setOnLoadCallback(init);

// Send the query to the data source.
function init() {

	$("#keyDataForm").submit(function(event){

		// Stop form from submitting normally
		event.preventDefault();

		var $values = validateKeyData();
		if($values == false){
			return;
		}
		
		

		// Specify the data source URL.
		var query = new google.visualization.Query('chartData2',$values);

		// Send the query with a callback function.
		query.send(handleQueryResponse);
	});
}

// Handle the query response.
function handleQueryResponse(response) {
  if (response.isError()) {
    alert('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
    return;
  }

  // Draw the visualization.
  var data = response.getDataTable();
  var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
  chart.draw(data, {width: 600, height: 150, is3D: true});
}

function validateKeyData() {
	
	var upper_freq = $('#upper_frequency').val();
	var lower_freq = $('#lower_frequency').val();
	var if_freq = $('#if_frequency').val();
	var cap_high = $('#cap_high').val();
	var cap_low = $('#cap_low').val();
	
	
	var upper_value;
	var lower_value;

	$(".error").remove()
	
	if (upper_freq == "") {
		console.log("Upper freq not set");
		$("#upperFreqUnits").after("<p class=\"error\">Need to supply the data</p>");
		return false;
	}
	else {
		var upper_freq_unit = $("#upperFreqUnits").val();
		
		upper_value = multiplier(upper_freq, upper_freq_unit);
	}
	
	if (lower_freq == "") {
		console.log("Upper freq not set");
		$("#lowerFreqUnits").after("<p class=\"error\">Need to supply the data</p>");
		return false;
	}
	else {
		var lower_freq_unit = $("#lowerFreqUnits").val();
		
		lower_value = multiplier(lower_freq, lower_freq_unit);
	}
	
	if(upper_value < lower_value) {
		$("#lowerFreqUnits").after("<p class=\"error\">Upper freq < lower freq </p>");
		return false;
	}

	
	if (if_freq == "") {
		console.log("IF freq not set");
		$("#ifFreqUnits").after("<p class=\"error\">Need an IF freq</p>");
		return false;
	}

	if (cap_high == "") {
		console.log("Cap high not set");
		$("#capHighUnits").after("<p class=\"error\">Need a capacitance here</p>");
		return false;
	}
	else {
		var upper_cap_unit = $("#capHighUnits").val();
		
		upper_value = multiplier(cap_high, upper_cap_unit);
	}
	
	if (cap_low == "") {
		console.log("Cap low not set");
		$("#capLowUnits").after("<p class=\"error\">Need a capacitance here</p>");
		return false;
	}
	else {
		var lower_cap_unit = $("#capLowUnits").val();
		
		lower_value = multiplier(cap_low, lower_cap_unit);
	}
	
	if(upper_value < lower_value) {
		$("#capLowUnits").after("<p class=\"error\">High cap < low cap </p>");
		return false;
	}
	
	return {
		'upper_freq' : upper_freq,
		'lower_freq' : lower_freq, 
		'if_freq' : if_freq,
		'cap_high' : cap_high,
		'cap_low' : cap_low
	};
	
}

function multiplier(value, multiplier) {
	
	switch (multiplier) {
	case "MHz":
		return  value * 1E6;
		break;
	case "KHz":
		return  value * 1E3;
		break;
	case "Hz":
		return  value;
		break;
	case "pH":
		return  value * 1E-12;
		break;
	case "nH":
		return  value * 1E-9;
		break;
	case "uH":
		return  value * 1E-6;
		break;
	case "mH":
		return  value * 1E-3;
		break;
	case "pF":
		return  value * 1E-12;
		break;
	case "nF":
		return  value * 1E-9;
		break;
	case "uF":
		return  value * 1E-6;
		break;

	default:
		break;
	}	
}
