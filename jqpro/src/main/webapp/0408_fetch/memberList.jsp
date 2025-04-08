<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
	//자바기반 list텍스트 기반의 json형식의 문자열 데이터로 직렬화
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();
%>