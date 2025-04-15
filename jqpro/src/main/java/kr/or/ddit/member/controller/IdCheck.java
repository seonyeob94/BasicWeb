package kr.or.ddit.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에서 전송된 데이터 받기
		
		String userId = request.getParameter("mem_id");
		
		//service 객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//메소드 호출
		String result = service.idCheck(userId);
		
		//결과값 저장
		
		request.setAttribute("result", result);
		
		//view페이지 이동
		request.getRequestDispatcher("/0415_ajax/view/idcheck.jsp").forward(request, response);
	}	
}
