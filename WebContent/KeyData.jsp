<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="myBean" class="student.Fred" scope="page"></jsp:useBean>

	<form action="KeyData.jsp" method="post">

		<div id="upper_frequency">
			Upper Freq: <input type="text" name="upperfreq">

		</div>
		<div id="lower_frequency">
			Lower Freq: <input type="text" name="lowerfreq">
		</div>
		<div id="if_frequency">
			IF Freq: <input type="text" name="iffreq">
		</div>



	</form>


</body>
</html>