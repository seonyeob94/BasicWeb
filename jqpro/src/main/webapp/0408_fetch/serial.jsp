<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.fetch.vo.SerialVo"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//controller에서 저장한 데이터 꺼내기

SerialVo vo = (SerialVo)request.getAttribute("vo");

//vo자바 객체를 직렬화
Gson gson = new Gson();

String result = gson.toJson(vo);

out.print(result);
out.flush();
%>
