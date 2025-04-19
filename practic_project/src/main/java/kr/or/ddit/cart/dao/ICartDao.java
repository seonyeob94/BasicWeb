package kr.or.ddit.cart.dao;

import java.util.List;

import kr.or.ddit.cart.vo.CartVo;
import kr.or.ddit.loanStats.vo.LoansVo;

public interface ICartDao {
	
	public List<CartVo> List();

}
