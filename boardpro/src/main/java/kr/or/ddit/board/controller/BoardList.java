package kr.or.ddit.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PSearchVo;
import kr.or.ddit.board.vo.PageVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//클라이언트 전송데이타 받기 - page, stype, sword - 직렬화된 데이타
		
		String reqData = RequestDataChange.dataChange(request);
		
		
		//역직렬화
		Gson gson = new Gson();
		PSearchVo psvo = gson.fromJson(reqData, PSearchVo.class);
		//psvo.setPage(1) psvo.setStype("") psvo.setSword("")
		
		//service객체 얻기
		IBoardService service = BoardServiceImpl.geBoardService();
		
		
		//service매서드 호출
		PageVo pvo = 
			service.getPageInfo(psvo.getPage(), psvo.getStype(), psvo.getSword());
		
		//리턴된 값 start, end, startpage, endpage, totalpage
		
		// 페이지리스트 가져오기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", psvo.getStype());
		map.put("sword", psvo.getSword());
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
		
		List<BoardVo> list = service.selectBypage(map);
		//3개의 게시판 글을 가져온다
		
		//
		request.setAttribute("list", list);
		request.setAttribute("spage", pvo.getStartPage());
		request.setAttribute("epage", pvo.getEndPage());
		request.setAttribute("tpage", pvo.getTotalPage());
		
		request.getRequestDispatcher("/boardview/list.jsp").forward(request, response);
		
	}

}
