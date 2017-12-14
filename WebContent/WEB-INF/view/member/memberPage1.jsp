<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#p_list_btn").click(function() {
		location.href="../treatment/patientList.treatment"
	});
});
</script>
</head>
<body>
<%@ include file="../../temp/header.jsp" %>

<h1>진료페이지</h1>
<p><input type="button" value="전체환자리스트" id="p_list_btn"></p>
</body>
</html>