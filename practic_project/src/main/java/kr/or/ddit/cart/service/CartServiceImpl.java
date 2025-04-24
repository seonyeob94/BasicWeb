package kr.or.ddit.cart.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.cart.dao.CartDaoImpl;
import kr.or.ddit.cart.dao.ICartDao;
import kr.or.ddit.cart.vo.CartVo;


public class CartServiceImpl implements ICartService {
	
	//dao 객체 필요
	private ICartDao dao;
	
	private CartServiceImpl() {
		dao = CartDaoImpl.getDao();
	}
	
	//자신의 객체 생성 리턴
	private static ICartService service;
	public static ICartService getService() {
		if(service == null) service = new CartServiceImpl();
		
		return service;
	}


	@Override
	public List<Map<String, Object>> cartListMap() {
		// TODO Auto-generated method stub
		return dao.cartListMap();
	}

	@Override
	public List<Map<String, Object>> getOverallStatsMap() {
		// TODO Auto-generated method stub
		return dao.getOverallStatsMap();
	}

}
