package kr.or.ddit.cart.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.cart.vo.CartVo;


public interface ICartService {

	public List<Map<String, Object>> cartListMap();
	
	public List<Map<String, Object>> getOverallStatsMap();

}
