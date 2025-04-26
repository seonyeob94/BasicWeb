<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.GsonBuilder" %>

<%
    List<Map<String, Object>> monthlyStats = (List<Map<String, Object>>) request.getAttribute("monthlyStats");
    List<Map<String, Object>> overallStats = (List<Map<String, Object>>) request.getAttribute("overallStats");

    Gson gson = new GsonBuilder().create();
    String monthlyJson = gson.toJson(monthlyStats);
    String overallJson = gson.toJson(overallStats);
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Chart1 - JSP 통합</title>
  <script src="<%=request.getContextPath()%>/resource/js/jquery-3.7.1.js"></script>
  <script src="<%=request.getContextPath()%>/resource/js/admin/loan_return/chart.umd.min.js"></script>

  <style>
    #myChart, #myChart1 {
      width: 400px;
      height: 200px;
    }
    body {
      font-family: 'Arial', sans-serif;
    }
  </style>

  <script>
    const monthlyStats = <%= monthlyJson %>;
    const overallStats = <%= overallJson %>;

    let myChart, myChart1;

    $(function () {
      // 1️⃣ 막대 차트
      const ctx = document.getElementById('myChart').getContext('2d');
      myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: monthlyStats.map(item => item.MONTHNO),
          datasets: [
            {
              label: '월별 대출 건수',
              data: monthlyStats.map(item => item.TOTALLOANS),
              backgroundColor: 'rgba(54, 162, 235, 0.6)'
            },
            {
              label: '반납 건수',
              data: monthlyStats.map(item => item.TOTALRETURNS),
              backgroundColor: 'rgba(75, 192, 192, 0.6)'
            },
            {
              label: '연체 건수',
              data: monthlyStats.map(item => item.OVERDUERETURNS),
              backgroundColor: 'rgba(255, 99, 132, 0.6)'
            }
          ]
        },
        options: {
          responsive: false,
          scales: {
            y: { beginAtZero: true }
          }
        }
      });

      // 2️⃣ 파이 차트
      const ctx1 = document.getElementById('myChart1').getContext('2d');
      const stats = overallStats[0];
      const values = [
        stats.ONTIMERETURNS,
        stats.OVERDUERETURNS,
        stats.NOTRETURNED
      ];

      myChart1 = new Chart(ctx1, {
        type: 'pie',
        data: {
          labels: ["정상반납", "연체", "미반납"],
          datasets: [{
            data: values,
            backgroundColor: [
              'rgba(54, 162, 235, 0.6)',
              'rgba(75, 192, 192, 0.6)',
              'rgba(255, 99, 132, 0.6)'
            ]
          }]
        },
        options: {
          responsive: false
        }
      });
    });
  </script>
</head>

<body>
  <h2>📊 대출/반납/연체 월별 통계</h2>
  <canvas id="myChart"></canvas><br><br>

  <h2>📈 반납 상태(정상/연체/미반납) 비율</h2>
  <canvas id="myChart1"></canvas>
</body>
</html>
