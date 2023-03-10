package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String code = request.getParameter("code");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String press = request.getParameter("press");
		String text = request.getParameter("text");
//		String price = request.getParameter("price");
		
		BookVO vo = new BookVO();
		vo.setBookCode(code);
		vo.setBookAuthor(writer);
//		vo.setBookPrice(Integer.parseInt(price));
		vo.setBookTitle(title);
		vo.setBookPress(press);
		vo.setBookDesc(text);
		
		
		BookService service = new BookServiceMybatis();
		if(service.addBook(vo)) {
			 response.sendRedirect("bookList.do");
		} else {
			try {
				request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp").forward(request,response);
			} catch(ServletException e) {
				e.printStackTrace();
			}
		}
	
	} catch(IOException e) {
		e.printStackTrace();
	}
	}

}
