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

function calcUnitMult(number) {

	if((number >=1E-9) && (number < 1E-6))
	{
        	return "p";
	}

	if((number >=1E-6) && (number < 1E-3))
	{
        	return "u";
	}

	if((number >=1E-3) && (number < 1))
	{
        	return "m";
	}

}

$(document).ready(function() {

	$.getJSON("chartData", function(jsonData) {
		createTrackingChart(jsonData);
	});

	$("button").click(function() {
		$("#details").toggle("slow");
	});
	
	$(".inductor").text(function(i, text) {
			console.log("i is: " + i + " text is:" + text);
			var number = text.match(/-?(?:0|[1-9]\d*)(?:\.\d*)?(?:[eE][+\-]?\d+)?/);
			console.log("number is: " + number);
			
			var uH = new RegExp("E-6");
			var mH = new RegExp("E-3");
			
			if(uH.test(number)) {
				
				number = number * 1E+6;
				
				number = number + "uH";
			}
			else if(mH.test(number)) {
				
				number = number * 1E+3;
				
				number = number + "mH";
			}
			
			
	});  

});
