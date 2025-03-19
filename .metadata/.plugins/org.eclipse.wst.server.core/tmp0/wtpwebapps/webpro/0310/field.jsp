<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSP : Java Server Page</h1>

<%
//입력한 내용을 가져온다
  String userName = request.getParameter("name");
  String userTel = request.getParameter("tel");
%>

<%= userName %>
<%= userTel %>

</body>
</html>