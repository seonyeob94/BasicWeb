package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	
	//dao 객체 필요
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	// 자신의 객체 생성 리턴
	private static IMemberService service;
	public static IMemberService getService() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	

	@Override
	public List<MemberVo> memberList() {
		
		return dao.memberList();
	}


	@Override
	public MemberVo loginMember(MemberVo vo) {
		
		return dao.loginMember(vo);
	}

}
