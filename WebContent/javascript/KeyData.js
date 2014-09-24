function validateKeyData() {
	
	var upper_freq = $('#upper_frequency').val();
	var lower_freq = $('#lower_frequency').val();
	
	if (upper_freq == "" || lower_freq == "") {
		console.log("Upper freq not set");
		$("#upperFreqUnits").after("<p class=\"error\">Need to supply the data</p>");
		return false;
	}
	if (upper_freq < lower_freq) {
		console.log("upper frew should be higher than lower freq");
		return false;
	}
	
	return true;
}