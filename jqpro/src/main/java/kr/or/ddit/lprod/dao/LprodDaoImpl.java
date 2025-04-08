package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVo;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class LprodDaoImpl implements ILprodDao {
	
	//sqlsession 필요
	//싱클톤 패턴에서 service에서 사용되어질 자신의 dao객체를 생성 - 리턴하는 매서드
	
	private static ILprodDao dao;
	public static ILprodDao getDao() {
		if(dao == null) dao = new LprodDaoImpl();
		
		return dao;
	}
	
	//생성자 
	private LprodDaoImpl() {
		
	}

	@Override
	public List<LprodVo> selectAllData() {

		SqlSession sql = MybatisUtil.getInstance();
		List<LprodVo> list =null;
		
		try {
			
			list = sql.selectList("lprod.selectAllData");
			
			
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
