<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/treatment/chartView.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#treat").click(function() {
		location.href="../treatment/treatment.treatment?p_num=${param.p_num}";
	});
});
</script>
</head>
<body>
<h1>ChartView준비중</h1>
<div id="all">
<div id="p_info">
<table>
<tr>
<td>환자번호<td>${p_info.p_num }</td></td>
<td>환자이름<td>${p_info.p_name}</td></td>
<td>환자혈액형<td>${p_info.p_btype}</td></td>
<td>환자나이<td>${p_info.p_age}</td></td>
<td>환자성별<td>${p_info.p_sung}</td></td>
<td>주치의<td>${s_info.s_name}</td></td>
</tr>
<tr>
<td>환자병명<td>${p_info.p_dname}</td></td>
<td>환자 특이사항<td>${p_info.p_snote}</td></td>
<td><td></td></td>
<td><td></td></td>
<td><td></td></td>
<td><td></td></td>
</tr>
</table>
</div>

<div id="p_treatcontents">
<div id="diagnosis_treatment">
<p>진단 및 처치</p><hr>
</div>
<div id="precription">
<p>투약 및 처방 기록</p><hr>
</div>
<div id="checkup">
<p>검사 기록</p><hr>
</div>
</div>

<div id="p_image">
<p>영상기록</p><hr>
<div id="leftclick">
<input type="button" value="&lt" id="left_btn">
</div>

<div id="rightclick">
<input type="button" value="&gt" id="right_btn">
</div>

</div>
</div>
<p id="t_btn"><input type="button" value="진료기록" id="treat"></p>
</body>
</html>