package kr.or.ddit.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

import java.io.IOException;

/**
 * Servlet implementation class HitUpdate
 */
@WebServlet("/HitUpdate.do")
public class HitUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송데이터 받기
		int num = Integer.parseInt(request.getParameter("num"));
		
		
		//service객체 받기
		
		IBoardService service = BoardServiceImpl.getBoardService();
		
		
		// service 메소드 호출 - 결과값 받기
		int res = service.updateHit(num);
		
		// 결과값을 request에 저장
		//view페이지로 이동
		
		//insert, delete, update에서 공통으로 사용
		request.setAttribute("res", res);
						
		request.getRequestDispatcher("/boardview/result.jsp").forward(request, response);
			
		
	}

}
