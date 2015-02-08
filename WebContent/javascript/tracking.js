/**
 * 
 */

function createDataArray(x, y) {

	var xyArray = new Array();

	for (var i = 0; i < x.length; i++) {
		var temp = [ x[i], y[i] ];
		xyArray.push(temp);
	}
	;
	return xyArray;
}

function createTrackingChart(jsonData) {

	var dataArray = createDataArray(jsonData.signalFo, jsonData.trackError);
	
	var plot1 = $.jqplot('chartdiv', [ dataArray ], {

		title : 'Tracking error function',
		axes : {
			// options for each axis are specified in seperate
			// option objects.
			xaxis : {
				label : "Signal circuit frequency Hz",
				// Turn off "padding". This will allow data point to
				// lie on the
				// edges of the grid. Default padding is 1.2 and
				// will keep all
				// points inside the bounds of the grid.
				pad : 0
			},
			yaxis : {
				label : "Error Hz"
			}
		},
		series : [ {
			shadow : false,
			markerOptions : {
				show : false
			}
		} ],
		cursor : {
			show : true,
			zoom : true,
			tooltipLocation : 'sw'
		}

	});

}

google.load('visualization', '1', {'packages':['corechart']});

// Set a callback to run when the API is loaded.
google.setOnLoadCallback(init);

$(document).ready(function() {
	//Load the Visualization API and the ready-made Google table visualization
/*
	$.getJSON("chartData", function(jsonData) {
		createTrackingChart(jsonData);
	});

	$("button").click(function() {
		$("#details").toggle("slow");
	});
	*/
});


// Send the query to the data source.
function init() {

  // Specify the data source URL.
  var query = new google.visualization.Query('chartData2');

  // Send the query with a callback function.
  query.send(handleQueryResponse);
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

