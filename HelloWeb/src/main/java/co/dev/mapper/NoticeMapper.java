package co.dev.mapper;

import java.util.List;

import co.dev.vo.NoticeVO;

public interface NoticeMapper {
	// 목록
	public List<NoticeVO> noticeList();
	
	//페이징
	public List<NoticeVO> noticeListWithPaging(int page);
	
	// 등록
	public int insertNotice(NoticeVO vo);
	// 단건조회.
	public NoticeVO selectNotice(int nid);
	// 조회수 증가
	public int updateCount(int nid);
	// 전체 건수.
	public int getTotalCount();
	// 수정
	public NoticeVO updateNotice(NoticeVO vo);
}
