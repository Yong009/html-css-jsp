package co.prod.mapper;

import java.util.List;
import java.util.Map;

import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductMapper {
	
	//목록
	public List<ProductVO> productList();
	public ProductVO selectProduct(String code);
	
	//댓글 목록
	public List<ReplyVO> replyList(String code);
	//댓글 삭제
	public int deleteReply(int replyId);
	
	//댓글 등록
	public int insertReply(ReplyVO vo);
	
	//댓글 한건 조회
	public ReplyVO selectReply(int rid);
	
	//댓글 수정
	public int updateReply(ReplyVO vo);
	
	// chart.부서별 인원 현황.
	public List<Map<String, Object>> chartInfo();
	
}
