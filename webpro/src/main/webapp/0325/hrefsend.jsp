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
  String userId = request.getParameter("id");

  out.print(userId);
  

%>
<br>
<br>
<%= userId %>
</body>
</html>