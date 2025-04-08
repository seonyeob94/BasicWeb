package kr.or.ddit.lprod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceIpl;
import kr.or.ddit.lprod.vo.LprodVo;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class LProdList
 */
@WebServlet("/LProdList.do")
public class LProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LProdList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//직렬화된 데이터를 클라이언트에서 가져온다

		//자바 객체로 역직렬화 한다 fromJSON()

		//service 객체 얻기
		ILprodService service = LprodServiceIpl.getService();
		
		// service 메소드 호출 - 결과값 받기
		List<LprodVo> list = service.selectAllData();
		
		// 결과값을 request에 저장
		request.setAttribute("list", list);
		
		// view 페이지로 이동
		request.getRequestDispatcher("/0407_lprod/lprodList.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
