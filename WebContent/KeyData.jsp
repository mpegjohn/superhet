<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Superhet tracking calculator</title>
</head>
<body>
	<jsp:useBean id="trackingDataBean" scope="request" class="tracking.Tracking">
		<jsp:setProperty name="trackingDataBean" property="*"/>
	</jsp:useBean>

	<form action="Controller.jsp" method="post"> 
 
 	<h1>Key tracking data</h1>
 
		<label for="upper_frequency">Upper Frequency:</label>
			<input type="text" name="upperFreq" id="upper_frequency"/>
		<label for="lower_frequency">Lower Freq: </label>
			<input type="text" name="lowerFreq" id="lower_frequency"/>
		<label for="if_frequency">IF Freq:</label>
			 <input type="text" name="ifFreq" id="if_frequency"/>
		<label for="cap_high">Tuning Cap highest value:</label>
			 <input type="text" name="capHigh" id="cap_high"/>
		<label for="cap_low">Tuning Cap lowest value:</label>
			 <input type="text" name="capLow" id="cap_low"/>
		<label for="stray">Stray Cap lowest value:</label>
			 <input type="text" name="capStray" id="cap_stray"/>
			 
		
		<input type="submit" value="Submit" />

	</form>


</body>
</html>
