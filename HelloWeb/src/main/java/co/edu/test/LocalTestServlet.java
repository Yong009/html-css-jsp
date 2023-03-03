package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	String str; // 필드. 객체생성: 멤버 변수.
	
	//서블릿의 지역변수 / 멤버변수
	//http: 요청 -> 응답 : 요청,응답 처리가 되면 메모리 사라짐.
	//client A : 요청 -> 응답.
	//client B : 요청 -> 응답.
	
	//클라이언트 : 서버
	//쿠키 : 요청, 세션, 컨텍스트(어플리케이션)(어플리케이션마다 생성되는 객체)
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		str = req.getParameter("msg");
		int num = 0;
		resp.setContentType("text/html;charset=utf-8");
		// 출력스트림 생성
		PrintWriter out = resp.getWriter();
		out.print("<h3>처리결과(지역번수)</h3>");
		while (num++ < 10) {
			out.print(str + " : " + num + "<br>");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.print("<h3>Done</h3>");
		out.close();
	}
}