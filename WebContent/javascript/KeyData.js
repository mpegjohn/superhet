function validateKeyData() {
	
	var upper_freq = $('#upper_frequency').val();
	var lower_freq = $('#lower_frequency').val();
	
	var upper_value;
	var lower_value;
	
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
	}
	
	if (upper_freq < lower_freq) {
		console.log("upper frew should be higher than lower freq");
		$("#lowerFreqUnits").after("<p class=\"error\">Need to supply the data</p>");
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