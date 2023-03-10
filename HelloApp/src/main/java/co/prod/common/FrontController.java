package co.prod.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.controller.MemberListControl;
import co.prod.controller.MembersControl;
import co.prod.controller.ProductInfoControl;
import co.prod.controller.ProductListControl;

public class FrontController extends HttpServlet {
	private Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init() throws ServletException {
		// url <-> control
		map.put("/memberList.do", new MemberListControl());
		map.put("/members.do", new MembersControl());
		
		// 상품목록
		map.put("/productList.do", new ProductListControl());
		map.put("/productInfo.do", new ProductInfoControl());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println(context);
		String page = uri.substring(context.length());
		System.out.println("do : " + page);
		
		Control command = map.get(page);
		String viewPage = command.exec(req, resp); //product/productList.tiles
		
		if (viewPage.endsWith(".jsp")) {
			viewPage = "WEB-INF/views/" + viewPage;
//		} else if (viewPage.endsWith(".tiles")) { // members.do(...tiles)
			//viewPage = "/" + viewPage;

		}
		// 페이지 재지정.
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);

	}
}