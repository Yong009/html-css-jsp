package co.yedam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookAddForm implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp");
		
		try {
			rd.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
