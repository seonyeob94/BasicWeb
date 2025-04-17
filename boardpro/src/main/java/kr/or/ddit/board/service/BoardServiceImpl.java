package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;
import kr.or.ddit.board.vo.ReplyVo;

public class BoardServiceImpl implements IBoardService {


	//dao 객체 필요
	private IBoardDao dao;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	//자신의 객체 생성 리턴
	
	private static IBoardService service;
	public static IBoardService geBoardService() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}
	
	
	@Override
	public List<BoardVo> selectBypage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectBypage(map);
	}

	@Override
	public int insertBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(num);
	}

	@Override
	public int updateHit(int num) {
		// TODO Auto-generated method stub
		return dao.updateHit(num);
	}

	@Override
	public int insertReply(ReplyVo vo) {
		// TODO Auto-generated method stub
		return dao.insertReply(vo);
	}

	@Override
	public int deleteReply(int num) {
		// TODO Auto-generated method stub
		return dao.deleteReply(num);
	}

	@Override
	public int updateReply(ReplyVo vo) {
		// TODO Auto-generated method stub
		return dao.updateReply(vo);
	}

	@Override
	public List<ReplyVo> listReply(int bonum) {
		// TODO Auto-generated method stub
		return dao.listReply(bonum);
	}

	@Override
	public int countListBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countListBoard(map);
	}

	@Override
	public PageVo getPageInfo(int page, String stype, String sword) {
		// TODO Auto-generated method stub
		return null;
	}

}
