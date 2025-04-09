package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;

public interface IMemberDao {

	//전체 리스트 가져오기
	/*
	 * 
	 * parameter : null
	 * result : list<memberVo>
	 */
	public List<MemberVo> memberList();
	
	/*
	 * 로그인 하기
	 * parameter : MemberVo (mem_id, mem_pass)
	 * result : MemberVo
	 * 
	 */
	
	public MemberVo loginMember(MemberVo vo);

}
