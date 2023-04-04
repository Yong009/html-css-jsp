package co.prod.service;

import java.util.List;

import co.prod.vo.MembersVO;

public interface MembersService {
	
	//회원 목록(jquery)
	public List<MembersVO> MembersList();
	// 회원등록(jquery)
	public boolean addMembers(MembersVO vo);
	
	// 회원삭제(jquery)
	public boolean removeMembers(String[] users);
}
