package kr.or.ddit.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.cart.vo.CartVo;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class CartDaoImpl implements ICartDao {
	
	//생성자
	private CartDaoImpl() {};
	
	private static ICartDao dao;
	
	//자기자신의 객체를 생성 - 리턴
	
	public static ICartDao getDao() {
		if(dao ==null) dao = new CartDaoImpl();
		
		return dao;
	}

	@Override
	public List<CartVo> List() {
		SqlSession sql = MybatisUtil.getInstance();
		List<CartVo> list = null;
		
		try {
			list = sql.selectList("cart.cartList");
			
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
	public java.util.List<CartVo> getOverallStats() {
		SqlSession sql = MybatisUtil.getInstance();
		List<CartVo> list = null;
		
		try {
			list = sql.selectList("cart.getOverallStats");
			
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

}
