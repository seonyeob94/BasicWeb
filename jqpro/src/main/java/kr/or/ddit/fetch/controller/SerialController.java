package kr.or.ddit.fetch.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.fetch.vo.SerialVo;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * Servlet implementation class SerialController
 */
@WebServlet("/Serial.do")
public class SerialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerialController() {
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
		//전송데이터 받기 - 직렬화된 데이터
		String line = null;
		StringBuffer strbuf = new StringBuffer();
		
		BufferedReader reader = request.getReader();
		
		while(true) {
			line = reader.readLine();
			
			if(line == null) break;
			
			strbuf.append(line);
		}
		
		String reqData = strbuf.toString();
		
		//역직렬화 - 자바객체 생성
		Gson gson = new Gson();
		SerialVo vo = gson.fromJson(reqData, SerialVo.class);
		
		//vo.setId('a001') vo.setName("김은대") vo.setEmail("dfsf")
		
		//service객체 얻기
		
		//service메서드 호출 - 결과값 받기
		//--저장한다----
		
		//request에 저장
		request.setAttribute("vo", vo);
		
		//view페이지로 이동
		request.getRequestDispatcher("/0408_fetch/serial.jsp").forward(request, response);
	}

}



