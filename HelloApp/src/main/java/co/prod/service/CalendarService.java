package co.prod.service;

import java.util.List;

import co.prod.vo.CalendarVO;

public interface CalendarService {
	
	
	// 캘린더
	public List<CalendarVO> CalendarList();
	
	// 캘린더 등록
	public boolean addCal(CalendarVO vo);
	
	// 캘린더 삭제
	public boolean removeCal(String title);
}
