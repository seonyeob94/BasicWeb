<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,java.util.Map" %>
<%@ page import="com.google.gson.Gson,com.google.gson.GsonBuilder" %>
<%
  // Controller 에서 request.setAttribute("list", list) 로 넘겨준 데이터
  List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("list");
  // JSON 으로 변환
  String calendarJson = new GsonBuilder().create().toJson(list);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>반납 예정일 캘린더(ADM04)</title>

  <!-- 1) FullCalendar v5 CSS -->
  <link
    href="${pageContext.request.contextPath}/resource/css/admin/loan_return/main.min.css"
    rel="stylesheet"
  />

  <!-- 2) FullCalendar 기본 스타일 오버라이드 -->
<style>
    /* 일별 그리드(cell) 안의 이벤트 박스 높이 자동, 패딩 여유 있게 */
    .fc-daygrid-event {
      height: auto !important;
      padding: 2px 6px !important;
      overflow: visible !important;
    }

    /* 그리드/리스트 뷰 모두에서 타이틀 줄바꿈 허용 */
    .fc .fc-daygrid-event .fc-event-title,
    .fc .fc-list-event .fc-event-title {
      white-space: normal !important;
      overflow: visible !important;
      text-overflow: clip !important;
    }

    /* 캘린더 전체 레이아웃 */
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
    <span style="display:inline-block;width:20px;height:20px;background-color:lightgreen;margin-right:5px;"></span>
    대출일
    &nbsp;&nbsp;&nbsp;
    <span style="display:inline-block;width:20px;height:20px;background-color:lightcoral;margin-right:5px;"></span>
    반납예정일
  </div>

  <!-- 3) jQuery (필요하다면) -->
  <script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.1.js"></script>
  <!-- 4) FullCalendar v5 JS -->
  <script src="${pageContext.request.contextPath}/resource/js/admin/loan_return/main.min.js"></script>

  <script>
    // 서버에서 넘어온 JSON 배열을 JS 변수에 담기
    const calendarStats = <%=calendarJson%>;
    console.log("캘린더용 데이터:", calendarStats);
	
    console.log( Object.keys(calendarStats[0]) );

    document.addEventListener('DOMContentLoaded', function() {
      const calendarEl = document.getElementById('calendar');

      // FullCalendar 인스턴스 생성 & 한 번에 이벤트 등록
      const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale: 'ko',
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,listWeek'
        },
        eventDisplay: 'block',
        events: calendarStats.flatMap(item => [
          {
            title: `\${item.name} - \${item.bookTitle} 대출`,
            start: item.loanDate,
            allDay: true,
            color: 'lightgreen'
          },
          {
            title: `\${item.name} - \${item.bookTitle} 반납예정`,
            start: item.dueDate,
            allDay: true,
            color: 'lightcoral'
          }
        ])
      });

      calendar.render();
    });
  </script>
</body>
</html>
