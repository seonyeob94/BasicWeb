package kr.or.ddit.board.service;

import java.util.HashMap;
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
	public static IBoardService getBoardService() {
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
		
		// 전체 글 갯수 가져오기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		
		int count = this.countListBoard(map);
		
		// 전체 페이지 수 구하기
		int plist = PageVo.getPerList();
		
		int totalPage = (int)Math.ceil((double)count / plist);
		
		// 페이지별 게시판 리스트 가져오기 정보 구하기
		//start, end, startpage, endpage
		int start = (page-1)*plist + 1;
		int end = start+plist -1;
		if(end > count) end= count;
		
		//startpage, endpage
		int ppage = PageVo.getPerPage();
		int startPage = ((page-1) / ppage * ppage) +1;
		int endPage = startPage + ppage -1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		PageVo pvo = new PageVo();
		pvo.setStart(start);
		pvo.setEnd(end);
		pvo.setStartPage(startPage);
		pvo.setEndPage(endPage);
		pvo.setTotalPage(totalPage);
		
		return pvo;
	}

}
