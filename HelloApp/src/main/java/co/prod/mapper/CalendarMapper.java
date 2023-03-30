package co.prod.mapper;

import java.util.List;

import co.prod.vo.CalendarVO;

public interface CalendarMapper {
	
	//캘린더
	public List<CalendarVO> selectCalendar();
	
	//캘린더 등록
	public int insertCal(CalendarVO vo);
	
	//캘린더 삭제
	public int deleteCal(String title);
}
