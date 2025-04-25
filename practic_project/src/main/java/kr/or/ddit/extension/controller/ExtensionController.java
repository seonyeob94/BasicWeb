package kr.or.ddit.extension.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.extension.service.ExtensionServiceImpl;
import kr.or.ddit.extension.service.IExtensionService;
import kr.or.ddit.vo.BookLoanApprovalVo;

@WebServlet("/Extension/*")
public class ExtensionController extends HttpServlet{
	private IExtensionService service = ExtensionServiceImpl.getIExtensionService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		if("/list".equals(path)) {
			List<Map<String, Object>> map = service.extentionListMap();
			
			req.setAttribute("map", map);
			req.getRequestDispatcher("/WEB-INF/view/extionsion/list.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		if("/approve".equals(path)) {
			BookLoanApprovalVo vo = new BookLoanApprovalVo();
			vo.setApprovedBy(Integer.parseInt(req.getParameter("extionsion")));
			vo.setApprovalNo(Integer.parseInt(req.getParameter("approvalNo")));
			
			boolean ok = service.approveExtension(vo);
			
			String msg = ok ? "연장신청이 승인되었습니다."
					        : "연장신청 승인처리가 실패했습니다.";
			
			req.getSession().setAttribute("msg", msg);
			
			resp.sendRedirect(req.getContextPath() +"/extionsion/list");
			return;
			
		}
		else if("/reject".equals(path)) {
			BookLoanApprovalVo vo = new BookLoanApprovalVo();
			vo.setApprovedBy(Integer.parseInt(req.getParameter("extionsion")));
			vo.setApprovalNo(Integer.parseInt(req.getParameter("approvalNo")));
			
			service.rejectLoanExtension(vo);
		}
		
		resp.sendRedirect(req.getContextPath() + "/extionsion/list");
		
	}
}
