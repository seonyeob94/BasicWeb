package kr.or.ddit.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVo;

import java.io.IOException;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;

import com.google.gson.Gson;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송데이타 받기 - 직렬화된 데이터
		String reqData = FetchDataChange.dataChange(request);
		System.out.println("reqData---"+reqData);
		
		//역직렬화
		Gson gson = new Gson();
		MemberVo vo = gson.fromJson(reqData, MemberVo.class);
		
		//service 객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//service 메소드 호출하기 - 결과값 받기
		
		int result = service.insertMember(vo);
		
		//request에 저장하기
		request.setAttribute("result", result);
		
		//view페이지로 이동/0414_ajax/view/insert.jsp
		request.getRequestDispatcher("/0415_ajax/view/insert.jsp").forward(request, response);
	}

}
