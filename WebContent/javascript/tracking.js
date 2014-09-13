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

function calcUnitMult(number, unit) {
	
	var mults = ['f', 'p', 'u', 'm'];
	
	var mult = "";
	
	while(number < 1.0) {
		number *= 1000;
		mult = mults.pop();
	}
	
	var formattedNumber = number + " " + mult + unit;
	
	//console.log("formatted number: " + formattedNumber);
	
	var ind = Qty(formattedNumber);
	//console.log(ind);
	
	return ind.toPrec(0.01).toString();
}

$(document).ready(function() {

	$.getJSON("chartData", function(jsonData) {
		createTrackingChart(jsonData);
	});

	$("button").click(function() {
		$("#details").toggle("slow");
	});
	
	$(".inductor").text(function(i, text) {
			//console.log("i is: " + i + " text is:" + text);
			var number = text.match(/-?(?:0|[1-9]\d*)(?:\.\d*)?(?:[eE][+\-]?\d+)?/);

			var num = calcUnitMult(number, 'H');
			
			var type = text.match(/^.*:/);
			
			return (type + " " + num);
			
	});
	$(".capacitor").text(function(i, text) {
		//console.log("i is: " + i + " text is:" + text);
		var number = text.match(/-?(?:0|[1-9]\d*)(?:\.\d*)?(?:[eE][+\-]?\d+)?/);

		var num = calcUnitMult(number, 'F');
		
		var type = text.match(/^.*:/);
		
		return (type + " " + num);

});

});
