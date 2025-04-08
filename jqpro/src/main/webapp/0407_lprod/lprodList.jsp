<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
 //controller에서 저장한 데이터 꺼내기
 List<LprodVo> list = (List<LprodVo>)request.getAttribute("list");

 //json형식의 문자열 데이터 만들기
 //list 자바 객체를 json 형식의 문자열 데이터 직렬화
 
 Gson gson = new GsonBuilder().setPrettyPrinting().create();
 String result = gson.toJson(list);
 
 out.print(result);
 out.flush();
 
%>