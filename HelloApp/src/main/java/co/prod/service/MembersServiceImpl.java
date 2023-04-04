package co.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.MemberMapper;
import co.prod.mapper.MembersMapper;
import co.prod.vo.MembersVO;

public class MembersServiceImpl implements MembersService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MembersMapper mapper = sqlSession.getMapper(MembersMapper.class);
	@Override
	public List<MembersVO> MembersList() {
		
		return mapper.MembersList();
	}
	@Override
	public boolean addMembers(MembersVO vo) {
		
		return mapper.insertMembers(vo)==1;
	}
	@Override
	public boolean removeMembers(String[] users) {
		
		return mapper.deleteMembers(users)>0;
	}

}
