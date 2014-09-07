/**
 * 
 */


	var data = {
//		    labels: ["January", "February", "March", "April", "May", "June", "July"],
		    datasets: [
		        {
		            label: "My First dataset",
		            fillColor: "rgba(220,220,220,0.2)",
		            strokeColor: "rgba(220,220,220,1)",
		            pointColor: "rgba(220,220,220,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(220,220,220,1)",
//		            data: [65, 59, 80, 81, 56, 55, 40]
		        }
		    ]
		};
	
	function update() {
		// Get context with jQuery - using jQuery's .get() method.
		var ctx = $("#trackingErrorChart").get(0).getContext("2d");
		// This will get the first returned node in the jQuery collection.
		new Chart(ctx).Line(data);		
	};
	
	function createDataArray(x, y) {
		
		var xyArray = new Array();
		
		for (var i = 0; i < x.length; i++) {
			var temp = [x[i], y[i]];
			xyArray.push(temp);
		};
		return xyArray;
	}
	
		$(document).ready(function() {

			$.getJSON("chartData", function(jsonData) {
				data.labels = jsonData.signalFo;
				data.datasets[0].data = jsonData.trackError;
				update();
			});

			
			

			
		});