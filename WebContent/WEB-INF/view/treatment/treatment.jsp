<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/treatment/treatment.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>treatment</h1>
<div id="all">
<form action="../treatment/treatment.treatment" method="post" name="frm">
<div id="p_info">
<table>
<tr>
<th>환자번호<td><input type="text" value="${p_info.p_num}" size="5" readonly="readonly" name="p_num"></td></th>
<th>환자이름<td>${p_info.p_name}</td></th>
<th>환자혈액형<td>${p_info.p_btype}</td></th>
<th>환자성별<td>${p_info.p_sung}</td></th>
<th>환자주치의<td>${s_info.s_name}</td></th>
</tr>

<tr>
<th>환자병명<td>${p_info.p_dname}</td></th>
<th>환자특이사항<td>${p_info.p_snote}</td></th>
<th><td></td></th>
<th><td></td></th>
<th><td></td></th>
</tr>
</table>
</div>

<div id="p_record">
<textarea rows="30" cols="107" name="p_record"></textarea>
</div>

<div id="p_btn">
<input type="submit" value="진료저장" id="submit_btn">
</div>
</form>
</div>
</body>
</html>