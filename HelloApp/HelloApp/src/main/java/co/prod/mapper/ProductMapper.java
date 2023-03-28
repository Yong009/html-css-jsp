package co.prod.mapper;

import java.util.List;

import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductMapper {
	//목록
	public List<ProductVO> productList();
	public ProductVO selectProduct(String code);
	
	// 댓글목록.
	public List<ReplyVO> replyList(String code);
	// 댓글삭제.
	public int deleteReply(int replyId);
	// 댓글등록.
	public int insertReply(ReplyVO vo);
}
