package co.prod.service;

import java.util.List;
import java.util.Map;

import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductService {
	public List<ProductVO> products();
	public ProductVO getProduct(String code);
	
	// 상품에 대한 댓글 목록.
	public List<ReplyVO> replyList(String code);
	
	// 댓글삭제
	public boolean removeReply(int replyId);
	
	// 댓글 등록
	public boolean addReply(ReplyVO vo);
	
	// 댓글 한건 조회
	public ReplyVO getReply(int rid);
	
	// 댓글 수정
	public boolean modifyReply(ReplyVO vo);
	
	public List<Map<String, Object>> chartInfo();
	
}
