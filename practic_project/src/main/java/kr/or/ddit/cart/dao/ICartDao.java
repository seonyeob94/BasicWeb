package kr.or.ddit.cart.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.cart.vo.CartVo;


public interface ICartDao {
	

	public List<Map<String, Object>> cartListMap();
	
	public List<Map<String, Object>> getOverallStatsMap();

}
