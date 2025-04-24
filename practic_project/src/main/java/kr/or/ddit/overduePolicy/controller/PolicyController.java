package kr.or.ddit.overduePolicy.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.overduePolicy.service.IPolicyService;
import kr.or.ddit.overduePolicy.service.PolicyServiceImpl;
import kr.or.ddit.vo.OverduePolicyVo;


@WebServlet("/Policy/*")
public class PolicyController extends HttpServlet{
	private IPolicyService service = PolicyServiceImpl.getIPolicyService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		if("/list".equals(path)) {
			List<OverduePolicyVo> list = service.policyList();
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("/WEB-INF/view/policy/list.jsp").forward(req, resp);
			return;
		}
		else if("/update".equals(path)) {
			int policyNo = Integer.parseInt(req.getParameter("policyNo"));
			OverduePolicyVo vo = service.getPolicy(policyNo);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/view/policy/update.jsp").forward(req, resp);
			
			return;
		}
		resp.sendError(404);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
			
		if("/insert".equals(path)) {
			OverduePolicyVo vo = new OverduePolicyVo();
			
			vo.setDays(Integer.parseInt(req.getParameter("days")));
			vo.setExcludeWeekend(req.getParameter("excludeWeekend"));
			vo.setIsActive(req.getParameter("isActive"));
			
			if("Y".equals(vo.getIsActive())) {
				service.insertAndApply(vo);
			}else {
				
				service.policyInsert(vo);
			}
			
		}
		else if("/activate".equals(path)) {
			int policyNo = Integer.parseInt(req.getParameter("policyNo"));
			
			service.policyApply(policyNo);
			
		}
		else if("/delete".equals(path)) {
			
			int policyNo = Integer.parseInt(req.getParameter("policyNo"));
			
			service.policyDelete(policyNo);
			
		}
		else if("/update".equals(path)) {
				
			OverduePolicyVo vo = new OverduePolicyVo();
		
			vo.setPolicyNo(Integer.parseInt(req.getParameter("policyNo")));
			vo.setDays(Integer.parseInt(req.getParameter("days")));
			vo.setExcludeWeekend(req.getParameter("excludeWeekend"));
			vo.setNote(req.getParameter("note"));
			
			service.policyUpdate(vo);
			
		}
        resp.sendRedirect(req.getContextPath() + "/Policy/list");
	}
}
