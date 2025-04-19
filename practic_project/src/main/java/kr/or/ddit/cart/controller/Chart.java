package kr.or.ddit.cart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.cart.vo.CartVo;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class LoanChart
 */
@WebServlet("/Chart.do")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 전송데이터 받기
		//service객체 얻기
		ICartService service = CartServiceImpl.getService();
		
		List<CartVo> list = service.List();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/0414_practice_projec/view/loans.jsp").forward(request, response);
	}

	

}
