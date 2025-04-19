package kr.or.ddit.board.controller;



import java.io.BufferedReader;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class RequestDataChange {
	
	public static String dataChange(HttpServletRequest request) {
		String line = null;
		StringBuffer strbuf = new StringBuffer();
		BufferedReader reader =null;
		try {
			reader = request.getReader();
			
			while(true) {
				line = reader.readLine();
				
				if(line == null) break;
				
				strbuf.append(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		String reqData = strbuf.toString();
		return reqData;
	}
}
