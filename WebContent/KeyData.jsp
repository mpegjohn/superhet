<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Superhet tracking calculator</title>
</head>
<body>



	<jsp:useBean id="myBean" class="tracking.Tracking" scope="request">
		<jsp:setProperty name="myBean" property="*" />
	</jsp:useBean>

	<form action="Controller.jsp" method="post">

		<div id="upper_frequency">
			Upper Freq: <input type="text" name="upperFreq"
			value="<jsp:getProperty property="upperFreq" name="myBean"/>"
			>
		</div>
		<div id="lower_frequency">
			Lower Freq: <input type="text" name="lowerFreq"
			value="<jsp:getProperty property="lowerFreq" name="myBean"/>"
			>
		</div>
		<div id="if_frequency">
			IF Freq: <input type="text" name="ifFreq"
			value="<jsp:getProperty property="ifFreq" name="myBean"/>"
			>
		</div>
		<div id="cap_high">
			Tuning Cap highest value: <input type="text" name="capHigh"
			value="<jsp:getProperty property="capHigh" name="myBean"/>"
			>
		</div>
		<div id="cap_low">
			Tuning Cap lowest value: <input type="text" name="capLow"
			value="<jsp:getProperty property="capLow" name="myBean"/>"
			>
		</div>

		
		<input type="submit" value="Submit" />

	</form>


</body>
</html>