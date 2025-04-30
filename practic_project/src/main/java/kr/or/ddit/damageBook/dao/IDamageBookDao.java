package kr.or.ddit.damageBook.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DamagedLostBookVo;

public interface IDamageBookDao {

	public List<Map<String, Object>> damageBookList();
	
	public int damageInsert(DamagedLostBookVo vo);
	
	public int updateDamage();
}
