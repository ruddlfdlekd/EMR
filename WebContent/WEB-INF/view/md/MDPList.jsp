<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="com.md.MdpDTO" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var kind='${make.kind}';
	$(".kind").each(function(){
	if($(this).val()==kind){
		$(this).attr("selected",true);
	}	
	
});
 
	
	
	$(".list").click(function(){
	var cur = $(this).attr("p_num");	
	document.frm.curPage.value=cur;
	document.frm.submit();
	});
	});

</script>
</head>
<body>
<h1>약품처방페이지</h1>
<div>
<form name="frm" action="./MDPList.md">
<input type="hidden" name="curPage">
<select name="kind">
<option class="kind" value="p_num">환자번호</option>
<option class="kind" value="m_name">약품이름</option>
<option class="kind" value="m_q">약품수량</option>
<option class="kind" value="s_num">주치의사번</option>
</select>
<input type="text" name="search" value="${make.search}">
<button>Search</button>
</form>
</div>
<table>
<tr>
<td>환자번호</td>
<td>약품이름</td>
<td>약품수량</td>
<td>주치의사번</td>
</tr>
<c:forEach items="${list}" var="i">
<tr>
<td>${i.p_num}</td>
<td>${i.m_name}</td>
<td>${i.m_q}</td>
<td>${i.s_num}</td>
</tr>

</c:forEach>

</table>
<c:if test="${page.curBlock gt 1 }">
<input type="button" class="list" title="${page.startNum-1}" value="[이전]">
</c:if>

<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
<input type="button" class="list" title="${i}" value="${i}" p_num="${i}" >
</c:forEach>

<c:if test="${page.curBlock lt page.totalBlock }">
<input type="button" class="list" title="${page.last+1}" value="[다음]" >
</c:if>

</body>
</html>