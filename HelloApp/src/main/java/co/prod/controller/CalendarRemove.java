package co.prod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.CalendarService;
import co.prod.service.CalendarServiceImpl;
import co.prod.vo.CalendarVO;

public class CalendarRemove implements Control {
	
	
			
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		CalendarVO vo = new CalendarVO();
		vo.setTitle(title);
		vo.setStartDate(start);
		vo.setEndDate(end);
		
		
		CalendarService service = new CalendarServiceImpl();
		
		boolean result = service.removeCal(vo);
		
		String json = "";
		if(result) {
			// {"retCode": "Success"}
			json = "{\"retCode\": \"Success\"}";
		} else {
			// {"retCode": "Fail"}
			json = "{\"retCode\": \"Fail\"}";
		}
		return json +".ajax";
	}
		
		
	

}
