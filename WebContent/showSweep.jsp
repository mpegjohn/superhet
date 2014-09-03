<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="sweepData" scope="session" class="tracking.Sweep">
	</jsp:useBean>

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