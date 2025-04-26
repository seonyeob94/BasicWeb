<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");
	
	Gson gson = new GsonBuilder().create();
	String calendarJson = gson.toJson(list);
	
%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>반납 예정일 캘린더</title>

  <!-- FullCalendar v5 CDN (v6은 모듈 전용 환경이라 HTML에 직접 쓰기 불편함) -->
  <link href="<%=request.getContextPath()%>/resource/css/admin/loan_return/main.min.css" rel="stylesheet" />
  <script src="<%=request.getContextPath()%>/resource/js/admin/loan_return/main.min.js"></script>
  <!-- jQuery CDN 또는 로컬 파일 (아래는 예시) -->
  <script src="<%=request.getContextPath()%>/resource/js/jquery-3.7.1.js"></script>
  
  <script>
  const calendarStats = <%=calendarJson%>
  console.log("데이터 확인 : ", calendarStats);

  let calendar;
    $(function(){
        console.log("문서 준비 & 스크립트 실행됨!"); 
        
      const calendarEl = document.getElementById('calendar');
      
      
      calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale: 'ko',
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,listWeek'
        }
       
      });
      calendar.render();
  		
      calendarStats.forEach(item =>{
    	 //대출일(초록색)
    	 calendar.addEvent({
    		title : `${item.name} - ${item.bookTitle} 대출`,
    		start : item.loanDate,
    		allDay : true,
    		color : 'lightgreen'
    	 });
    	 
    	 //반납예정일(분홍색)
    	 calendar.addEvent({
    		 title : `${item.name} - ${item.bookTitle} 반납예정`,
    		 start : item.dueDate,
    		 allDay : true,
    		 color : 'lightcoral'
    	 })
      });
    
    });
    
    
  </script>

  <style>
    #calendar {
      max-width: 900px;
      margin: 40px auto;
      height: 600px;
    }
  </style>
</head>
<body>
  <h2 style="text-align:center;">📚 반납 예정일 확인 캘린더(ADM04)</h2>
  <div id="calendar"></div>
  
  <div style="text-align:center; margin-top:20px;">
    <span style="display:inline-block; width:20px; height:20px; background-color:lightgreen; margin-right:5px;"></span> 대출일
    &nbsp;&nbsp;&nbsp;
    <span style="display:inline-block; width:20px; height:20px; background-color:lightcoral; margin-right:5px;"></span> 반납예정일
  </div>
  
</body>
</html>
