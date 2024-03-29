package co.prod.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.controller.CalendarAdd;
import co.prod.controller.CalendarForm;
import co.prod.controller.CalendarList;
import co.prod.controller.CalendarRemove;
import co.prod.controller.ChartAjax;
import co.prod.controller.ChartControl;
import co.prod.controller.CovidForm;
import co.prod.controller.DataTableAjax;
import co.prod.controller.DataTableForm;
import co.prod.controller.DateTableAddAjax;
import co.prod.controller.MapForm;
import co.prod.controller.MemberAddAjax;
import co.prod.controller.MemberJquery;
import co.prod.controller.MemberListAjax;
import co.prod.controller.MemberListControl;
import co.prod.controller.MembersListJquery;
import co.prod.controller.MemberRemoveAjax;
import co.prod.controller.MemberRemoveJquery;
import co.prod.controller.MembersAddJquery;
import co.prod.controller.MembersControl;
import co.prod.controller.ProductInfoControl;
import co.prod.controller.ProductListControl;
import co.prod.controller.ReplyAddAjax;
import co.prod.controller.ReplyListAjax;
import co.prod.controller.ReplyModifyAjax;
import co.prod.controller.ReplyRemoveAjax;
import co.prod.controller.ReplySearchAjax;

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
		//Ajax 출력(spa처리)
		map.put("/memberListAjax.do", new MemberListAjax());
		map.put("/memberRemoveAjax.do", new MemberRemoveAjax());
		map.put("/memberAddAjax.do", new MemberAddAjax());
		
		
		// 상품목록
		map.put("/productList.do", new ProductListControl());
		// 상품한건정보.
		map.put("/productInfo.do", new ProductInfoControl());
		// 상품댓글정보 목록
		map.put("/replyListAjax.do", new ReplyListAjax());
		// 상품댓글 삭제
		map.put("/replyRemoveAjax.do", new ReplyRemoveAjax());
		// 상품댓글 등록
		map.put("/replyAddAjax.do", new ReplyAddAjax());
		// 상품댓글번호 조회.
		map.put("/replySearchAjax.do", new ReplySearchAjax());
		// 상품댓글 수정
		map.put("/replyModifyAjax.do", new ReplyModifyAjax());
		
		
		// jquery용 ajax.
		map.put("/memberJquery.do", new MemberJquery());
		// 목록을 가지고 오도록. memberListJquery.do.
		map.put("/membersListJquery.do", new MembersListJquery());
		// jquery 등록
		map.put("/membersAddJquery.do", new MembersAddJquery());
		// 삭제
		map.put("/memberRemoveJquery.do", new MemberRemoveJquery());
		
		
		// datatable 활용
		// dataTableForm.do => 화면출력
		map.put("/dataTableForm.do", new DataTableForm());
		// dataTableAjax.do => 데이터 출력
		map.put("/dataTableAjax.do", new DataTableAjax());
		// data 등록
		map.put("/dataTableAddAjax.do", new DateTableAddAjax());
		
		// chart
		map.put("/chart.do", new ChartControl());
		// chart 데이터.
		map.put("/chartAjax.do", new ChartAjax());
		// covid.
		map.put("/covid19.do", new CovidForm());
		// map api
		map.put("/map.do", new MapForm());
		// calendar
		map.put("/calendar.do", new CalendarForm());
		// calendar 창
		map.put("/calendarList.do", new CalendarList());
		// calendar 등록
		map.put("/calendarAdd.do", new CalendarAdd());
		
		//calendar 삭제
		map.put("/calendarRemove.do", new CalendarRemove());
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

		} else if(viewPage.endsWith(".ajax")) {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().append(viewPage.substring(0,viewPage.length()-5));
			return;
		}
		// 페이지 재지정.
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);

	}
}
