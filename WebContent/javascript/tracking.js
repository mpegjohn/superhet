/**
 * 
 */
//google.load('visualization', '1', {'packages':['corechart']});
// Set a callback to run when the API is loaded.
google.setOnLoadCallback(init);

// Send the query to the data source.
function init() {

    $("#keyDataForm").submit(function(event) {

        // Stop form from submitting normally
        event.preventDefault();

        var values = validateKeyData();
        if (values == false) {
            return;
        }

        var query_string = "?";

        for (key in values) {

            query_string += key + "=" + values[key] + "&";
        }

        // remove the last &
        query_string = query_string.substring(0, query_string.length - 1);

        query_string = "chartData2" + query_string;
        
        var capStrayUnit = $("#capStrayUnits").val();
        var capStray = $("#cap_stray").val();
        
        query_string += "&capStrayUnit=" + capStrayUnit;
        query_string += "&capStray=" + capStray;
        // Specify the data source URL.
        var query = new google.visualization.Query(query_string);

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
    
    var properties = data.hr;

    var oscFreqView = new google.visualization.DataView(data);
    oscFreqView.hideColumns([1]);

    var errorFreqView = new google.visualization.DataView(data);
    errorFreqView.hideColumns([2]);

    var options = {
            width: 700,
            height: 300,
            title: 'Oscillator Frequecy',
            curveType: 'function',
            legend: { position: 'bottom' },
    };
    
    var oscCart = new google.visualization.LineChart(document.getElementById('osc_chart_div'));
    oscCart.draw(oscFreqView, options);
    
    options['title'] = 'Error Frequency';
    
    var errCart = new google.visualization.LineChart(document.getElementById('error_chart_div'));
    errCart.draw(errorFreqView, options);
    
    
    $("#osc_inductor").text(properties.osc_ind);
    $("#osc_trimmer").text(properties.osc_trimmer);
    $("#osc_padder").text(properties.osc_padder);
    $("#osc_stray").text(properties.osc_stray);
    
    $("#sig_inductor").text(properties.sig_ind);
    $("#sig_trimmer").text(properties.sig_trimmer);
    
}

function validateKeyData() {

    var upperFreq = $('#upper_frequency').val();
    var lowerFreq = $('#lower_frequency').val();
    var ifFreq = $('#if_frequency').val();
    var capHigh = $('#cap_high').val();
    var capLow = $('#cap_low').val();
    var upperFreqUnit = $("#upperFreqUnits").val();
    var lowerFreqUnit = $("#lowerFreqUnits").val();
    var upperCapUnit = $("#capHighUnits").val();
    var lowerCapUnit = $("#capLowUnits").val();
    var ifFreqUnit = $("#ifFreqUnits").val();

    var upper_value;
    var lower_value;

    $(".error").remove()

    if (upperFreq == "") {
        console.log("Upper freq not set");
        $("#upperFreqUnits").after("<p class=\"error\">Need to supply the data</p>");
        return false;
    } else {
        upper_value = multiplier(upperFreq, upperFreqUnit);
    }

    if (lowerFreq == "") {
        console.log("Upper freq not set");
        $("#lowerFreqUnits").after("<p class=\"error\">Need to supply the data</p>");
        return false;
    } else {
        lower_value = multiplier(lowerFreq, lowerFreqUnit);
    }

    if (upper_value < lower_value) {
        $("#lowerFreqUnits").after("<p class=\"error\">Upper freq < lower freq </p>");
        return false;
    }


    if (ifFreq == "") {
        console.log("IF freq not set");
        $("#ifFreqUnits").after("<p class=\"error\">Need an IF freq</p>");
        return false;
    }

    if (capHigh == "") {
        console.log("Cap high not set");
        $("#capHighUnits").after("<p class=\"error\">Need a capacitance here</p>");
        return false;
    } else {
        upper_value = multiplier(capHigh, upperCapUnit);
    }

    if (capLow == "") {
        console.log("Cap low not set");
        $("#capLowUnits").after("<p class=\"error\">Need a capacitance here</p>");
        return false;
    } else {

        lower_value = multiplier(capLow, lowerCapUnit);
    }

    if (upper_value < lower_value) {
        $("#capLowUnits").after("<p class=\"error\">High cap < low cap </p>");
        return false;
    }

    return {
        'upperFreq': upperFreq,
        'lowerFreq': lowerFreq,
        'ifFreq': ifFreq,
        'capHigh': capHigh,
        'capLow': capLow,
        'upperFreqUnit' : upperFreqUnit,
        'lowerFreqUnit' : lowerFreqUnit,
        'capHighUnit' : upperCapUnit,
        'capLowUnit' : lowerCapUnit,
        'ifFreqUnit' : ifFreqUnit
    };

}

function multiplier(value, multiplier) {

    switch (multiplier) {
        case "MHz":
            return value * 1E6;
            break;
        case "KHz":
            return value * 1E3;
            break;
        case "Hz":
            return value;
            break;
        case "pH":
            return value * 1E-12;
            break;
        case "nH":
            return value * 1E-9;
            break;
        case "uH":
            return value * 1E-6;
            break;
        case "mH":
            return value * 1E-3;
            break;
        case "pF":
            return value * 1E-12;
            break;
        case "nF":
            return value * 1E-9;
            break;
        case "uF":
            return value * 1E-6;
            break;

        default:
            break;
    }
}
