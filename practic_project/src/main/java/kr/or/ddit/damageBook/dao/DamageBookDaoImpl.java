package kr.or.ddit.damageBook.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.DamagedLostBookVo;

public class DamageBookDaoImpl implements IDamageBookDao {
	
	
	//생성자
	private DamageBookDaoImpl() {};
	private static IDamageBookDao dao;
	
	//자기자신의 객체를 생성 - 리턴
	public static IDamageBookDao getDao() {
		if(dao == null) dao = new DamageBookDaoImpl();
		
		return dao;
	}
	
	@Override
	public int damageInsert(DamagedLostBookVo vo) {
		
		SqlSession sql = MybatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt =sql.insert("damage.damageInsert",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sql != null) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public List<Map<String, Object>> damageBookList() {

		SqlSession sql = MybatisUtil.getInstance();
		List<Map<String, Object>> list = null;
		try {
			list =sql.selectList("damage.damageBookList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sql != null) {
				sql.commit();
				sql.close();
			}
		}
		
		return list;
	}

	@Override
	public int updateDamage() {

		SqlSession sql = MybatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt =sql.update("damage.updateDamage");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sql != null) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

}
