package kr.or.ddit.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVo;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

/**
 * Servlet implementation class SelectByDong
 */
@WebServlet("/SelectByDong.do")
public class SelectByDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByDong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송데이타 읽기 - 직렬화된 데이터
		String reqData = FetchDataChange.dataChange(request);
		
		System.out.println("reqData====" + reqData);
		//{dong : "둔산"} - 
		
		// 역직렬화 - 자바 객체로 변환
		Gson gson = new Gson();
		ZipVo vo = gson.fromJson(reqData, ZipVo.class);
		//vo.setDong("둔산") - 자동실행
		
		//service 객체
		IMemberService service = MemberServiceImpl.getService();
		
		List<ZipVo> list = service.selectByDong(vo.getDong());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/0415_ajax/view/dongList.jsp").forward(request, response);
		
		
		
		
	}

}
