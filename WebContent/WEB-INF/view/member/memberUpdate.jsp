<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../temp/header.jsp" %>
<form action="./memberUpdate.member" method="post">
<p>비밀번호 : <input type="text" name="s_pw" value="${member.s_pw }"></p>
<p>이름 : <input type="text" name="s_name" value="${member.s_name }"></p>
<p>휴대폰번호 : <input type="text" name="s_phone" value="${member.s_phone }"></p>
<p>이메일 : <input type="text" name="s_email" value="${member.s_email }"></p>
<button>수정</button>
</form>
</body>
</html>