package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

public interface IMemberService {
	
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
	
	// 아이디 중복검사
	public String idCheck(String id);
	
	// 우편번호 검색
	public List<ZipVo> selectByDong(String dong);
	
	// 저장하기 - 회원가입
	public int insertMember(MemberVo vo);
	 
}
