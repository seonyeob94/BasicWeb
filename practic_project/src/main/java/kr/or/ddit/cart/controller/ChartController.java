package kr.or.ddit.cart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/chartView.do")  // JSP를 forward로 보여주는 경로
public class ChartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 서비스 객체
        ICartService service = CartServiceImpl.getService();

        // 월별 대출/반납/연체 데이터
        List<Map<String, Object>> monthlyStats = service.cartListMap();

        // 전체 정상반납/연체/미반납 데이터
        List<Map<String, Object>> overallStats = service.getOverallStatsMap();

        // 데이터를 request에 담기 (JSP에서 꺼내서 fetch에 사용하거나 바로 출력 가능)
        request.setAttribute("monthlyStats", monthlyStats);
        request.setAttribute("overallStats", overallStats);

        // JSP로 forward (직접 접근은 불가함)
        request.getRequestDispatcher("/WEB-INF/view/admin/loan_return/chart2.jsp").forward(request, response);
    }
}
