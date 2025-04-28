package kr.or.ddit.overdueList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.overdueList.service.IOverdueListService;
import kr.or.ddit.overdueList.service.OverdueListServiceImpl;


@WebServlet("/OverdueList.do")
public class OverdueLIstController extends HttpServlet{
	private IOverdueListService service = OverdueListServiceImpl.getService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1-1) flash 메시지 (warnMsg) 가져오기
        HttpSession session = req.getSession();
        String warnMsg = (String) session.getAttribute("warnMsg");
        if (warnMsg != null) {
            req.setAttribute("warnMsg", warnMsg);
            session.removeAttribute("warnMsg");
        }

        // 1-2) 서비스에서 데이터 조회
        List<Map<String, Object>> list = service.selectBanUserMap();
        req.setAttribute("list", list);

        // 1-3) 레이아웃용 속성 세팅 (loans.jsp를 쓰신다면 그쪽에 맞게 경로 변경)
        req.setAttribute("pageTitle",       "연체자 목록");
        req.setAttribute("breadcrumbTitle", "대출/반납 관리 > 연체/정지 > 연체자 목록");
        req.setAttribute("activeTab",       "overdue");  // loans.jsp 에서 탭 하이라이트용
        req.setAttribute("contentPage",     "/WEB-INF/view/admin/loan_return/overdueList.jsp");

        // 1-4) 공통 레이아웃으로 forward
        req.getRequestDispatcher("/WEB-INF/view/admin/loan_return/overdueList.jsp")
           .forward(req, resp);
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 // 2-1) 파라미터 읽기
        int loanNo = Integer.parseInt(req.getParameter("loanNo"));

        // 2-2) 서비스 호출 (이메일/SMS 전송 + 이력 저장)
        boolean success = service.sendWarning(loanNo);
        
        // 2-3) 처리 결과를 세션에 담아서 flash message 형태로 전달
        HttpSession session = req.getSession();
        String msg = success
            ? "경고 메시지를 발송했습니다."
            : "경고 메시지 발송에 실패했습니다.";
        session.setAttribute("warnMsg", msg);

     // 2-4) 다시 GET으로 목록 조회
        resp.sendRedirect(req.getContextPath() + "/OverdueList.do");
	}
}
