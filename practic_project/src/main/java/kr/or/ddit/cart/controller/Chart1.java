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

import com.google.gson.Gson;

@WebServlet("/Chart1.do")
public class Chart1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICartService service = CartServiceImpl.getService();

        // 월별 대출/반납/연체 데이터
        List<Map<String, Object>> monthlyStats = service.cartListMap();

        // 전체 정상반납/연체/미반납 데이터
        List<Map<String, Object>> overallStats = service.getOverallStatsMap();

        // 두 데이터를 하나의 맵에 담기
        Map<String, Object> result = new HashMap<>();
        result.put("monthlyStats", monthlyStats);
        result.put("overallStats", overallStats);
        
        //직렬화
        Gson gson = new Gson();
        String jsonData = gson.toJson(result);
        
        // JSON 형태로 응답
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(jsonData);
    }
}
