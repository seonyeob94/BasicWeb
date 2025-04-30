package kr.or.ddit.damageBook.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DamagedLostBookVo;

public interface IDamageBookService {
	
	public List<Map<String, Object>> damageBookList();
	
	public int damageInsert(DamagedLostBookVo vo);
	
	public int updateDamage();
}
