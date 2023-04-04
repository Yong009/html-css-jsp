<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet">
		<script src="jquery/jquery-3.6.4.min.js"></script>
		<script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
		<script>
			$(document).ready(function () {
				$('#example').DataTable({
					ajax: 'dataTableAjax.do',

				});
			});
		</script>
		<script>
			$(document).ready(function () {
				var t = $('#example').DataTable();
				$('#addRow').on('click', function () {


					let eid;
					$.ajax({
						url: "dataTableAddAjax.do",
						data: {
							first: $('#first').val(),
							last: $('#last').val(),
							email: $('#email').val(),
							hireDate: $('#hireDate').val(),
							salary: $('#salary').val()
						},
						method: "post",
						dataType: "json",
						async: false,
						success: function (result) {
						eid = result.id




						}
					})



					t.row.add([eid, $('#first').val(), $('#last').val(), $('#email').val(), $('#hireDate').val(), $('#salary').val()]).draw(false);










				});

				// Automatically add a first row of data


			});

		</script>
	</head>

	<body>
		<p>dataTable</p>
		<input type="text" id="first">
		<br>
		<input type="text" id="last">
		<br>
		<input type="email" id="email">
		<br>
		<input type="date" id="hireDate">
		<br>
		<input type="number" id="salary">
		<br>
		<button id="addRow">등록</button>
		<br>

		<br>
		<table id="example" class="display" style="width: 100%">
			<thead>
				<tr>
					<th>사원번호</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>HireDate</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>사원번호</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>HireDate</th>
					<th>Salary</th>
				</tr>
			</tfoot>
		</table>
	</body>

	</html>