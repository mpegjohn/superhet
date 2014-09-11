<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery.jqplot.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/javascript/jquery.jqplot.js"></script>

	<script
		src="${pageContext.request.contextPath}/javascript/plugins/jqplot.cursor.js"></script>

	<script src="${pageContext.request.contextPath}/javascript/tracking.js"></script>

	<jsp:useBean id="sweepData" scope="session" class="tracking.Sweep">
	</jsp:useBean>

	<div id="chartdiv" style="height: 400px; width: 800px;"></div>

	<div id="components">
		<div id="Oscillator">
			<h3>Oscillator components</h3>
			<p>Inductor: <fmt:formatNumber 
			value="${sweepData.getOsc().getLo()}" 
			pattern="###.###E0" 
			type="number"></fmt:formatNumber></p>
			<p>Padder: <fmt:formatNumber
			value="${sweepData.getOsc().getP()}"
			pattern="###.###E0" 
			type="number"></fmt:formatNumber></p>
			<p>Tc: <fmt:formatNumber
			value="${sweepData.getOsc().getTc()}"
			pattern="###.###E0" 
			type="number"></fmt:formatNumber></p>
			<p>Tl: <fmt:formatNumber
			value="${sweepData.getOsc().getTl()}"
			pattern="###.###E0" 
			type="number"></fmt:formatNumber></p>
		</div>
		<div id="signals">
			<h3>Signal components</h3>
			<p>Inductor: <fmt:formatNumber
			value="${sweepData.getSig().getL()}"
			pattern="###.###E0" 
			type="number"></fmt:formatNumber></p>
			<p>T:  <fmt:formatNumber
			value="${sweepData.getSig().getT()}"
			pattern="###.###E0" 
			type="number"></fmt:formatNumber></p>
		</div>
	</div>

	<button>Show details</button>
	
	<div id="details">
		
		<p>f3=${sweepData.getTrack().getF3()}</p>
	
	
	</div>


</body>
</html>