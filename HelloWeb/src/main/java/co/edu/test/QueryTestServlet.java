package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		// 사용자가 값을 여러개를 전송.
		// 각 값을 System.out.print("콘솔에 출력");
		req.setCharacterEncoding("utf-8"); // 요청정보의 인코딩 방식 지정.
		
		resp.setCharacterEncoding("utf-8"); // 응답정보의 인코딩 방식 지정.
		resp.setContentType("text/html;charset=utf-8");
		
		
		
		String id =req.getParameter("id"); // guest
		String pw =req.getParameter("pwd"); // 1234
		String name = req.getParameter("name"); // 홍준표
		String hobby = req.getParameter("hobby"); // 1ea 
		String gender =req.getParameter("gender"); // female
		String religion = req.getParameter("religion"); // atheism
		String introduction = req.getParameter("introduction"); //한글
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(hobby);
		System.out.println(gender);
		System.out.println(religion);
		System.out.println(introduction);
		
		
		PrintWriter out = resp.getWriter();
		
		out.print("결과");
		out.close();
//		String html = "";
//		html += "ID :" + id;
//		html += "pw :" + pw;
//		html += 
		
		
		
		
		
	
	
	}
	
	
}
