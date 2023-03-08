package co.dev.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dev.common.DataSource;
import co.dev.mapper.NoticeMapper;
import co.dev.vo.NoticeVO;

public class NoticeServiceMybatis implements NoticeService{
	
	// jdbc: NoticeDAO dao;
	// mybatics: mapper ;
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeList(int page) { //목록
		
		//return mapper.noticeList();
		return mapper.noticeListWithPaging(page);
		
	}

	@Override
	public boolean addNotice(NoticeVO vo) { //등록/
		int r =mapper.insertNotice(vo);
//		sqlSession.commit();
		return r==1;
	}

	@Override
	public NoticeVO getNotice(int nid) {
		mapper.updateCount(nid); //조회수 증가
		return mapper.selectNotice(nid);
	}

	@Override
	public int getTotalCount() {
		
		return mapper.getTotalCount();
	}

	@Override
	public NoticeVO noticeModify(NoticeVO nid) {
		
		return mapper.updateNotice(nid);
		
	}
	
	
	

}
