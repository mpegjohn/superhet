<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Superhet tracking calculator</title>
</head>
<body>

<script
	    src="//www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load("jquery", "1.4.2");
	google.load("visualization", "1");
</script>
	    
<%--
	<script src="${pageContext.request.contextPath}/javascript/KeyData.js"></script>
 --%>
	<script src="${pageContext.request.contextPath}/javascript/tracking.js"></script>

	<form action="/" id="keyDataForm">

		<h1>Key tracking data</h1>

		<div id="inputData">

			<div class="inputRow">
				<label for="upper_frequency">Upper Frequency:</label> 
				<input type="text" name="upperFreq" id="upper_frequency" /> 
				<select name="upperFreqUnit" id="upperFreqUnits">
					<option>MHz</option>
					<option selected="selected">KHz</option>
					<option>Hz</option>
				</select> 
			</div>
			<div class="inputRow">
				<label for="lower_frequency">Lower Freq: </label> 
				<input type="text" name="lowerFreq" id="lower_frequency" /> 
				<select name="lowerFreqUnit" id="lowerFreqUnits">
					<option>MHz</option>
					<option selected="selected">KHz</option>
					<option>Hz</option>
				</select>
			</div>
			<div class="inputRow">
				<label for="if_frequency">IF Freq:</label> 
				<input type="text" name="ifFreq" id="if_frequency" /> 
				<select name="ifFreqUnit" id="ifFreqUnits">
					<option>MHz</option>
					<option selected="selected">KHz</option>
					<option>Hz</option>
				</select>
			</div>
			<div class="inputRow">
				<label for="cap_high">Tuning Cap highest value:</label> 
				<input type="text" name="capHigh" id="cap_high" /> 
				<select name="capHighUnit" id="capHighUnits">
					<option selected="selected">pF</option>
					<option>nF</option>
					<option>uF</option>
				</select>
			</div>
			<div class="inputRow">
				<label for="cap_low">Tuning Cap lowest value:</label> 
				<input type="text" name="capLow" id="cap_low" /> 
				<select name="capLowUnit" id="capLowUnits">
					<option selected="selected">pF</option>
					<option>nF</option>
					<option>uF</option>
				</select>
			</div>
			<div class="inputRow">
				<label for="stray">Stray Cap value:</label>
				<input type="text" name="capStray" id="cap_stray" /> 
				<select name="capStrayUnit" id="capStrayUnits">
					<option selected="selected">pF</option>
					<option>nF</option>
					<option>uF</option>
				</select>
			</div>
		</div>

		<input type="submit" value="Submit" />

	</form>

	<div id="chart_div"></div>


</body>
</html>
