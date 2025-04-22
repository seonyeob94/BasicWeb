package kr.or.ddit.cart.service;

import java.util.List;

import kr.or.ddit.cart.dao.CartDaoImpl;
import kr.or.ddit.cart.dao.ICartDao;
import kr.or.ddit.cart.vo.CartVo;
import kr.or.ddit.loanStats.dao.ILoansDao;

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
	public List<CartVo> List() {
		// TODO Auto-generated method stub
		return dao.List();
	}

	@Override
	public java.util.List<CartVo> getOverallStats() {
		// TODO Auto-generated method stub
		return dao.getOverallStats();
	}

}
