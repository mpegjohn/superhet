/**
 * 
 */

google.load('visualization', '1', {'packages':['corechart']});

// Set a callback to run when the API is loaded.
google.setOnLoadCallback(init);

// Send the query to the data source.
function init() {

	$("keyDataForm"),submit(function(event){

		// Stop form from submitting normally
		event.preventDefault();

		var $form = $(this)

		// Specify the data source URL.
		var query = new google.visualization.Query('chartData2');

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

