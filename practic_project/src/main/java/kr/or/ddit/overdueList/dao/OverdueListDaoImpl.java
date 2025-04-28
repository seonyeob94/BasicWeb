package kr.or.ddit.overdueList.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;

public class OverdueListDaoImpl implements IOverdueListDao {
	
	//생성자
	private OverdueListDaoImpl() {};
	private static IOverdueListDao dao;
	
	// 자기자신의 객체를 생성 - 리턴
	
	public static IOverdueListDao getDao() {
		if(dao == null) dao = new OverdueListDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<Map<String, Object>> selectBanUserMap() {
		SqlSession sql = MybatisUtil.getInstance();
		List<Map<String, Object>> list =null;
		
		try {
			list = sql.selectList("notiBan.selectBanUserMap");
			
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
	public Map<String, Object> selectLoanContact(int loanNo) {
		SqlSession sql = MybatisUtil.getInstance();
		Map<String, Object> list =null;
		
		try {
			list = sql.selectOne("notiBan.selectLoanContact");
			
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
	public int insertWarningHistory(int loanNo) {
		SqlSession sql = MybatisUtil.getInstance();
		int cnt =0;
		
		try {
			cnt = sql.insert("notiBan.insertWarningHistory");
			
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
