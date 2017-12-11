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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function(){
		var ah = $(".ah");
		for(var i=0; i<ah.length; i++){
			ah[i].addEventListener("click", function(e) {
				window.open(this.href, "", "top=200, left=300, width=400, height=300");
				 e.preventDefault(); 
			});
		}

		var kind='${make.kind}';
		
		$(".kind").each(function(){
			if($(this).val()==kind){
				$(this).attr("selected", true);
			}
		});
		
		
		
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
<br><br><br>
	<div>
		<form name="frm" action="./adminHPList.admin">
			<input type="hidden" name="curPage">
			<input type="hidden" name="tt" value="ward"> 
			<select name="kind">
				<option class="kind" value="w_num">병동</option>
				<option class="kind" value="w_rnum">병동호수</option>
				<option class="kind" value="p_num">환자번호</option>
			</select>
			<input type="text" name="search" value="${make.search}">
			<button>Search</button>
		</form>
	</div>
	
	<table>
		<tr>
			<td>병동</td>
			<td>병동호수</td>
			<td>최대인원</td>
			<td>환자번호</td>
			<td>환자이름</td>
			<td>환자성별</td>
			<td>주치의번호</td>
			<td>주치의이름</td>
			<td>입원날짜</td>
		</tr>
		
		<c:forEach items="${list}" var="i">
			<tr>
				<td>${i.w_num}</td>
				<td>${i.w_rnum} </td>
				<td>${i.w_rmax} </td>
				<td>${i.p_num} </td>
				<td><a href="adminHPView.admin?p_num=${i.p_num}" class="ah">${i.p_name}</a></td>
				<td>${i.p_sung} </td>
				<td>${i.s_num} </td>
				<td>${i.s_name} </td>
				<td>${i.p_date} </td>

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






