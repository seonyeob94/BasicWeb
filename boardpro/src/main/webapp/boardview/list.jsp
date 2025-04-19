<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//controller에서 저장한 값 꺼내오기
List<BoardVo> list =(List<BoardVo>)request.getAttribute("list");
int spage = (int)request.getAttribute("spage"); 
int epage = (int)request.getAttribute("epage"); 
int tpage = (int)request.getAttribute("tpage"); 


//직렬화 - json형식의 문자열 데이터
// 또는 html을 이용한 직접 출력
/* 
Gson gson = new GsonBuilder().setPrettyPrinting().create();
String result = gson.toJson(list);

out.print(result);
out.flush();
 */
 
 JsonObject obj = new JsonObject();
 obj.addProperty("sp", spage);
 obj.addProperty("ep", epage);
 obj.addProperty("tp", tpage);
 
 Gson gson = new GsonBuilder().setPrettyPrinting().create();
 JsonElement jlist = gson.toJsonTree(list);
 
 obj.add("datas", jlist);
 
 out.print(obj);
 out.flush();
 
%>