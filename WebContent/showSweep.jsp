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

	<script
		src="${pageContext.request.contextPath}/javascript/quantities.js"></script>


	<script src="${pageContext.request.contextPath}/javascript/tracking.js"></script>

	<jsp:useBean id="sweepData" scope="session" class="tracking.Sweep">
	</jsp:useBean>

	<div id="chartdiv" style="height: 400px; width: 800px;"></div>

	<div id="components">
		<div id="Oscillator circuit">
			<h3>Oscillator components</h3>
			<p>Inductor:  
			${sweepData.getOsc().getLo().toString()} 
			</p>
			<p>Padder:
			${sweepData.getOsc().getP().toString()}
			</p>
			<p>Tc:
			${sweepData.getOsc().getTc().toString()}
			</p>
			<p>Tl:
			${sweepData.getOsc().getTl().toString()}
			</p>
		</div>
		<div id="signal circuit">
			<h3>Signal components</h3>
			<p>Inductor:
			${sweepData.getSig().getL().toString()}
			</p>
			<p>T:
			${sweepData.getSig().getT().toString()}
			</p>
		</div>
	</div>

	<button>Show details</button>
	
	<div id="details">
		<p>f<sub>3</sub>: ${sweepData.getTrack().getF3()}</p>
		<p>G<sub>max</sub>: ${sweepData.getTrack().getGmax()}</p>
		<p>&alpha;=${sweepData.getTrack().getAlpha()}</p>
		
		<p>P<sub>min</sub>:
		${sweepData.getOsc().getPmin().toString()}
		</p>
		<p >P<sub>max</sub>:
		${sweepData.getOsc().getPmax().toString()}
		</p>
		<p>Tl<sub>max</sub>: ${sweepData.getOsc().getTlmax().toString()}</p>
		<p>R: ${sweepData.getOsc().getR()}</p>
		<p>&beta;: ${sweepData.getOsc().getBeta()}</p>
	</div>


</body>
</html>
