package kr.or.ddit.notiBan.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.notiBan.service.INotiBanService;
import kr.or.ddit.notiBan.service.NotiBanServiceImpl;

@WebServlet("/NotiBan.do")
public class NotiBanController extends HttpServlet{
	private INotiBanService service = NotiBanServiceImpl.getService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // 1) 건수
        int dueCount     = service.countDueNotifications();
        int overdueCount = service.countOverdueNotifications();

        // 2) 상세 리스트
        List<Map<String,Object>> dueList     = service.listDueNotifications();
        List<Map<String,Object>> overdueList = service.listOverdueNotifications();

        // 3) JSP 로 전달
        req.setAttribute("dueCount",     dueCount);
        req.setAttribute("overdueCount", overdueCount);
        req.setAttribute("dueList",      dueList);
        req.setAttribute("overdueList",  overdueList);

        // ← 이 한 줄을 추가!
        req.setAttribute("pageTitle", "알림 발송 & 이력");
        
        // 4) 바로 notiBan.jsp 로 포워드
        req.getRequestDispatcher("/WEB-INF/view/admin/loan_return/notiBan.jsp")
           .forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 어떤 버튼을 눌렀는지(type=due 또는 overdue)
        String type = req.getParameter("type");
        boolean ok;
        if ("due".equals(type)) {
            ok = service.sendDueReminders();
            req.getSession().setAttribute("msg",
                ok ? "반납예정 알림 발송이 완료되었습니다."
                   : "반납예정 알림 발송 중 오류가 발생했습니다.");
        } else {
            ok = service.sendOverdueAlerts();
            req.getSession().setAttribute("msg",
                ok ? "연체 경고 발송이 완료되었습니다."
                   : "연체 경고 발송 중 오류가 발생했습니다.");
        }

        // 완료 후 다시 이 페이지를 새로 로드해서 결과 확인
        resp.sendRedirect(req.getContextPath() + "/NotiBan.do");
	}
}
