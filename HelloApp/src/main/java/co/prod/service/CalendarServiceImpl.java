package co.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.CalendarMapper;
import co.prod.vo.CalendarVO;

public class CalendarServiceImpl implements CalendarService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
	@Override
	public List<CalendarVO> CalendarList() {
		
		return mapper.selectCalendar();
	}
	@Override
	public boolean addCal(CalendarVO vo) {
		
		return mapper.insertCal(vo)==1;
	}
	@Override
	public boolean removeCal(CalendarVO vo) {
		
		return mapper.deleteCal(vo)==1;
	}

	

}
