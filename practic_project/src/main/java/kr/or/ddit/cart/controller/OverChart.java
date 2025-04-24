package kr.or.ddit.cart.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.cart.vo.CartVo;

@WebServlet("/OverallChart.do")
public class OverChart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ICartService service = CartServiceImpl.getService();
		
		List<Map<String, Object>> list = service.getOverallStatsMap();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/chart/loans.jsp").forward(request, response);
	}
}
