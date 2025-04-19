<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

 <script src="../js/jquery-3.7.1.js"></script>
 <script src="../js/logpro.js"></script>
 
 <script>
 mypath =  '<%= request.getContextPath()%>';
 
 $(function(){
	
	 $(document).on('click', "#login", function(){
		 
		 loginServer();
	 })
	 
	 $(document).on('click', "#logout", function(){
		 
		 logoutServer();
	 })
 })
 </script>

<style>
#check {  color : red;}
</style>

 <%
 //view 페이지
 //세션 로그인 값 - controller에서 저장한 값 가져오기
 	//HttpSession  session2 = request.getSession();
     MemberVo  vo = (MemberVo)session.getAttribute("loginok");
     String check = (String)session.getAttribute("check");
    
  
     
     if(vo == null){
 %>
      <input id="id" type="text" placeholder="id" >&nbsp;&nbsp;
      <input id="pass" type="password" placeholder="password">&nbsp;&nbsp; 
      <button id="login" type="button">로그인</button><br> 
       
     
 <%   }else  if(vo != null ){  %>
    
       <span><%= vo.getMem_id() %>님 환영합니다</span>&nbsp;&nbsp;
       <button id="logout" type="button">로그아웃</button><br>
        
 <%  } %>
  
   <%    
      if(check == "false" ){
  %>
    	  <span id="check">로그인 오류 또는 비회원입니다</span>
  <%
      }
 %> 
 
 
 
 