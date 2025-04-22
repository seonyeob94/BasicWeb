package kr.or.ddit.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVo;

import java.io.IOException;

import com.google.gson.Gson;

/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/ReplyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//전송 직렬화된 데이터 받기
		String reqdata = RequestDataChange.dataChange(request);
		
		//역 직렬화
		Gson gson = new Gson();
		ReplyVo vo = gson.fromJson(reqdata, ReplyVo.class);
		//vo.setRenum(5) vo.setCont("dsjfdiosfh")
		
		IBoardService service = BoardServiceImpl.getBoardService();
		
		int res = service.updateReply(vo);
		
		//insert, delete, update에서 공통으로 사용
		request.setAttribute("res", res);
						
		request.getRequestDispatcher("/boardview/result.jsp").forward(request, response);
			
		
	}

}
