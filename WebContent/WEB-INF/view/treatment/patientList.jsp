<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/treatment/patientList.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#rv_btn").click(function(){
		location.href="../treatment/rvpatientList.treatment"
	});
});

$(function() {
	$(".list").click(function(){
		var cur = $(this).attr("title");
		document.frm.curPage.value=cur;
		document.frm.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../../temp/header.jsp" %>
<h1>${list}</h1>
<div id="table">
<table>
<tr>
<th>환자번호(P_NUM)</th>
<th>환자성명(P_NAME)</th>
<th>환자나이(P_AGE)</th>
<th>환자주치의(P_S_NUM)</th>
<th>환자혈액형(P_BTYPE)</th>
<th>환자병명(P_DNAME)</th>
<th>환자특이사항(P_SNOTE)</th>
</tr>

<tr>
<c:forEach items="${ptList}" var="i">
<tr>
<td>${i.p_num}</td>
<td><a href="../treatment/chartView.treatment?p_num=${i.p_num}">${i.p_name}</a></td>
<td>${i.p_age}</td>
<td>${i.p_s_num}</td>
<td>${i.p_btype}</td>
<td>${i.p_dname}</td>
<td>${i.p_snote}</td>
</tr>
</c:forEach>

</tr>
</table>
</div>

<div id="page">
<form name="frm" action="../treatment/patientList.treatment">
<input type="hidden" name="curPage">
<c:if test="${page.curBlock > 1 }">
<input type="button" class="list" title="${page.startNum-1} }" value="[이전]">
</c:if>
<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
<input type="button" class="list" title="${i}" value="${i}">
</c:forEach>
<c:if test="${page.curBlock < page.totalBlock }">
<input type="button" class="list" title="${page.lastNum+1}" value="[다음]">
</c:if>
</form>
</div>

<p id="btn_area"><input type="button" value="예약리스트" id="rv_btn"></p>
</body>
</html>