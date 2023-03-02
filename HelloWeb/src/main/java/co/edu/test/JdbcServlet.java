package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();

		// 페이지 출력. 사번/이름(이름+성씨)/급여/부서
		int ID = Integer.parseInt(req.getParameter("empId"));

		Map<String, Object> result = dao.getEmpInfo(ID);

		PrintWriter out = resp.getWriter();

		System.out.println(result.get("id"));
		System.out.println(result.get("last_name"));
		System.out.println(result.get("first_name"));
		System.out.println(result.get("department_id"));
		System.out.println(result.get("salary"));
		// 페이지 작성.

		out.print(result);

		out.close();

		
		int id = Integer.parseInt(req.getParameter("empId"));
		
		String sung = req.getParameter("last_name");
		String name = req.getParameter("first_name");
		String 
		
		
	}
}
