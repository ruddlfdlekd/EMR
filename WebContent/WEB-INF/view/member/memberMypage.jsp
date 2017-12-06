<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../temp/header.jsp" %>
<h1>사원번호 : ${member.s_num}</h1>
<h1>이름 : ${member.s_name}</h1>
<h1>나이 : ${member.s_age}</h1>
<h1>생일 : ${member.s_birth}</h1>
<h1>이메일 : ${member.s_email}</h1>
<h1>휴대번호 : ${member.s_phone}</h1>
	<c:choose>
		<c:when test="${member.s_job eq 1 }"><h1>의료진</h1></c:when>
		<c:when test="${member.s_job eq 2 }"><h1>원무팀</h1></c:when>
		<c:when test="${member.s_job eq 3 }"><h1>약품과</h1></c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</body>
<a href="./memberUpdate.member"><input type="button" value="수정"></a>

</html>