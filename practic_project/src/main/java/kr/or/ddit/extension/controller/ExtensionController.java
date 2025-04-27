package kr.or.ddit.extension.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.extension.service.ExtensionServiceImpl;
import kr.or.ddit.extension.service.IExtensionService;
import kr.or.ddit.vo.BookLoanApprovalVo;
import kr.or.ddit.vo.UsersVo;

@WebServlet("/Extension/*")
public class ExtensionController extends HttpServlet{
	private IExtensionService service = ExtensionServiceImpl.getService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String path = req.getPathInfo();
	        if ("/list".equals(path)) {
	            List<Map<String, Object>> list = service.extensionListMap();
	            req.setAttribute("list", list);
	            req.getRequestDispatcher("/WEB-INF/view/extension/extensionList.jsp")
	               .forward(req, resp);
	        } else {
	            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 컨트롤러 doPost 맨 앞에 삽입 (테스트 전용)
		UsersVo admin = new UsersVo();
		admin.setUserNo(4);       // DB에 존재하는 관리자 userNo
		admin.setRole("ADMIN");
		req.getSession().setAttribute("loginUser", admin);

		
		
		// 세션에서 로그인한 관리자 정보 꺼내기
        UsersVo loginUser = (UsersVo) req.getSession().getAttribute("loginUser");
        
       // if (loginUser == null || !"ADMIN".equals(loginUser.getRole())) {
       //     resp.sendError(HttpServletResponse.SC_FORBIDDEN);
       //     return;
       // }
        
        int adminId = loginUser.getUserNo();

        String path = req.getPathInfo();
        
		if("/approve".equals(path)) {
			int approvalNo = Integer.parseInt(req.getParameter("approvalNo"));
            BookLoanApprovalVo vo = new BookLoanApprovalVo();
            vo.setApprovalNo(approvalNo);
            vo.setApprovedBy(adminId);

            boolean ok = service.approveExtension(vo);
            req.getSession().setAttribute("msg",
                ok ? "연장신청이 승인되었습니다." : "연장신청 승인 처리가 실패했습니다.");

            resp.sendRedirect(req.getContextPath() + "/Extension/list");
        
		}
		else if("/reject".equals(path)) {
			 int approvalNo = Integer.parseInt(req.getParameter("approvalNo"));
	            BookLoanApprovalVo vo = new BookLoanApprovalVo();
	            vo.setApprovalNo(approvalNo);
	            vo.setApprovedBy(adminId);

	            service.rejectLoanExtension(vo);
	            req.getSession().setAttribute("msg", "연장신청이 반려되었습니다.");

	            resp.sendRedirect(req.getContextPath() + "/Extension/list");
	        }
	        else {
	            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
		
	}
}
