package kr.or.ddit.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVo;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//클라언트 전송데이터 받기- mem_id, mem_pass
		/*
		//1. parameter방식 promise 전송시 실행
		String userId = request.getParameter("mem_id");
		String userPass = request.getParameter("mem_pass");
		
		MemberVo vo  = new MemberVo();
		vo.setMem_id(userId);
		vo.setMem_pass(userPass);
		*/
		
		//2. 직렬화 방식 - buffedReder로 읽기 - 역직렬화(fromJSON)
		//fetch 전송시 실행{mem_id : "x001", mem_pass : "0000"}
		String reqData = FetchDataChange.dataChange(request);
		
		System.out.println("reqData====="+reqData);
		
		//역직렬화 - 자바객체 생성
		Gson gson = new Gson();
		MemberVo vo = gson.fromJson(reqData, MemberVo.class);
		//자동실행 vo.setMem_id('x001'); vo.setMem_pass('0000');
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//service 메소드 호출하기
		MemberVo resVo = service.loginMember(vo);
				
		//결과값을 request에 저장
		
		request.setAttribute("resVo", resVo);
		
		//view페이지 이동
		request.getRequestDispatcher("/0409_async_await/loginpro.jsp").forward(request, response);
	}
	

}
