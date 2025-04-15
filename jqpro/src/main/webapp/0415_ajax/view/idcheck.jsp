<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//controller 에서 저장한 데이터 꺼내기
String res = (String)request.getAttribute("result");

if(res == null){
%>
	
	{
		"flag" : "사용 가능 아이디"
	}


<% }else{ %>
	
	{
		"flag" : "사용 불가능 아이디"
	}
	
<%
}
%>
