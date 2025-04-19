package kr.or.ddit.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.member.vo.MemberVo;

import java.io.IOException;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/Logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session제거
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("loginok");
		
		if(vo != null) {
			session.removeAttribute("loginok");
			session.removeAttribute("check");
		}
		
		//view페이지로 이동  - logpro.jsp
		request.getRequestDispatcher("/start/logpro.jsp").forward(request, response);
	}

}
