<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#chart").click(function() {
		location.href="../treatment/chartView.treatment?p_num=${param.p_num}";
	});
	
	$("#treat").click(function() {
		location.href="../treatment/treatment.treatment?p_num=${param.p_num}";
	});
});
</script>
</head>
<body>
<h1>patientInfo준비중</h1>
<h1>${requestScope.p_num}</h1>
<input type="button" value="chart view" id="chart">
<input type="button" value="treatment" id="treat">
<p>
	
</p>
</body>
</html>