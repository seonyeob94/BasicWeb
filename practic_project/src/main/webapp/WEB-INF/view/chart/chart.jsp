<%@page import="kr.or.ddit.vo.BookLoansVo"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BookLoansVo> list = (List<BookLoansVo>)request.getAttribute("list");
	
	Gson gson  = new GsonBuilder().setPrettyPrinting().create();
	
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();

%>