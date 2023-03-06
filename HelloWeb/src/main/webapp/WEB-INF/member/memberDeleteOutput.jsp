<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/sidebar.jsp"%>
<%@ include file="../includes/top.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 처리 결과</title>
</head>
<body>


	<h3>회원정보삭제결과(memberDeleteOutput.jsp)</h3>
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

	<%@ include file="../includes/footer.jsp"%>

	<p>
</body>
</html>