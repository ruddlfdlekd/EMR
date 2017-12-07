<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="com.md.MdDTO" %>
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
	var cur = $(this).attr("m_name");	
	document.frm.curPage.value=cur;
	document.frm.submit();
	});
	});

</script>
</head>
<body>
<h1>${board}</h1>
<div>
<form name="frm" action="./mdMDList.md">
<input type="hidden" name="curPage">
<select name="kind">
<option class="kind" value="m_num">약품번호</option>
<option class="kind" value="m_name">약품이름</option>
<option class="kind" value="m_q">약품수량</option>
<option class="kind" value="m_mf">약품금액</option>
</select>
<input type="text" name="search" value="${make.search}">
<button>Search</button>
</form>
</div>
<table>
<tr>
<td>약품번호</td>
<td>약품이름</td>
<td>약품수량</td>
<td>약품금액</td>
</tr>
<c:forEach items="${list}" var="i">
<tr>
<td>${i.m_num}</td>
<td><a href="">${i.m_name}</a></td>
<td>${i.m_q}</td>
<td>${i.m_mf}</td>
</tr>

</c:forEach>

</table>
<c:if test="${page.curBlock gt 1 }">
<input type="button" class="list" title="${page.startNum-1}" value="[이전]">
</c:if>

<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
<input type="button" class="list" title="${i}" value="${i} " >
</c:forEach>

<c:if test="${page.curBlock lt page.totalBlock }">
<input type="button" class="list" title="${page.last+1}" value="[다음]" >
</c:if>

</body>
</html>