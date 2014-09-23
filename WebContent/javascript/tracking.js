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


$(document).ready(function() {

	$.getJSON("chartData", function(jsonData) {
		createTrackingChart(jsonData);
	});

	$("button").click(function() {
		$("#details").toggle("slow");
	});
});


