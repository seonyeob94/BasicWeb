package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVo;

public interface ILprodService {
	
	/*
	 * //전체리스트 가져오기
	 * parameter : null
	 * result : List<LprodVo> 
	 */
	
	public List<LprodVo> selectAllData();

}
