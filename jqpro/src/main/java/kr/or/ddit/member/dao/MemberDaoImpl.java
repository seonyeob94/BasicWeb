package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVo;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class MemberDaoImpl implements IMemberDao {
	
	//sqlSession - 각 메서드 범위 내로
	
	//생성자
	private MemberDaoImpl() {};
	
	private static IMemberDao dao;
	
	//자기자신의 객체를 생성 - 리턴
	
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}

	@Override
	public List<MemberVo> memberList() {
		
		SqlSession sql = MybatisUtil.getInstance();
		List<MemberVo> list =null;
		
		try {
			
			list = sql.selectList("member.memberList");
			
			
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
	public MemberVo loginMember(MemberVo vo) {
		
		SqlSession sql = MybatisUtil.getInstance();
		MemberVo member =null;
		
		try {
			
			member = sql.selectOne("member.loginMember", vo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sql != null) {
				sql.commit();
				sql.close();
			}
		}
		return member;
	}

	@Override
	public String idCheck(String id) {
		
		SqlSession sql = MybatisUtil.getInstance();
		String member =null;
		
		try {
			
			member = sql.selectOne("member.idCheck", id);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sql != null) {
				sql.commit();
				sql.close();
			}
		}
		return member;
	}

	@Override
	public List<ZipVo> selectByDong(String dong) {
		
		SqlSession sql = MybatisUtil.getInstance();
		List<ZipVo> list =null;
		
		try {
			
			list = sql.selectList("member.selectByDong", dong);
			
			
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
	public int insertMember(MemberVo vo) {
		
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.insert("member.insertMember", vo);
			
			
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
