<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

List<ZipVo> list = (List<ZipVo>)request.getAttribute("list");

//list 자바 객체를 json 문자열 데이터로 직렬화
Gson gson = new GsonBuilder().setPrettyPrinting().create();

String result = gson.toJson(list);

out.print(result);
out.flush();
%>