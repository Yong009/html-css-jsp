package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodInfoControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bc = request.getParameter("bc");
		
		BookService service = new BookServiceMybatis();
		BookVO vo = service.getBookInfo(bc);
		
		System.out.println(vo);
		request.setAttribute("notice", vo);
		
		System.out.println(vo);
		try {
			request.getRequestDispatcher("WEB-INF/book/bookInfo.jsp").forward(request, response);
		} catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
