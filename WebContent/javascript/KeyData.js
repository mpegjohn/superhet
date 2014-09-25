
$(document).ready(function() {

	$("#cap_stray").val(8)
	$("#if_frequency").val(455)
	
});


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
	
	
	return true;
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
