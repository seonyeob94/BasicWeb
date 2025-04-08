package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;

public interface IMemberService {
	
	//전체 리스트 가져오기
	/*
	 * 
	 * parameter : null
	 * result : list<memberVo>
	 */
	public List<MemberVo> memberList();
}
