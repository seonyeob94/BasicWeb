<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 값 꺼내기
MemberVo vo = (MemberVo)request.getAttribute("resVo");

//텍스트기반의 json형식의 문자열 데이터 만들기 - 직렬화 
Gson gson = new Gson();

String result = gson.toJson(vo);

out.print(result);
out.flush();

%>