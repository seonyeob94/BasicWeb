<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//클라이언트 전송 데이터를 받기 -id, name, email
String userId = request.getParameter("id");
String userName = request.getParameter("name");
String userEmail = request.getParameter("email");

//
//db처리 - insert - 결과값(자바객체 생성)

//결과값을 가지고 텍스트 기반의 json형식 문자열 데이터 만들기- 직렬화

%>

{
	"id" : "<%= userId %>",
	"name" : "<%= userName %>",
	"email" : "<%= userEmail %>"

}































