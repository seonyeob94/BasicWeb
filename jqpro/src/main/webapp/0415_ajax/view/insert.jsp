<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 저장한 이름 꺼내기
	int res = (Integer)request.getAttribute("result");

if(res>0){
%>
	
	{
		"flag" : "가입성공"
	}


<% }else{ %>
	
	{
		"flag" : "가입실패"
	}
	
<%
}
%>