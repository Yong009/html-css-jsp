<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 처리 결과</title>
</head>
<body>
	<h3>회원정보수정결과</h3>
	<%
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (message != null) {
	%>
	<p><%=message%></p>
	<%
	}
	%>

	<p>
</body>
</html>