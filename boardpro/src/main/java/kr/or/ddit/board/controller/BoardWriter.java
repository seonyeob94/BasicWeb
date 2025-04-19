package kr.or.ddit.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;

import java.io.IOException;

import com.google.gson.Gson;

/**
 * Servlet implementation class BoardWriter
 */
@WebServlet("/BoardWriter.do")
public class BoardWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//직렬화 데이터 읽기
		
		String reqData = RequestDataChange.dataChange(request);
		
		System.out.println("reqData =="+reqData);
		
		//역직렬화 - 자바객체 boardVo로 변환
		Gson gson = new Gson();
		BoardVo vo = gson.fromJson(reqData, BoardVo.class);
		//자동실행 vo.setWriter("")...
		//글쓴 사람의 IP저장
		vo.setWip(request.getRemoteAddr());
		
		IBoardService service = BoardServiceImpl.geBoardService();
		
		int res = service.insertBoard(vo);
		
		//insert. delete, update에서 공통으로 사용
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/boardview/result.jsp").forward(request, response);
	}

}
