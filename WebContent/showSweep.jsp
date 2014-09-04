<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/Chart.min.js"></script>
	
	<script type="text/javascript">
	
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
		var lineChart = new Chart(ctx).Line(data);		
	};
	
		$(document).ready(function() {

			$.getJSON("chartData", function(jsonData) {
				data.labels = jsonData.signalFo;
				data.datasets[0].data = jsonData.trackError;
				update();
			});

			
			

			
		});
	</script>

	<jsp:useBean id="sweepData" scope="session" class="tracking.Sweep">
	</jsp:useBean>

<canvas id="trackingErrorChart" width="800" height="400"></canvas>

	<table>
		<tr>
			<th>Oscillator</th>
			<th>Signal</th>
			<th>Error</th>
		</tr>

		<c:forEach begin="0" end="100" step="1" var="i">
			<tr>
				<td>"${sweepData.oscFo[i]}"</td>
				<td>"${sweepData.signalFo[i]}"</td>
				<td>"${sweepData.trackError[i]}"</td>
			</tr>
		</c:forEach>
	</table>
	<%-- 
	<c:forEach items="${sweepData.trackError}" var="osc">
		Osc "${osc}" <br/>
	</c:forEach>
--%>

</body>
</html>