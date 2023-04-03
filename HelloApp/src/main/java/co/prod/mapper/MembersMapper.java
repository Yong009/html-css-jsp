package co.prod.mapper;

import java.util.List;

import co.prod.vo.MembersVO;

public interface MembersMapper {
	//목록
	public List<MembersVO> MembersList();
	
	//등록
	public int insertMembers(MembersVO vo);
}
