<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page import="com.hospital.HPmemberDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../temp/header.jsp" %>
<br><br><br>
	<div>
		<form name="frm" action="./adminHPList.admin">
			<input type="hidden" name="curPage">
			<input type="hidden" name="tt" value="h_list">
			<select name="kind">
				<option class="kind" value="p_num">환자번호</option>
				<option class="kind" value="p_name">환자이름</option>
				<option class="kind" value="s_num">주치의번호</option>
			</select>
			<input type="text" name="search" value="${make.search}">
			<button>Search</button>
		</form>
	</div>
	
	<table>
		<tr>
			<td>신청날짜</td>
			<td>환자번호</td>
			<td>환자이름</td>
			<td>주치의번호</td>
			<td>주치의이름</td>
		</tr>
		
		<c:forEach items="${list}" var="i">
			<tr>
				<td>${i.p_sdate} </td>
				<td>${i.p_num}</td>
				<td>${i.p_name} </td>
				<td>${i.s_num} </td>
				<td>${i.s_name} </td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${page.curBlock gt 1}">
		 <input type="button" class="list" title="${page.startNum-1}" value="[이전]">
	</c:if>
	
	<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
		<input type="button" class="list" title="${i}" value="${i}"> 
	</c:forEach>

	<c:if test="${page.curBlock lt page.totalBlock}">
		<input type="button" class="list" title="${page.lastNum+1}" value="[다음]">  
	</c:if>
</body>
</html>