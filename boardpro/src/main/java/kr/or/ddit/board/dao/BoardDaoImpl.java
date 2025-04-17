package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;
import kr.or.ddit.board.vo.ReplyVo;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class BoardDaoImpl implements IBoardDao {
	

	//생성자 
	private BoardDaoImpl() {};
	private static IBoardDao dao;
	
	//자기자신의 객체를 생성 - 리턴
	
	public static IBoardDao getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		
		return dao;
	}

	@Override
	public List<BoardVo> selectBypage(Map<String, Object> map) {
		SqlSession sql = MybatisUtil.getInstance();
		List<BoardVo> list =null;
		
		try {
			
			list = sql.selectList("board.selectBypage", map);
			
			
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
	public int insertBoard(BoardVo vo) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.insert("board.insertBoard", vo);
			
			
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
	public int updateBoard(BoardVo vo) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.update("board.updateBoard", vo);
			
			
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
	public int deleteBoard(int num) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.delete("board.deleteBoard", num);
			
			
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
	public int updateHit(int num) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.update("board.updateHit", num);
			
			
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
	public int insertReply(ReplyVo vo) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.insert("reply.insertReply", vo);
			
			
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
	public int deleteReply(int num) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.delete("reply.deleteReply", num);
			
			
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
	public int updateReply(ReplyVo vo) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.update("reply.updateReply", vo);
			
			
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
	public List<ReplyVo> listReply(int bonum) {
		SqlSession sql = MybatisUtil.getInstance();
		List<ReplyVo> list =null;
		
		try {
			
			list = sql.selectList("reply.listReply", bonum);
			
			
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
	public int countListBoard(Map<String, Object> map) {
		SqlSession sql = MybatisUtil.getInstance();
		int list =0;
		
		try {
			
			list = sql.selectOne("board.countListBoard", map);
			
			
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
