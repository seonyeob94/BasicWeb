package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;
import kr.or.ddit.board.vo.ReplyVo;

public interface IBoardDao {
	
	
	// public 리턴결과형 메소드이름(매개변수타입 변수명)
		//리스트 출력
		public List<BoardVo> selectBypage(Map<String, Object> map);
		
		//글쓰기
		public int insertBoard(BoardVo vo);
		
		// 글수정
		public int updateBoard(BoardVo vo);
		
		// 글삭제
		public int deleteBoard(int num);
		
		// 조회수 증가
		public int updateHit(int num);
		
		//댓글쓰기
		public int insertReply(ReplyVo vo);
		
		//댓글삭제
		public int deleteReply(int num);
		
		//댓글수정
		public int updateReply(ReplyVo vo);
		
		//댓글리스트
		public List<ReplyVo> listReply(int bonum);
		
		//전체 글갯수
		public int countListBoard(Map<String, Object> map);
		
		
}
