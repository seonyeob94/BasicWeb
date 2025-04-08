package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVo;

public class LprodServiceIpl implements ILprodService {
	
	/*
	 * dao메소드 호출 - dao 객체가 필요 - 생성자에서 dao객체를 얻어오기
	 * 
	 * 싱클톤에서 사용되어질 자신의 객체를 생성하고 리턴하는 매소드
	 * 
	 */
	
	private ILprodDao dao;
	private static ILprodService service;
	
	//생성자
	private LprodServiceIpl() {
		dao = LprodDaoImpl.getDao();
	}
	public static ILprodService getService() {
		if(service == null) service = new LprodServiceIpl();
		
		return service;
	}

	@Override
	public List<LprodVo> selectAllData() {
		/*
		 * List<LprodVo> list = null;
		 * 
		 * list = dao.selectAllData();
		 * 
		 * return list;
		 */
		
		return dao.selectAllData();
	}

}
