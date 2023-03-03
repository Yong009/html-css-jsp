package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmpDAO {
	Connection conn;

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public Map<String, Object> getEmpInfo(int empId) {
		// {키:값},{키:값},{키:값},{키:값} => map.get('키') 값을 반환
		connect(); // conn객체.
		String sql = "select * from employees where employee_id = ?";
		Map<String, Object> result = new HashMap<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {

				result.put("id", rs.getInt("employee_id"));
				result.put("first_name", rs.getString("first_name"));
				result.put("last_name", rs.getString("last_name"));
				result.put("salary", rs.getInt("salary"));
				result.put("department_id", rs.getInt("department_id"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	// 단건 등록
	public int insertEmp(Map<String, Object> map) {
		// {키:값},{키:값},{키:값},{키:값} => map.get('키') 값을 반환
		connect(); // conn객체.

		String sql = "insert into employees (employee_id, email, hire_date, job_id, last_name) values(?,?,?,?,?)";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, (String) map.get("empId"));
			psmt.setString(2, (String) map.get("email"));
			psmt.setString(3, (String) map.get("hire"));
			psmt.setString(4, (String) map.get("job"));
			psmt.setString(5, (String) map.get("last"));

			int rs = psmt.executeUpdate(); // insert,update,delet

			return rs;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

}
