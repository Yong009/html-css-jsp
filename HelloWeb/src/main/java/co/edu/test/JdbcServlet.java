package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

		String eid = req.getParameter("empId");

		if (req.getMethod().equals("GET")) {
			// 조회
			Map<String, Object> result2 = dao.getEmpInfo(Integer.parseInt(eid));
			Set<String> set = result2.keySet();
			for (String key : set) {
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

				System.out.println("key" + key + ",val : " + result2.get(key));

			}
		} else if (req.getMethod().equals("POST")) {
			// 등록
			String empId = req.getParameter("empId");
			String first = req.getParameter("first");
			String last = req.getParameter("last");
			String hire = req.getParameter("hire");
			String job = req.getParameter("job");
			String email = req.getParameter("email");

			Map<String, Object> map = new HashMap<>();
			map.put("empId", empId);
			map.put("first", first);
			map.put("last", last);
			map.put("hire", hire);
			map.put("job", job);
			map.put("email", email);

			int result2 = dao.insertEmp(map);

			System.out.println(result2);
		}

	}
}
