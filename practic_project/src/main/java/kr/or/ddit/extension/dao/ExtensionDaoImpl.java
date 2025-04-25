package kr.or.ddit.extension.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.BookLoanApprovalVo;

public class ExtensionDaoImpl implements IExtensionDao {
	
	//생성자 
	private ExtensionDaoImpl() {};
	private static IExtensionDao dao;
	
	//자기자신의 객체를 생성 - 리턴
	public static IExtensionDao getDao() {
		if(dao == null) dao  = new ExtensionDaoImpl();
		
		return dao;
	}

	@Override
	public List<Map<String, Object>> extentionListMap() {

		SqlSession sql = MybatisUtil.getInstance();
		List<Map<String, Object>> list = null;
		try {
			list =sql.selectList("extension.extentionListMap");
			
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
	public int approveLoanExtension(BookLoanApprovalVo vo) {
		
		SqlSession sql = MybatisUtil.getInstance();
		int list = 0;
		try {
			list =sql.update("extension.approveLoanExtension");
			
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
	public int extendDueDate(BookLoanApprovalVo vo) {
		
		SqlSession sql = MybatisUtil.getInstance();
		int list = 0;
		try {
			list =sql.update("extension.extendDueDate");
			
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
	public int rejectLoanExtension(BookLoanApprovalVo vo) {

		SqlSession sql = MybatisUtil.getInstance();
		int list = 0;
		try {
			list =sql.update("extension.rejectLoanExtension");
			
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
