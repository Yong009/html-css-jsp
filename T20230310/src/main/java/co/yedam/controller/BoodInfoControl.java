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
<<<<<<< HEAD
		
		String code = request.getParameter("code");
=======
		String bc = request.getParameter("bookCode");
>>>>>>> branch 'master' of https://github.com/Yong009/html-css-jsp.git
		
		BookService service = new BookServiceMybatis();
		BookVO vo = service.getBookInfo(code);
		
		
		
		
		request.setAttribute("notice", vo);
		
		try {
			request.getRequestDispatcher("WEB-INF/book/bookInfo.jsp").forward(request, response);
		} catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
