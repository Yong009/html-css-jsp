<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../includes/sidebar.jsp"%>
<%@ include file="../includes/top.jsp"%>


<body>
	<h3>회원가입</h3>
	<form action="memberInsert.do" method="post">
	<table class ="table">
	<tr><td> ID: <input type="text" name="id"></td></tr> 
	<tr><td> PW: <input type="password" name="pass"></td></tr> 
	<tr><td> Name: <input type="text" name="name"></td></tr>
	<tr><td> Mail: <input type="email"	name="mail"></td></tr>
	<tr><td colspan="2" align="center"> <input type="submit" class="btn btn-primary">
	
	</table>
	
	<a href ="memberInsertForm.do">이동</a>
	</form>
	<%@ include file="../includes/footer.jsp"%>