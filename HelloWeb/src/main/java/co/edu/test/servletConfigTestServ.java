package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletConfigTestServ extends HttpServlet {
	String enc;
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		super.init(config);// init 메소드에서 Context값을 지정.
		
	}
	
	
	// /servletConfigTest, /servletconfig
		//context에 param : 값, context에 값을 불러.
		//setAttribute("param"), getAttribute("param")
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc); // 요청정보 : 한글처리 X
		System.out.println(enc);
		
		//ServletContext 는 어플리케이션에 생성되는 객체.
		ServletContext sc = this.getServletContext(); // 객체에 소속된 메서드.
		System.out.println("sc : " + sc);
		String param = sc.getInitParameter("contextConfig");
		System.out.println("param: " + param);
		
		// 공유된 값을 불러오기.
		System.out.println("공유된 param: " + sc.getAttribute("param"));
		
		
		
		resp.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print("이름: " +req.getParameter("name"));
		
		out.close();
		
	}
}
